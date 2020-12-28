import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalProblemsCourseSchedule2Test extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesAdditionalProblemsCourseSchedule2().solve();
    }

    @Test
    public void sample() {
        compare("4 2 2 1 1 3", "2 1 3 4");
    }

    @Test
    public void mine1() {
        compare("3 1 3 1", "3 1 2");
    }

    @Test
    public void mine2() {
        compare("4 2 3 1 1 4", "3 1 2 4");
    }
}
