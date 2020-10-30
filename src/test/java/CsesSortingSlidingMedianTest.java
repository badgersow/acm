import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingSlidingMedianTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingSlidingMedian().solve();
    }

    @Test
    public void sample() {
        compare("8 3 2 4 3 5 8 1 2 1", "3 4 5 5 2 1");
    }

    @Test
    public void trivial() {
        compare("5 1 1 2 3 4 5", "1 2 3 4 5");
    }

    @Test
    public void trivial2() {
        compare("10 2 1 2 3 4 5 6 7 8 9 10", "1 2 3 4 5 6 7 8 9");
    }

    @Test
    public void testTle1() {
        compare(
                readFile("/cses_sorting_sliding_median_tle_in_1.txt"),
                readFile("/cses_sorting_sliding_median_tle_out_1.txt"));
    }
}