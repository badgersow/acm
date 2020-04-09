import org.junit.jupiter.api.Test;

public class CsesIntroductoryTrailingZerosTest extends AcmTest {

    @Override
    void processInput() throws Exception {
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