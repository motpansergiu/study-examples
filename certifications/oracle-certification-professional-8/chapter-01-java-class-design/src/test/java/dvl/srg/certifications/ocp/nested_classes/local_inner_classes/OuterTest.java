package dvl.srg.certifications.ocp.nested_classes.local_inner_classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OuterTest {

    @Test
    void localInnerClass() {
        Outer outer = new Outer();
        outer.calculate();
    }

}