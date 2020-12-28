import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.AcmTest;

@Disabled
public class CsesAdditionalCriticalCitiesTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalCriticalCities().solve();
    }

    @Test
    public void trivial1() {
        compare("2 1 1 2", "2\n1 2\n");
    }

    @Test
    public void trivial2() {
        compare("3 2 1 2 2 3", "3\n1 2 3\n");
    }

    @Test
    public void sample() {
        compare("5 5 1 2 2 3 2 4 3 5 4 5", "3\n1 2 5\n");
    }

}
