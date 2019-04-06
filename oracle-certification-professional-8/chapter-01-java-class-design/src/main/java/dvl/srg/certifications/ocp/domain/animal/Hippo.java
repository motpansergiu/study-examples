package dvl.srg.certifications.ocp.domain.animal;

public class Hippo extends HeavyAnimal {

    private String name = "HIPPO";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Hippo) && (name.equals(((Hippo) obj).name));
    }

    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Hippo{" +
                "name='" + name + '\'' +
                '}';
    }
}
