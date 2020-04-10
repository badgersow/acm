import org.junit.jupiter.api.Test;

public class CsesIntroductoryGridPathsTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesIntroductoryGridPaths().solve();
    }

    @Test
    public void singular() {
        compare("DRURRRRRDDDLUULDDDLDRRURDDLLLLLURULURRUULDLLDDDD", "1");
    }

    @Test
    public void sample() {
        compare("??????R??????U??????????????????????????LD????D?", "201");
    }

    @Test
    public void something() {
        compare("????????????????????????L???????????????????????", "27735");
    }

    @Test
    public void total() {
        compare("????????????????????????????????????????????????", "88418");
    }

}