import org.junit.jupiter.api.Test;

public class CsesSortingTrafficLightsTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingTrafficLights().solve();
    }

    @Test
    public void sample() {
        compare("8 3 3 6 2", "5 3 3");
    }

    @Test
    public void trivial1() {
        compare("9 1 5", "5");
    }
}
