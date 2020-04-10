import org.junit.jupiter.api.Test;

public class CsesIntroductoryDistinctNumbersTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryDistinctNumbers().solve();
    }

    @Test
    public void sample() {
        compare("5 2 3 2 2 3", "2");
    }
}