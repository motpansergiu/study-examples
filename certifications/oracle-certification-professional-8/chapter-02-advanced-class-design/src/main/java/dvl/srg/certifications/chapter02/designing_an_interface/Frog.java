package dvl.srg.certifications.chapter02.designing_an_interface;

public class Frog implements Swim, Hop{

    // FAILS if is not implemented
    @Override
    public void print() {
    }

    static void printStatic() {
        System.out.println(Frog.class + " : printStatic");
    }

    static {
        printStatic();
        Hop.printStatic();
        Swim.printStatic();
    }

    public static void main(String[] args) {

    }
}
