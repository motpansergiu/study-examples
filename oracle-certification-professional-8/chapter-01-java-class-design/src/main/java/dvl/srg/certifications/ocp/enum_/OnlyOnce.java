package dvl.srg.certifications.ocp.enum_;

public enum OnlyOnce {

    ONCE(true);

    private OnlyOnce(boolean active) {
        System.out.println("constructing");
    }
}
