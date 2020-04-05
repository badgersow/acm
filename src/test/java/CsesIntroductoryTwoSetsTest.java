import org.junit.jupiter.api.Test;

class CsesIntroductoryTwoSetsTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryTwoSets().solve();
    }

    @Test
    public void sample1() throws Exception {
        compare("7", "YES\n4\n1 4 2 7 \n3\n3 6 5");
    }

    @Test
    public void sample2() throws Exception {
        compare("8", "YES\n4\n1 8 2 7 \n4\n3 6 4 5");
    }

    @Test
    public void sample3() throws Exception {
        compare("6", "NO");
    }

    @Test
    public void trivial1() throws Exception {
        compare("3", "YES\n2\n1 2 \n1\n3");
    }

    @Test
    public void trivial2() throws Exception {
        compare("4", "YES\n2\n1 4 \n2\n2 3");
    }
}