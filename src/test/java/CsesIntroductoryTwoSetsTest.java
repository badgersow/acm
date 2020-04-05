import org.junit.jupiter.api.Test;

class CsesIntroductoryTwoSetsTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryTwoSets().solve();
    }

    @Test
    public void sample1() throws Exception {
        compare("7", "YES\n4\n1 2 4 7\n3\n3 5 6");
    }

    @Test
    public void sample2() throws Exception {
        compare("6", "NO");
    }
}