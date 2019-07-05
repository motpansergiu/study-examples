package dvl.srg.certifications.chapter02.designing_an_interface;

import java.io.IOException;

public interface Fly {
    public int getWingSpan() throws Exception;

    public int getWingSpan(int ignored) throws IOException;

    public static final int MAX_SPEED = 100;

    public default void land() {
        System.out.println("Animal is landing");
    }

    public static double calculateSpeed(float distance, double time) {
        return distance / time;
    }
}
