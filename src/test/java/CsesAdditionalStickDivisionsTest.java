import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalStickDivisionsTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalStickDivisions().solve();
    }

    @Test
    public void sample() {
        compare("8 3 2 3 3", "13");
    }

}