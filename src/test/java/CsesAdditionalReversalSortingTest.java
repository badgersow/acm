import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalReversalSortingTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalReversalSorting().solve();
    }

    @Test
    public void sample() {
        compare("4 2 3 1 4", "2\n1 3\n2 3\n");
    }

}