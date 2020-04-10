import org.junit.jupiter.api.Test;

public class CsesSortingSumOfTwoValuesTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingSumOfTwoValues().solve();
    }

    @Test
    public void sample() {
        compare("4 8 2 7 5 1", "4 2");
    }

    @Test
    public void sameElement() {
        compare("2 2 1 1", "1 2");
    }

    @Test
    public void testImpossible() {
        compare("1 2 1", "IMPOSSIBLE");
    }
}
