package dvl.srg.certifications.ocp.nested_classes.memeber_inner_classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseOfThePrivateInterfaceTest {

    @Test
    void invokeMethodFromPrivateInterface() {
        CaseOfThePrivateInterface cp = new CaseOfThePrivateInterface();
        CaseOfThePrivateInterface.DontTell dontTell = cp.new DontTell();
        dontTell.shh();
    }

}