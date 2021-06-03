import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalPermutations2Test extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalPermutations2().solve();
    }

    @Test
    public void sample1() {
        compare("1", "1");
    }

    @Test
    public void sample2() {
        compare("2", "0");
    }

    @Test
    public void sample3() {
        compare("3", "0");
    }

    @Test
    public void sample4() {
        compare("4", "2");
    }

    @Test
    public void sample5() {
        compare("5", "14");
    }

    @Test
    public void sample6() {
        compare("6", "90");
    }

    @Test
    public void sample7() {
        compare("7", "646");
    }

}