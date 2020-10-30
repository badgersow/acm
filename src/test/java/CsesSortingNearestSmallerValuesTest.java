import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingNearestSmallerValuesTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingNearestSmallerValues().solve();
    }

    @Test
    public void sample() {
        compare("8 2 5 1 4 8 3 2 5", " 0 1 0 3 4 3 3 7");
    }
}
