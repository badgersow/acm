import org.junit.jupiter.api.Test;

public class CsesSortingFactoryMachinesTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesSortingFactoryMachines().solve();
    }

    @Test
    public void sample() {
        compare("3 7 3 2 5", "8");
    }
}
