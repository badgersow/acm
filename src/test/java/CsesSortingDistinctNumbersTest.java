import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingDistinctNumbersTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesSortingDistinctNumbers().solve();
    }

    @Test
    public void sample() {
        compare("5 2 3 2 2 3", "2");
    }
}