package dvl.srg.certifications.ocp.nested_classes.anonymous_inner_classes;

public class AnonInner {

    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        };

        return basePrice - sale.dollarsOff();
    }

    public int admission(int basePrice, SaleTodayOnly sale) {
        return basePrice - sale.dollarsOff();
    }

    public int pay() {
        return admission(5, new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        });
    }
}
