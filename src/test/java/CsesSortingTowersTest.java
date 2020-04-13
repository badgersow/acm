import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CsesSortingTowersTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesSortingTowers().solve();
    }

    @Test
    public void sample() {
        compare("5 3 8 2 1 5", "2");
    }

    @Test
    public void equalCase() {
        compare("2 1 1", "2");
    }

    @Test
    public void checkLis1() {
        final int[] a = {6, 2, 5, 1, 7, 4, 8, 3};
        assertThat(CsesSortingTowers.lis(a)).isEqualTo(4); // 2 5 7 8
    }

    @Test
    public void checkLis2() {
        final int[] a = {1, 2, 3, 4, 5};
        assertThat(CsesSortingTowers.lis(a)).isEqualTo(5);
    }

    @Test
    public void checkLis3() {
        final int[] a = {5, 4, 3, 2, 1};
        assertThat(CsesSortingTowers.lis(a)).isEqualTo(1);
    }
}
