package dvl.srg.certifications.ocp.virtual_method_invocation;

import dvl.srg.certifications.ocp.domain.animal.Animal;
import dvl.srg.certifications.ocp.domain.animal.Lion;
import org.junit.jupiter.api.Test;

class PlayWithAnimalTest {

    @Test
    void testVirtualInvocationOnFiledWhichDontWork() {
        Animal lion = new Lion();
        lion.printName();
    }


    @Test
    void testVirtualInvocationOnMehtod() {
        Animal lion = new Lion();
        lion.careFor();
    }
}
