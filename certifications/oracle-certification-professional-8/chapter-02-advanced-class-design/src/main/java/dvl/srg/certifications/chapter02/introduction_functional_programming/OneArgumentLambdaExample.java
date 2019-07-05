package dvl.srg.certifications.chapter02.introduction_functional_programming;

import java.util.function.Predicate;

public class OneArgumentLambdaExample {

    public static void main(String[] args) {
        // parameter passing ways
        Predicate<String> startWithA1 = (String value) -> value.startsWith("A");
        Predicate<String> startWithA2 = (value) -> value.startsWith("A");
        Predicate<String> startWithA3 = value -> value.startsWith("A");

        // return
        Predicate<String> startWithA4 = value -> {return value.startsWith("A");};
        Predicate<String> startWithA = value -> value.startsWith("A");
    }
}
