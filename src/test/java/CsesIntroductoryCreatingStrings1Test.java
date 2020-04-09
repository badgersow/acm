import org.junit.jupiter.api.Test;

public class CsesIntroductoryCreatingStrings1Test extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryCreatingStrings1().solve();
    }

    @Test
    public void sample() {
        compare("aabac", " 20\naaabc\naaacb\naabac\naabca\naacab\naacba\nabaac\nabaca\nabcaa\nacaab\nacaba\nacbaa\nbaaac\nbaaca\nbacaa\nbcaaa\ncaaab\ncaaba\ncabaa\ncbaaa");
    }
}