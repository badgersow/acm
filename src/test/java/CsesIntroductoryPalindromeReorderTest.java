import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesIntroductoryPalindromeReorderTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryPalindromeReorder().solve();
    }

    @Test
    public void sample() {
        compare("AAAACACBA", "AAACBCAAA");
    }

    @Test
    public void noSolution() {
        compare("AB", "NO SOLUTION");
    }
}