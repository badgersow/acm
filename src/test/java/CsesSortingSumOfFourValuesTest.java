import org.junit.jupiter.api.Test;

public class CsesSortingSumOfFourValuesTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingSumOfFourValues().solve();
    }

    @Test
    public void sample() {
        compare("8 15 3 2 5 8 1 3 2 3", "2 4 6 7");
    }

    @Test
    public void impossible() {
        compare("4 11 1 2 3 4", "IMPOSSIBLE");
    }
}
