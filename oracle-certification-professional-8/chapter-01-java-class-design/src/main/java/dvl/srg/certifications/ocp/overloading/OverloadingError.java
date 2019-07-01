package dvl.srg.certifications.ocp.overloading;

public class OverloadingError {
    public static void aMethod(byte val) {
        System.out.println("byte");
    }

    public static void aMethod(short val) {
        System.out.println("short");
    }

    public static void main(String[] args) {
//        aMethod(9) ;   // COMPILE ERROR
    }
}
