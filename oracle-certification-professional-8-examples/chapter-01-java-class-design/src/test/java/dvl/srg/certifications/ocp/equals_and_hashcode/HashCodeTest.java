package dvl.srg.certifications.ocp.equals_and_hashcode;

import dvl.srg.certifications.ocp.domain.animal.Hippo;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class HashCodeTest {

    @Test
    void whenHashcodeAreTheSameThenEqualsIsInvokedIsThisCaseTheValueAreTheSame() {
        Hippo hippo1 = new Hippo();
        Hippo hippo2 = new Hippo();

        HashMap<Hippo, Long> map = new HashMap<>();

        map.put(hippo1, 100L);
        map.put(hippo2, 200L);

        assert map.size() == 1;
        assert map.get(hippo1) == 200;
    }
}
