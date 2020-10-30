import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalStringRemovalsTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalStringRemovals().solve();
    }

    @Test
    public void sample() {
        compare("aybabtu", "103");
    }

    @Test
    public void trivial1() {
        compare("aa", "2");
    }

    @Test
    public void runtimeError1() {
        compare(readFile("/cses_additional_string_reordering_re_in_1.txt"),
                readFile("/cses_additional_string_reordering_re_out_1.txt"));
    }

}