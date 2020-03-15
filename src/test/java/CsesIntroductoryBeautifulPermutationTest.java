import org.junit.jupiter.api.Test;

class CsesIntroductoryBeautifulPermutationTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryBeautifulPermutation().solve();
    }

    @Test
    public void sample() throws Exception {
        compare("5", "2 4 1 3 5");
    }
}