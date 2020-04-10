import org.junit.jupiter.api.Test;

public class CsesSortingConcertTicketsTest extends AcmTest {
    @Override
    void processInput() throws Exception {
        new CsesSortingConcertTickets().solve();
    }

    @Test
    public void sample() {
        compare("5 3 5 3 7 8 5 4 8 3", " 3\n8\n-1");
    }
}
