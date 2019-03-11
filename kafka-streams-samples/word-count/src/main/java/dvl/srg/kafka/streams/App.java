package dvl.srg.kafka.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueMapper;

import java.util.Arrays;
import java.util.Properties;

public class App {

    public static final String WORD_COUNT_INPUTT_TOPIC = "word-count-inputt";
    public static final String WORD_COUNT_OUTPUTT_TOPIC = "word-count-outputt";

    public static void main(String[] args) {
        final Properties config = getAppProperties();

        App app = new App();

        KafkaStreams streams = new KafkaStreams(app.createTopology(), config);
        streams.start();

        // shutdown hook to correctly close the streams application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

        // Update:
        // print the topology every 10 seconds for learning purposes
        while(true){
            streams.localThreadsMetadata().forEach(data -> System.out.println(data));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();
        // 1 - stream from Kafka

        KStream<String, String> textLines = builder.stream(WORD_COUNT_INPUTT_TOPIC);
        KTable<String, Long> wordCounts = textLines
                // 2 - map values to lowercase
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                // can be alternatively written as:
                // .mapValues(String::toLowerCase)
                // 3 - flatmap values split by space
                .flatMapValues(textLine -> Arrays.asList(textLine.split("\\W+")))
                // 4 - select key to apply a key (we discard the old key)
                .selectKey((key, word) -> word)
                // 5 - group by key before aggregation
                .groupByKey()
                // 6 - count occurrences
                .count();

        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

        // 7 - to in order to write the results back to kafka
        wordCounts.toStream().to(WORD_COUNT_OUTPUTT_TOPIC, Produced.with(stringSerde, longSerde));
        return builder.build();
    }

    private static Properties getAppProperties() {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-app");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return config;
    }
}
