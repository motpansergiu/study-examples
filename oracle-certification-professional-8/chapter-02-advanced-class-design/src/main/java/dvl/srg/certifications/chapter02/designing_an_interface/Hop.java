package dvl.srg.certifications.chapter02.designing_an_interface;

public interface Hop {
    default void print() {
        //
    }

    static void printStatic() {
        System.out.println(Hop.class + " : printStatic");
    }
}
