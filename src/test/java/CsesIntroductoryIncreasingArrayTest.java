import org.junit.jupiter.api.Test;

class CsesIntroductoryIncreasingArrayTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryIncreasingArray().solve();
    }

    @Test
    public void sample() throws Exception {
        compare("5 3 2 5 1 7", "5");
    }
}