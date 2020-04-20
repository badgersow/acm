import org.junit.jupiter.api.Test;

public class CsesSortingTaskAndDeadlinesTest extends AcmTest {

    @Override
    void processInput() throws Exception {
        new CsesSortingTaskAndDeadlines().solve();
    }

    @Test
    public void sample() {
        compare("3 6 10 8 15 5 12", "2");
    }
}
