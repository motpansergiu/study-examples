//package dvl.semotpan.avro;
//
//import com.example.Customer;
//import org.apache.avro.file.DataFileReader;
//import org.apache.avro.file.DataFileWriter;
//import org.apache.avro.io.DatumReader;
//import org.apache.avro.io.DatumWriter;
//import org.apache.avro.specific.SpecificDatumReader;
//import org.apache.avro.specific.SpecificDatumWriter;
//
//import java.io.File;
//import java.io.IOException;
//
//public class SpecificRecordExamples {
//    public static void main(String[] args) {
//
//        // step 0 create a specific record
//        Customer.Builder builder = Customer.newBuilder();
//        builder.setFirstName("Jon");
//        builder.setLastName("Snow");
//        builder.setAge(25);
//        builder.setHeight(170.5f);
//        builder.setWeight(70.5f);
//        builder.setAutomedEmail(false);
//
//        Customer customer = builder.build();
//
//        System.out.println(customer);
//
//        // step 1 write to a file
//        final DatumWriter<Customer> writer = new SpecificDatumWriter<>(customer.getSchema());
//        try (DataFileWriter<Customer> dataFileWriter = new DataFileWriter<>(writer)) {
//            dataFileWriter.create(customer.getSchema(), new File("customer-specific.avro"));
//            dataFileWriter.append(customer);
//            System.out.println("Written specific customer avro");
//        } catch (IOException e) {
//            System.out.println("Couldn't write file");
//            e.printStackTrace();
//        }
//
//        // step 2 read from a file
//        final File file = new File("customer-specific.avro");
//        final DatumReader<Customer> reader = new SpecificDatumReader<>(Customer.class);
//
//        try (DataFileReader<Customer> dataFileWriter = new DataFileReader<>(file, reader)) {
//            Customer readCustomer = dataFileWriter.next();
//            System.out.println("Successfully read avro");
//            System.out.println(readCustomer.toString());
//
//            String firstName = readCustomer.getFirstName();
//
//            System.out.println(firstName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
