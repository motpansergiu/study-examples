package dvl.srg.certifications.chapter02.implementing_polymorfism;

public class Lemur extends Primate implements HasTail {

    public final int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {

        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;

        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());

        Lemur lemur1 = (Lemur) primate;

        Primate primate1 = new Primate();

        Lemur lemur2 = (Lemur) primate1;

    }
}
