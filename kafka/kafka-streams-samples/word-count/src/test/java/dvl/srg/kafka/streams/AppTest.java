package dvl.srg.kafka.streams;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.TopologyTestDriver;
import org.apache.kafka.streams.test.ConsumerRecordFactory;
import org.apache.kafka.streams.test.OutputVerifier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    TopologyTestDriver testDriver;

    StringSerializer stringSerializer = new StringSerializer();

    ConsumerRecordFactory<String, String> recordFactory =
            new ConsumerRecordFactory<>(stringSerializer, stringSerializer);

    @BeforeEach
    public void setUpTopologyTestDriver(){
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "test");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        App wordCountApp = new App();
        Topology topology = wordCountApp.createTopology();
        testDriver = new TopologyTestDriver(topology, config);
    }

    @AfterEach
    public void closeTestDriver(){
        testDriver.close();
    }

    public void pushNewInputRecord(String value){
        testDriver.pipeInput(recordFactory.create(App.WORD_COUNT_INPUTT_TOPIC, null, value));
    }

    public ProducerRecord<String, Long> readOutput(){
        return testDriver.readOutput(App.WORD_COUNT_OUTPUTT_TOPIC, new StringDeserializer(), new LongDeserializer());
    }

    @Test
    public void makeSureCountsAreCorrect(){
        String firstExample = "testing Kafka Streams";
        pushNewInputRecord(firstExample);
        OutputVerifier.compareKeyValue(readOutput(), "testing", 1L);
        OutputVerifier.compareKeyValue(readOutput(), "kafka", 1L);
        OutputVerifier.compareKeyValue(readOutput(), "streams", 1L);
        assertNull(readOutput());

        String secondExample = "testing Kafka again";
        pushNewInputRecord(secondExample);
        OutputVerifier.compareKeyValue(readOutput(), "testing", 2L);
        OutputVerifier.compareKeyValue(readOutput(), "kafka", 2L);
        OutputVerifier.compareKeyValue(readOutput(), "again", 1L);

    }

    @Test
    public void makeSureWordsBecomeLowercase(){
        String upperCaseString = "KAFKA kafka Kafka";
        pushNewInputRecord(upperCaseString);
        OutputVerifier.compareKeyValue(readOutput(), "kafka", 1L);
        OutputVerifier.compareKeyValue(readOutput(), "kafka", 2L);
        OutputVerifier.compareKeyValue(readOutput(), "kafka", 3L);

    }
}