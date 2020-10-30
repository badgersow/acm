import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesSortingConcertTicketsTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesSortingConcertTickets().solve();
    }

    @Test
    public void sample() {
        compare("5 3 5 3 7 8 5 4 8 3", " 3\n8\n-1");
    }

    @Test
    public void tle1() {
        compare(
                readFile("/cses_sorting_concert_ticket_tle_in_1.txt"),
                readFile("/cses_sorting_concert_ticket_tle_out_1.txt"));
    }

}
