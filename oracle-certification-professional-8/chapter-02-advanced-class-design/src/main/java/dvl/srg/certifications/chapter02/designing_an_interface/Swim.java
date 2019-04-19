package dvl.srg.certifications.chapter02.designing_an_interface;

public interface Swim {

    default void print() {
        //
    }

    static void printStatic() {
        System.out.println(Swim.class + " : printStatic");
    }
}
