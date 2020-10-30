import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingReadingBooksTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingReadingBooks().solve();
    }

    @Test
    public void sample() {
        compare("3 2 8 3", "16");
    }
}
