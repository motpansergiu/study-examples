package dvl.srg.certifications.ocp.nested_classes.memeber_inner_classes;

public class A {
    private int x = 100;

     class B {
        private int x = 200;

         class C {
            private int x = 300;

            public void printAll() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(C.this.x);
            }
        }
    }
}
