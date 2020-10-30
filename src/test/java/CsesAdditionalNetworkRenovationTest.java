import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalNetworkRenovationTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalNetworkRenovation().solve();
    }

    @Test
    public void sample() {
        compare("5 1 2 1 3 3 4 3 5", "2\n2 5\n4 5\n");
    }

    @Test
    public void even() {
        compare("7 1 2 1 3 1 4 1 5 1 6 1 7", "3\n2 6\n3 5\n4 7");
    }

    @Test
    public void odd() {
        compare("6 1 2 1 3 1 4 1 5 1 6", "3\n2 6\n3 5\n4 6");
    }

}