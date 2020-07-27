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

    @Test
    public void cses1() {
        compare("" + "10\n" +
                        "1 5\n" +
                        "1 7\n" +
                        "1 8\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "1 10\n" +
                        "1 6\n" +
                        "1 9\n" +
                        "1 2\n",
                "" +
                        "5\n" +
                        "2 3\n" +
                        "4 5\n" +
                        "6 7\n" +
                        "8 9\n" +
                        "9 10");
    }

    @Test
    public void cses2() {
        compare("" +
                        "7\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "2 4\n" +
                        "2 5\n" +
                        "3 6\n" +
                        "3 7\n",
                "" +
                        "2\n" +
                        "5 7\n" +
                        "4 6\n");
    }

}