import org.junit.jupiter.api.Test;

public class CsesAdditionalNetworkRenovationTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesAdditionalNetworkRenovation().solve();
    }

    @Test
    public void sample() {
        compare("5 1 2 1 3 3 4 3 5", "2\n2 4\n4 5\n");
    }

}