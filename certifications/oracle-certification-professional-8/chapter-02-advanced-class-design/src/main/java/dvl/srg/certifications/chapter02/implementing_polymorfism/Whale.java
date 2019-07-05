package dvl.srg.certifications.chapter02.implementing_polymorfism;

public class Whale implements LivesInOcean {
    @Override
    public void makeSound() {
        System.out.println("sing");
    }
}
