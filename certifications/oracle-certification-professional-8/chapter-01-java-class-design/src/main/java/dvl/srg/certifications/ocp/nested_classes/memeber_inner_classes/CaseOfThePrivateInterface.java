package dvl.srg.certifications.ocp.nested_classes.memeber_inner_classes;

public class CaseOfThePrivateInterface {

    private interface Secret {
        public void shh();
    }

    class DontTell implements Secret {
        public void shh() {
        }
    }
}
