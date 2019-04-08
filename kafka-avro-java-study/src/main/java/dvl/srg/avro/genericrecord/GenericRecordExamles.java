package dvl.srg.avro.genericrecord;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.*;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;

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
                "        { \"name\": \"weight\", \"type\" : \"float\" , \"doc\" : \"Weight at the time of registration in kg\" },\n" +
                "        { \"name\": \"automed_email\", \"type\" : \"boolean\" , \"default\" : true, \"doc\" : \"Field indication if the customer want receive emails\" }\n" +
                "    ]\n" +
                "}");

        // step 1 generate a generic record
        GenericRecordBuilder builder = new GenericRecordBuilder(schema);

        builder.set("first_name", "Jon");
        builder.set("last_name", "Snow");
        builder.set("age", 25);
        builder.set("height", 175.2f);
        builder.set("weight", 70.5f);
        builder.set("automed_email", false);

        GenericData.Record customer = builder.build();
        System.out.println(customer);

        GenericRecordBuilder builderWithDefault = new GenericRecordBuilder(schema);

        builderWithDefault.set("first_name", "Jon");
        builderWithDefault.set("last_name", "Snow");
        builderWithDefault.set("age", 25);
        builderWithDefault.set("height", 175.2f);
        builderWithDefault.set("weight", 70.5f);

        GenericData.Record customerWithDefault = builderWithDefault.build();
        System.out.println(customerWithDefault);



        // step 2 write an avro object to a file
        final DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
        try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(writer)) {
            dataFileWriter.create(customer.getSchema(), new File("customer-generic.avro"));
            dataFileWriter.append(customer);
            System.out.println("Written generic customer avro");
        } catch (IOException e) {
            System.out.println("Couldn't write file");
            e.printStackTrace();
        }


        // step 3 read an avro object from a file
        final File file = new File("customer-generic.avro");
        final DatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);

        try (DataFileReader<GenericRecord> dataFileWriter = new DataFileReader<>(file, reader)) {
            GenericRecord readCustomer = dataFileWriter.next();
            System.out.println("Successfully read avro");
            System.out.println(readCustomer.toString());

            Object firstName = readCustomer.get("first_name");
            System.out.println(firstName);

            Object none = readCustomer.get("none");

            System.out.println(none);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
