package dvl.srg.certifications.chapter02.designing_an_interface;

import java.io.IOException;

public class Eagle implements Fly {


    public int getWingSpan() {
        return 15;
    }

    @Override
    public int getWingSpan(int ignored) throws IOException {
        return 0;
    }

    public void land() {
        System.out.println("Eagle is diving fast");
    }
}
