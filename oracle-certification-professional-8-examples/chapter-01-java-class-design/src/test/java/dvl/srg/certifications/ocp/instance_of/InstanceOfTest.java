package dvl.srg.certifications.ocp.instance_of;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstanceOfTest {

    @Test
    void instanceOfOnObjectHirachy() {
        HeavyAnimal hippo = new Hippo();

        assertTrue(hippo instanceof Hippo);
        assertTrue(hippo instanceof HeavyAnimal);
        assertTrue(hippo instanceof Object);
        assertFalse(hippo instanceof Elephant);
    }

    @Test
    void instanceOfOnNullReference() {
        Hippo hippo = null;

        assertFalse(hippo instanceof Object);
        assertFalse(null instanceof HeavyAnimal);

        Elephant elephant = new Elephant();

        //COMPILE ERROR !!!
        // hippo instanceof Elephant
    }

    @Test
    void instanceOfOnInterface() {

        Hippo hippo = new Hippo();

        assertFalse(hippo instanceof Predicate);
    }
}