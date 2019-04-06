package dvl.srg.certifications.ocp.enum_;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EnumTest {

    @Test
    void enumInSwitch() {

        Season season = Season.FALL;

        switch (season) {

            case FALL:
                break;
            case SPRING:
                break;
            case SUMMER:
                break;
            case WINTER:
                break;
                default:

        }

    }

    @Test
    void printEnumParams() {
        final Season[] values = Season.values();
        for (Season season : values) {
            System.out.println("ordinal() : " + season.ordinal());
            System.out.println("name() : " + season.name());
            System.out.println("hashCode() : " + season.hashCode());
        }
    }

    @Test
    void printExpectedVisitorForEachSeason() {
        Stream.of(Season.values())
                .forEach(Season::printExpectedVisitors);
    }

    @Test
    void shouldPrintOnlyOnceEnumConstructor() {
        final OnlyOnce once = OnlyOnce.ONCE;
        final OnlyOnce once2 = OnlyOnce.ONCE;
    }
}