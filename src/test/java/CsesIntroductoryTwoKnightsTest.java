import org.junit.Test;

public class CsesIntroductoryTwoKnightsTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryTwoKnights().solve();
    }

    @Test
    public void testSample() throws Exception {
        compare("8", "0\n" +
                "6\n" +
                "28\n" +
                "96\n" +
                "252\n" +
                "550\n" +
                "1056\n" +
                "1848\n");
    }
}