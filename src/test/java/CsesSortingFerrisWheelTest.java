import org.junit.jupiter.api.Test;

public class CsesSortingFerrisWheelTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingFerrisWheel().solve();
    }

    @Test
    public void sample() {
        compare("4 10 7 2 3 9", "3");
    }
}
