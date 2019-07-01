package dvl.srg.certifications.ocp.domain.animal;

public class Lion extends Animal {
    @Override
    public void feed() {
        addMeat();
    }

    private void addMeat() {
    }

    String name = "Leo";

    public void play() {
        System.out.println("toss in meat");
    }
}
