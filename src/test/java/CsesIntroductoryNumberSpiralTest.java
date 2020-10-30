import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesIntroductoryNumberSpiralTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesIntroductoryNumberSpiral().solve();
    }

    @Test
    public void trivial1() throws Exception {
        compare("1 1 1", "1");
    }

    @Test
    public void trivial2() throws Exception {
        compare("1 4 2", "15");
    }

    @Test
    public void sample() throws Exception {
        compare("3 2 3 1 1 4 2", "8\n1\n15");
    }

    @Test
    public void custom() throws Exception {
        compare("3 5 4 5 5 4 5", "20\n21\n22");
    }

    @Test
    public void checkOneAngle() throws Exception {
        compare("9 5 1 5 2 5 3 5 4 5 5 4 5 3 5 2 5 1 5", "17\n18\n19\n20\n21\n22\n23\n24\n25\n");
    }
}