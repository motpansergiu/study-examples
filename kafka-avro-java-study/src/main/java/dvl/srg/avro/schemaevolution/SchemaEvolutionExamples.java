package dvl.srg.avro.schemaevolution;

import com.example.CustomerV1;
import com.example.CustomerV2;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.File;
import java.io.IOException;

public class SchemaEvolutionExamples {

    public static void main(String[] args) {
        // write version 1 to an avro file
        CustomerV1 customerV1 = CustomerV1.newBuilder()
                .setFirstName("Jon")
                .setLastName("Snow")
                .setAge(25)
                .setHeight(170.5f)
                .setWeight(70.5f)
                .setAutomedEmail(false)
                .build();

        writeToFile(customerV1, "customer-v1.avro");

        // write version 2 to an avro file
        CustomerV2 customerV2 = CustomerV2.newBuilder()
                .setFirstName("Jon")
                .setLastName("Snow")
                .setAge(25)
                .setHeight(170.5f)
                .setWeight(70.5f)
                .setAddress("Address")
                .build();

        writeToFile(customerV2, "customer-v2.avro");

        // 1. Backward schema evolution
        CustomerV2 customerV21 = readFromFile("customer-v1.avro", new SpecificDatumReader<>(CustomerV2.class));
        System.out.println(customerV21);

        // 2. Forward schema evolution
        CustomerV1 customerV12 = readFromFile("customer-v2.avro", new SpecificDatumReader<>(CustomerV1.class));
        System.out.println(customerV12);

        // 3. Full (supports both - backward and forward)
        // Which is achieved :)
    }

    static <T extends SpecificRecordBase> void writeToFile(final T value, final String fileName) {
        final DatumWriter<T> customerV1DatumWriter = new SpecificDatumWriter<>(value.getSchema());
        try (DataFileWriter<T> dataFileWriter = new DataFileWriter<>(customerV1DatumWriter)) {
            dataFileWriter.create(value.getSchema(), new File(fileName));
            dataFileWriter.append(value);
            System.out.println("Written specific customer-v1 avro");
        } catch (IOException e) {
            System.out.println("Couldn't write file");
            e.printStackTrace();
        }
    }

    static <T extends SpecificRecordBase> T readFromFile(final String fileName, final DatumReader<T> reader) {
        final File file = new File(fileName);
        try (DataFileReader<T> dataFileWriter = new DataFileReader<>(file, reader)) {
            T value = dataFileWriter.next();
            System.out.println("Successfully read avro");
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
