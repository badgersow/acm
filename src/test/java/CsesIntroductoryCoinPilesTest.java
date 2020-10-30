import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesIntroductoryCoinPilesTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryCoinPiles().solve();
    }

    @Test
    public void sample() {
        compare("3 2 1 2 2 3 3", "YES\nNO\nYES");
    }
}