package dvl.srg.certifications.ocp.enum_;

public enum Season {
    WINTER("Low") {
        @Override
        public void printHours() {
            System. out .println("9am-3pm");
        }
    },
    SPRING("Medium") {
        @Override
        public void printHours() {
            System. out .println("9am-5pm");
        }
    },
    SUMMER("High") {
        @Override
        public void printHours() {
            System. out .println("9am-7pm");
        }
    },
    FALL("Medium") {
        @Override
        public void printHours() {
            System. out .println("9am-5pm");
        }
    };

    private final String expectedVisitors;

    Season(final String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }

    public abstract void printHours();
}
