package dvl.srg.certifications.ocp.domain.animal;

public interface Clasic {
    int version = 1;
    void read();
}

class MediaReader implements Clasic {

    int version = 2;

    @Override
    public void read() {
        System.out.println(version); // print 2
        System.out.println(((Clasic)this).version); // print 1
        System.out.println(Clasic.version);
//        System.out.println(MediaReader.version); // NOT compile
    }
}
