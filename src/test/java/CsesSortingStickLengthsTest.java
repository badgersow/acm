import org.junit.jupiter.api.Test;

public class CsesSortingStickLengthsTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingStickLengths().solve();
    }

    @Test
    public void sample() {
        compare("5 2 3 1 5 2", "5");
    }
}
