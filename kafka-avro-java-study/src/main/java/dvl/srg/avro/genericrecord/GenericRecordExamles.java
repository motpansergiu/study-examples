package dvl.srg.avro.genericrecord;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecordBuilder;

public class GenericRecordExamles {

    public static void main(String[] args) {
        // step 0 generate schema
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse("{\n" +
                "    \"type\" : \"record\",\n" +
                "    \"namespace\" : \"com.example\",\n" +
                "    \"name\" : \"Customer\",\n" +
                "    \"doc\" : \"Avro schema for Customer\",\n" +
                "    \"fields\" : [\n" +
                "        { \"name\": \"first_name\", \"type\" : \"string\" , \"doc\" : \"First Name of Customer\" },\n" +
                "        { \"name\": \"last_name\", \"type\" : \"string\" , \"doc\" : \"Last Name of Customer\" },\n" +
                "        { \"name\": \"age\", \"type\" : \"int\" , \"doc\" : \"Age of Customer\" },\n" +
                "        { \"name\": \"height\", \"type\" : \"float\" , \"doc\" : \"Height at the time of registration in cm\" },\n" +
                "        { \"name\": \"weight\", \"type\" : \"float\" , \"doc\" : \"Weight at the time of registration in cm\" },\n" +
                "        { \"name\": \"automed_email\", \"type\" : \"boolean\" , \"default\" : true, \"doc\" : \"Field indication if the customer want receive emails\" }\n" +
                "    ]\n" +
                "}");

        // step 1 generate a generic record
        GenericRecordBuilder builder = new GenericRecordBuilder(schema);

        builder.set("first_name", "Jon");
        builder.set("last_name", "Snow");
        builder.set("age", 25);
        builder.set("height", 175.2);
        builder.set("weight", 70.5);
        builder.set("automed_email", false);

        GenericData.Record customer = builder.build();
        System.out.println(customer);

        GenericRecordBuilder builderWithDefault = new GenericRecordBuilder(schema);

        builderWithDefault.set("first_name", "Jon");
        builderWithDefault.set("last_name", "Snow");
        builderWithDefault.set("age", 25);
        builderWithDefault.set("height", 175.2);
        builderWithDefault.set("weight", 70.5);

        GenericData.Record customerWithDefault = builderWithDefault.build();
        System.out.println(customerWithDefault);



    }
}
