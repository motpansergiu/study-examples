package dvl.srg.certifications.ocp.equals_and_hashcode;

import dvl.srg.certifications.ocp.domain.animal.Card;
import org.junit.jupiter.api.Test;

public class EqualsTest {

    @Test
    void testEquals() {

        Card card = new Card();

        card.equals(new Object());

        card.equals(new Card());

    }

}
