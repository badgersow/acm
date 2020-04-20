import org.junit.jupiter.api.Test;

public class CsesSortingSumOfThreeValuesTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingSumOfThreeValues().solve();
    }

    @Test
    public void sample() {
        compare("4 8 2 7 5 1", "4 1 3");
    }

    @Test
    public void impossible1() {
        compare("4 8 2 7 5 10", "IMPOSSIBLE");
    }

    @Test
    public void impossible2() {
        compare("4 9 3 3 2 1 ", "IMPOSSIBLE");
    }
}
