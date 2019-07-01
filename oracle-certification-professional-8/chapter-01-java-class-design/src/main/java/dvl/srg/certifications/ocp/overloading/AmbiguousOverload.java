package dvl.srg.certifications.ocp.overloading;

public class AmbiguousOverload {

    public static void aMethod(long val1, int val) {
        System.out.println("long - int");
    }


    public static void aMethod(int val1, long val) {
        System.out.println("long - int");
    }

    public static void main(String[] args) {
//        aMethod(9, 10);  // ERROR : reference to aMethod is ambiguous
    }
}
