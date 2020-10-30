import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesIntroductoryTrailingZerosTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryTrailingZeros().solve();
    }

    @Test
    public void sample() {
        compare(20, 4);
    }

    @Test
    public void school() {
        compare(100, 24);
    }
}