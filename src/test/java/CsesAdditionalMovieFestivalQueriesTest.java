import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalMovieFestivalQueriesTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalMovieFestivalQueries().solve();
    }

    @Test
    public void sample() {
        compare("4 3 2 5 6 10 4 7 9 10 5 9 2 10 7 10", "0\n2\n1\n");
    }

}