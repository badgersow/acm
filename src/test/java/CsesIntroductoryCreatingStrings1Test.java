import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesIntroductoryCreatingStrings1Test extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryCreatingStrings1().solve();
    }

    @Test
    public void sample() {
        compare("aabac", " 20\naaabc\naaacb\naabac\naabca\naacab\naacba\nabaac\nabaca\nabcaa\nacaab\nacaba\nacbaa\nbaaac\nbaaca\nbacaa\nbcaaa\ncaaab\ncaaba\ncabaa\ncbaaa");
    }
}