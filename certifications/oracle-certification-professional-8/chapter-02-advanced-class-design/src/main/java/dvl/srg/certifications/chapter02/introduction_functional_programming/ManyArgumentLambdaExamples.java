package dvl.srg.certifications.chapter02.introduction_functional_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ManyArgumentLambdaExamples {

    public static void main(String[] args) {
        // parameter passing ways
        BiPredicate<String, String> startWithA1 = (String value1, String value2) -> value1.startsWith("A") && value2.startsWith("A");
        BiPredicate<String, String> startWithA = (value1, value2) -> value1.startsWith("A") && value2.startsWith("A");
        BiPredicate<String, String> startWithA3 = (value1, value2) -> {return value1.startsWith("A") && value2.startsWith("A");};


        List<String> stringList = new ArrayList<>();
        stringList.add("Test");

        ArrayList<String> c = new ArrayList<>();
        c.add(null);
        stringList.addAll(c);

        System.out.println(stringList);

        Map<String, String> map = new HashMap<>();
        map.put("map1", "map1");

        Map<String, String> temp = new HashMap<>();
        temp.put("k1", "k1");

        map.putAll(temp);

        System.out.println(map);

    }
}
