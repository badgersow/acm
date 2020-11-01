import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalProblemsBitProblemTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalProblemsBitProblem().solve();
    }

    @Test
    public void sample() {
        compare("5 3 7 2 9 2", "" +
                "3 2 5\n" +
                "4 1 5\n" +
                "2 4 4\n" +
                "1 1 3\n" +
                "2 4 4");
    }

}