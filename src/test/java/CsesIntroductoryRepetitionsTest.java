import org.junit.jupiter.api.Test;

class CsesIntroductoryRepetitionsTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryRepetitions().solve();
    }

    @Test
    public void sample() throws Exception {
        compare("ATTCGGGA", "3");
    }
}