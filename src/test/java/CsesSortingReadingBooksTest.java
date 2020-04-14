import org.junit.jupiter.api.Test;

public class CsesSortingReadingBooksTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingReadingBooks().solve();
    }

    @Test
    public void sample() {
        compare("3 2 8 3", "16");
    }
}
