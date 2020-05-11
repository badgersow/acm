import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CsesSortingArrayDivisionTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingArrayDivision().solve();
    }

    @Test
    public void sample() {
        compare("5 3 2 4 7 3 5", "8");
    }

    @Test
    public void ypys1() {
        compare("4 3 1 2 3 4", "4");
    }

    @Test
    public void canDivide1() {
        assertTrue(CsesSortingArrayDivision.canDivide(new int[]{1, 2, 3, 4}, 3, 4));
    }

    @Test
    public void canDivide2() {
        assertFalse(CsesSortingArrayDivision.canDivide(new int[]{1, 2, 3, 4}, 3, 3));
    }
}