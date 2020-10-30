import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingSubarrayDivisibilityTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingSubarrayDivisibility().solve();
    }

    @Test
    public void sample() {
        compare("5 3 1 2 7 4", "1");
    }
}