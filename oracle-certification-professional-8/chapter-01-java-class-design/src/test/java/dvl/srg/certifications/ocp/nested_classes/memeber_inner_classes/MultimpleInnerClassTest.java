package dvl.srg.certifications.ocp.nested_classes.memeber_inner_classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultimpleInnerClassTest {

    @Test
    void allTheX() {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();

        c.printAll();
    }
}