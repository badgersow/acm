import org.junit.jupiter.api.Test;

public class CsesIntroductoryPalindromeReorderTest extends AcmTest {

    @Override
    void processInput() throws Exception {
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