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

class FavoriteColorTest {

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

        FavoriteColor favoriteColor = new FavoriteColor();
        Topology topology = favoriteColor.createTopology();
        testDriver = new TopologyTestDriver(topology, config);
    }

    @AfterEach
    public void closeTestDriver(){
        testDriver.close();
    }

    public void pushNewInputRecord(String value){
        testDriver.pipeInput(recordFactory.create(FavoriteColor.INPUT_TOPIC, null, value));
    }

    public ProducerRecord<String, Long> readOutput(){
        return testDriver.readOutput(FavoriteColor.OUTPUT_TOPIC, new StringDeserializer(), new LongDeserializer());
    }

    @Test
    public void whenSendAnInvalidColorExpectNoResult() {
        String dateInput = "john,black";

        pushNewInputRecord(dateInput);

        assertNull(readOutput());
    }

    @Test
    public void whenSendAnUpdateExpectGreen0AndRed1() {
        String dateInput1 = "john,green";
        String dateInput2 = "john,red";

        pushNewInputRecord(dateInput1);
        pushNewInputRecord(dateInput2);

        OutputVerifier.compareKeyValue(readOutput(), "green", 1L);
        OutputVerifier.compareKeyValue(readOutput(), "red", 1L);
        assertNull(readOutput());
    }

}