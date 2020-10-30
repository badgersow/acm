import org.junit.Test;
import util.AcmTest;

public class CsesSortingPlaylistTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesSortingPlaylist().solve();
    }

    @Test
    public void itya1() {
        compare("4 1 1 1 1", "1");
    }

    @Test
    public void itya2() {
        compare("8 1 2 1 3 2 7 4 2", "5");
    }

    @Test
    public void itya3() {
        compare("8 1 2 3 4 5 6 7 8", "8");
    }

}