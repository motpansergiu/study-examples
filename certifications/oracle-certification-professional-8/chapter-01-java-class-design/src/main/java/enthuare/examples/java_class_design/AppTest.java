package enthuare.examples.java_class_design;

public class AppTest {
    public static void main(String[] args) {
        A a = new A();
        A ab = new B();
        A abc = new C();

        a.a();
        a.aa();

        // !!! uite ce metode poti invoka si care se executa
        ab.a();
        ab.aa();

        // uite ce metode poti invoka si care se executa
        abc.a();
        abc.aa();

        B b = new B();
        B bc = new C();

        // uite ce metode poti invoka si care se executa
        b.a();
        b.aa();
        b.b();
        b.bb();

        // uite ce metode poti invoka si care se executa
        bc.a();
        bc.aa();
        bc.b();
        bc.bb();

        C c = new C();

        c.a();
        c.aa();
        c.b();
        c.bb();
        c.c();

        // DE CE SE EXECUTA CUM SE EXECUTA :) ??
    }
}

class A {
    int val = 10;

    public void a() {
        System.out.println(A.class + " => a: " + val);
    }

    public void aa() {
        System.out.println(A.class + " =>  aa :" + val);
    }
}

class B extends A {
    int val = 20;

    public void a() {
        System.out.println(B.class + " => a: " + val);
    }

    public void b() {
        System.out.println(B.class + " => b: " + val);
    }

    public void bb() {
        System.out.println(B.class + " => bb: " + val);
    }
}

class C extends B {
    int val = 30;

    public void a() {
        System.out.println(C.class + " => a: " + val);
    }

    public void b() {
        System.out.println(C.class + " => b: " + val);
    }

    public void c() {
        System.out.println(C.class + " => c: " + val);
    }
}