import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingMovieFestivalTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingMovieFestival().solve();
    }

    @Test
    public void sample() {
        compare("3 3 5 4 9 5 8", "2");
    }
}
