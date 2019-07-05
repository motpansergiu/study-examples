package dvl.srg.certifications.chapter02.designing_an_interface;

public interface Run extends Walk {

    public abstract boolean canHuntWhileRuning();

    abstract double getMaxSpeed();
}
