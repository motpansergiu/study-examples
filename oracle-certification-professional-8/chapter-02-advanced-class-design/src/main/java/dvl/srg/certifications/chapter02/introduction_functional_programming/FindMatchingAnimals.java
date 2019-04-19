package dvl.srg.certifications.chapter02.introduction_functional_programming;

public class FindMatchingAnimals {
    private static void print(Animal animal, CheckTrait trait) {
        if (trait.test(animal))
            System.out.println(animal);
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), (a) -> a.canHop());

        print(new Animal("kangaroo", true, false), a -> a.canHop());


        print(new Animal("kangaroo", true, false), a -> {
            return a.canHop();
        });
        print(new Animal("kangaroo", true, false), (Animal a) -> {
            return a.canHop();
        });
        print(new Animal("kangaroo", true, false), (Animal a) -> a.canHop());
    }
}
