import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingFactoryMachinesTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesSortingFactoryMachines().solve();
    }

    @Test
    public void sample() {
        compare("3 7 3 2 5", "8");
    }
}
