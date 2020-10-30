import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingMaximumSubarraySumTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingMaximumSubarraySum().solve();
    }

    @Test
    public void sample() {
        compare("8 -1 3 -2 5 3 -5 2 2", "9");
    }
}
