import org.junit.jupiter.api.Test;

public class CsesIntroductoryAppleDivisionTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryAppleDivision().solve();
    }

    @Test
    public void sample() {
        compare("5 3 2 7 4 1", "1");
    }
}