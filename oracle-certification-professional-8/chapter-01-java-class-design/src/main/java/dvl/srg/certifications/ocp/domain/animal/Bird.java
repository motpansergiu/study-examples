package dvl.srg.certifications.ocp.domain.animal;

public class Bird extends Animal {
    @Override
    public void feed() {
        addSeed();
    }

    private void addSeed() {}
}
