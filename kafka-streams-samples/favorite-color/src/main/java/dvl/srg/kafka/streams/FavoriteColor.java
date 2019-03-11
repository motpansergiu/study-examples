package dvl.srg.kafka.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class FavoriteColor {

    public static final String INPUT_TOPIC = "user-color-input-topic";
    public static final String OUTPUT_TOPIC = "grouped-color-output-topic";

    static final Set<String> colorCache = new HashSet<>();
    public static final String USER_COLOR_COMPACTED_TOPIC = "user-color-compacted-topic";

    static {
        colorCache.add("green");
        colorCache.add("red");
        colorCache.add("blue");
    }

    public static void main(String[] args) {
        // Connection properties

        Properties config = getProperties();

        FavoriteColor favoriteColor = new FavoriteColor();

        KafkaStreams streams = new KafkaStreams(favoriteColor.createTopology(), config);
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }

    private static Properties getProperties() {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "favorite-color");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return config;
    }

    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> stream = builder.stream(INPUT_TOPIC);

        KStream<String, String> exctractedByKey = stream.mapValues((ValueMapper<String, String>) String::toLowerCase)
                .filter((key, value) -> value.contains(","))
                .selectKey((key, value) -> value.substring(0, value.indexOf(',')))
                .mapValues(line -> line.substring(line.indexOf(',') + 1))
                .filter((key, value) -> colorCache.contains(value));

        exctractedByKey.to(USER_COLOR_COMPACTED_TOPIC);

        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

        KTable<String, Long> count = builder.stream(USER_COLOR_COMPACTED_TOPIC, Consumed.with(stringSerde, stringSerde))
                .selectKey((key, value) -> value)
                .groupByKey()
                .count();

        count.toStream().to(OUTPUT_TOPIC, Produced.with(stringSerde, longSerde));
        return builder.build();
    }
}
