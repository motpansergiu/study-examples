package dvl.srg.certifications.chapter02.designing_an_interface;

public class Lion implements Run {
    @Override
    public boolean canHuntWhileRuning() {
        return true;
    }

    @Override
    public boolean isQuadruped() {
        return true;
    }

    @Override
    public double getMaxSpeed() {
        return 100;
    }
}
