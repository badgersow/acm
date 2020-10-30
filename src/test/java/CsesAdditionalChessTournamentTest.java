import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalChessTournamentTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new CsesAdditionalChessTournament().solve();
    }

    @Test
    public void trivial() {
        compare("2 1 1", "1\n2 1");
    }

    @Test
    public void sample() {
        compare("5 1 3 2 0 2", "4\n2 5\n2 3\n2 1\n3 5");
    }

    @Test
    public void cses1() {
        compare("10 5 4 2 6 6 3 4 7 8 5", "25\n" +
                "9 8\n" +
                "9 5\n" +
                "9 4\n" +
                "9 10\n" +
                "9 1\n" +
                "9 7\n" +
                "9 2\n" +
                "9 6\n" +
                "8 4\n" +
                "8 5\n" +
                "8 1\n" +
                "8 10\n" +
                "8 2\n" +
                "8 7\n" +
                "5 4\n" +
                "5 10\n" +
                "5 1\n" +
                "5 7\n" +
                "4 1\n" +
                "4 10\n" +
                "4 2\n" +
                "6 3\n" +
                "6 2\n" +
                "3 10\n" +
                "1 7");
    }

    @Test
    public void testTle1() {
        compare(
                readFile("/cses_additional_chess_tournament_tle_in_1.txt"),
                readFile("/cses_additional_chess_tournament_tle_out_1.txt"));
    }

}