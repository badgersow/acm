import org.junit.jupiter.api.Test;

class CsesIntroductoryMissingNumberTest extends AcmTest {

    @Override
    void processInput() {
        new CsesIntroductoryMissingNumber().solve();
    }

    @Test
    public void sample() throws Exception {
        compare("5 2 3 1 5", "4");
    }
}