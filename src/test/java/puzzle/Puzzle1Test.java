package puzzle;

import org.junit.jupiter.api.Test;
import util.AcmTest;

public class Puzzle1Test extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new Puzzle1().solve();
    }

    @Test
    public void trivial1() {
        compare("1 1", "2 cannot be computed in 1 1s");
    }

    @Test
    public void trivial2() {
        compare("2 1", "3 cannot be computed in 2 1s");
    }

    @Test
    public void trivial3() {
        compare("3 1", "4 cannot be computed in 3 1s");
    }

    @Test
    public void trivial4() {
        compare("4 1", "5 cannot be computed in 4 1s");
    }

    @Test
    public void trivial5() {
        compare("5 1", "7 cannot be computed in 5 1s");
    }

    @Test
    public void sample1() {
        compare("6 2", "29 cannot be computed in 6 2s");
    }

    @Test
    public void sample2() {
        compare("6 3", "46 cannot be computed in 6 3s");
    }

    @Test
    public void sample3() {
        compare("6 4", "57 cannot be computed in 6 4s");
    }

    @Test
    public void sample4() {
        compare("6 5", "33 cannot be computed in 6 5s");
    }

    @Test
    public void sample5() {
        compare("6 6", "50 cannot be computed in 6 6s");
    }

    @Test
    public void sample6() {
        compare("6 7", "30 cannot be computed in 6 7s");
    }

    @Test
    public void sample7() {
        compare("6 8", "29 cannot be computed in 6 8s");
    }

    @Test
    public void sample8() {
        compare("6 9", "24 cannot be computed in 6 9s");
    }

    @Test
    public void largeSample() {
        compare("9 9", "430 cannot be computed in 9 9s");
    }


}