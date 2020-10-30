import org.junit.jupiter.api.Test;
import util.AcmTest;

class CsesIntroductoryBeautifulPermutationTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryBeautifulPermutation().solve();
    }

    @Test
    public void sample() throws Exception {
        compare("5", "2 4 1 3 5");
    }
}