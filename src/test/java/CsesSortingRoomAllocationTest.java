import org.junit.jupiter.api.Test;

public class CsesSortingRoomAllocationTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingRoomAllocation().solve();
    }

    @Test
    public void sample() {
        compare("3 1 2 2 4 4 4", "2\n1 2 1");
    }
}
