import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalEmptyStringBruteForceTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesAdditionalEmptyStringBruteForce().solve();
    }

    @Test
    public void sample() {
        compare("aabccb", "3");
    }
}
