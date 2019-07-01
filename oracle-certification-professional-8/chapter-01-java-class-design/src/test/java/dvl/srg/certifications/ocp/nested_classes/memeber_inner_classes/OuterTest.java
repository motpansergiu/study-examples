package dvl.srg.certifications.ocp.nested_classes.memeber_inner_classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OuterTest {

    @Test
    void callInnerThroughOuter() {
        Outer outer = new Outer();

        outer.callInner();
    }

    @Test
    void instantiateInner() {
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();

        inner.go();
    }

}