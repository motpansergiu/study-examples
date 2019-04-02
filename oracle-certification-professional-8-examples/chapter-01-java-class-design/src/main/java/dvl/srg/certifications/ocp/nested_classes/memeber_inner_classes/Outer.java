package dvl.srg.certifications.ocp.nested_classes.memeber_inner_classes;

import java.util.stream.IntStream;

public class Outer {

    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;

        public void go() {
            IntStream
                    .range(0, repeat)
                    .forEach(value -> System.out.println(greeting));
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }
}
