import org.junit.jupiter.api.Test;

class CsesIntroductoryBitStringsTest extends AcmTest {

    @Override
    void processInput() {
        new CsesIntroductoryBitStrings().solve();
    }

    @Test
    public void sample() {
        compare(3, 8);
    }

}