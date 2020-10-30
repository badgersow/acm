import org.junit.jupiter.api.Test;
import util.AcmTest;

class CsesIntroductoryRepetitionsTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryRepetitions().solve();
    }

    @Test
    public void sample() throws Exception {
        compare("ATTCGGGA", "3");
    }
}