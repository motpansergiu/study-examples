package dvl.srg.certifications.ocp;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

    public final static String WGU_DATE_FORMAT = "M/d/yyyy h:mm:ss a";


    @org.junit.jupiter.api.Test
    void testInstant() {

        final String utc =
                DateTimeFormatter.ofPattern(WGU_DATE_FORMAT)
                        .withZone(ZoneId.systemDefault())
                        .format(Instant.ofEpochMilli(1553873475356L));

        final Date date = new Date(1553873475356L);

//        System.out.println(date.getTime());


        Format format = new SimpleDateFormat(WGU_DATE_FORMAT);

        final String format1 = format.format(date);

        System.out.println(format1);
        System.out.println(utc);


    }

}
