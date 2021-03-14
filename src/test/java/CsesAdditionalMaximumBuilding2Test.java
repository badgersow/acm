import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalMaximumBuilding2Test extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalMaximumBuilding2().solve();
    }

    @Test
    public void sample() {
        compare("" +
                        "4 7\n" +
                        "...*.*.\n" +
                        ".*.....\n" +
                        ".......\n" +
                        "......*",
                "" +
                        "24 17 13 9 6 3 1 \n" +
                        "16 9 7 5 3 1 0 \n" +
                        "9 3 2 1 0 0 0 \n" +
                        "3 0 0 0 0 0 0 \n");
    }

}