import org.junit.jupiter.api.Test;

public class CsesSortingApartmentsTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingApartments().solve();
    }

    @Test
    public void sample() {
        compare("4 3 5 60 45 80 60 30 60 75", "2");
    }

    @Test
    public void failingTle() {
        compare(readFile("/cses_sorting_apartments_tle.txt"), "1");
    }
}
