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

    @Test
    public void tle1() {
        compare(
                readFile("/cses_sorting_traffic_lights_tle_in_1.txt"),
                readFile("/cses_sorting_traffic_lights_tle_out_1.txt")
        );
    }

    @Test
    public void tle2() {
        compare(
                readFile("/cses_sorting_traffic_lights_tle_in_2.txt"),
                readFile("/cses_sorting_traffic_lights_tle_out_2.txt")
        );
    }
}
