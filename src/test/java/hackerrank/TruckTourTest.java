package hackerrank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TruckTourTest {

    @Test
    public void sample() {
        final int result = TruckTour.truckTour(new int[][]{{1, 5}, {10, 3}, {3, 4}});
        assertThat(result).isEqualTo(1);
    }

}