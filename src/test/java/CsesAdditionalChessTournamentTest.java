import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CsesAdditionalChessTournamentTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesAdditionalChessTournament().solve();
    }

    @Test
    public void sample() {
        compare("5 1 3 2 0 2", "4\n2 3\n2 5\n2 1\n5 3");
    }

    @Test
    public void testImpossibleStep() {
        final CsesAdditionalChessTournament.Node inputRoot =
                new CsesAdditionalChessTournament.Node(4, new ArrayList<>(Arrays.asList(1, 2)), null);

        final CsesAdditionalChessTournament.Node result = CsesAdditionalChessTournament.step(inputRoot, new StringBuilder());
        assertThat(result).isNull();
    }

    @Test
    public void testSimpleStep() {
        final CsesAdditionalChessTournament.Node inputRoot =
                new CsesAdditionalChessTournament.Node(1, new ArrayList<>(Arrays.asList(1, 2)), null);

        final CsesAdditionalChessTournament.Node result = CsesAdditionalChessTournament.step(inputRoot, new StringBuilder());
        assertThat(result).isNull();
    }

    @Test
    public void testComplexStep1() {
        final CsesAdditionalChessTournament.Node inputRoot =
                new CsesAdditionalChessTournament.Node(5, new ArrayList<>(Arrays.asList(1, 2)),
                        new CsesAdditionalChessTournament.Node(4, new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7)),
                                new CsesAdditionalChessTournament.Node(3, new ArrayList<>(Arrays.asList(8, 9)), null)));

        final CsesAdditionalChessTournament.Node expected =
                new CsesAdditionalChessTournament.Node(4, new ArrayList<>(Arrays.asList(1, 3)),
                        new CsesAdditionalChessTournament.Node(3, new ArrayList<>(Arrays.asList(7, 6, 5, 4, 8, 9)), null));

        final CsesAdditionalChessTournament.Node result = CsesAdditionalChessTournament.step(inputRoot, new StringBuilder());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testZeroRoot() {
        final CsesAdditionalChessTournament.Node inputRoot =
                new CsesAdditionalChessTournament.Node(5, new ArrayList<>(Arrays.asList(1)),
                        new CsesAdditionalChessTournament.Node(4, new ArrayList<>(Arrays.asList(3, 4, 5)),
                                new CsesAdditionalChessTournament.Node(3, new ArrayList<>(Arrays.asList(6, 7, 8)),
                                        new CsesAdditionalChessTournament.Node(2, new ArrayList<>(Arrays.asList(9, 10, 11)), null))));

        final CsesAdditionalChessTournament.Node expected =
                new CsesAdditionalChessTournament.Node(3, new ArrayList<>(Arrays.asList(3, 4, 5, 6)),
                        new CsesAdditionalChessTournament.Node(2, new ArrayList<>(Arrays.asList(8, 7, 9, 10, 11)), null));

        final CsesAdditionalChessTournament.Node result = CsesAdditionalChessTournament.step(inputRoot, new StringBuilder());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void cses1() {
        compare("10 5 4 2 6 6 3 4 7 8 5", "25\n" +
                "9 8\n" +
                "9 4\n" +
                "9 5\n" +
                "9 1\n" +
                "9 10\n" +
                "9 2\n" +
                "9 7\n" +
                "9 6\n" +
                "8 4\n" +
                "8 5\n" +
                "8 1\n" +
                "8 10\n" +
                "8 2\n" +
                "8 7\n" +
                "5 4\n" +
                "5 1\n" +
                "5 10\n" +
                "5 3\n" +
                "4 6\n" +
                "4 7\n" +
                "4 2\n" +
                "10 1\n" +
                "10 3\n" +
                "2 7\n" +
                "6 1");
    }

    @Test
    public void testTle1() {
        compare(
                readFile("/cses_additional_chess_tournament_tle_in_1.txt"),
                readFile("/cses_additional_chess_tournament_tle_out_1.txt"));
    }

}