import org.junit.jupiter.api.Test;
import util.AcmTest;

class CsesIntroductoryBitStringsTest extends AcmTest {

    @Override
    public void processInput() {
        new CsesIntroductoryBitStrings().solve();
    }

    @Test
    public void sample() {
        compare(3, 8);
    }

}