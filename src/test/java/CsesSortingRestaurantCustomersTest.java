import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingRestaurantCustomersTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingRestaurantCustomers().solve();
    }

    @Test
    public void sample() {
        compare("3 5 8 2 4 3 9", "2");
    }
}
