import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsesSortingRoomAllocationTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingRoomAllocation().solve();
    }

    @Test
    public void trivial() {
        compare("1 1 2", "1\n1");
    }

    @Test
    public void trivial2() {
        compare("2 1 3 2 4", "2\n1 2");
    }

    @Test
    public void sample() {
        compare("3 1 2 2 4 4 4", "2\n1 2 1");
    }

    @Test
    public void tle1() {
        compare(
                readFile("/cses_sorting_room_allocation_tle_in_1.txt"),
                readFile("/cses_sorting_room_allocation_tle_out_1.txt"));
    }

    @Test
    public void testIsArrivalEncode() {
        assertTrue(CsesSortingRoomAllocation.isArrival(CsesSortingRoomAllocation.encode(true, 1_000_000, 1_000_000_000)));
    }

    @Test
    public void testPositionEncode() {
        assertEquals(1_000_000, CsesSortingRoomAllocation.position(CsesSortingRoomAllocation.encode(true, 1_000_000, 1_000_000_000)));
    }
}
