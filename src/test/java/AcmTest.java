import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AcmTest {

    private static ByteArrayInputStream stdinMock;

    private static ByteArrayOutputStream stdoutMock;

    void initialize(String input) {
        stdinMock = new ByteArrayInputStream(input.getBytes());
        stdoutMock = new ByteArrayOutputStream(10_000_000);

        System.setIn(stdinMock);
        System.setOut(new PrintStream(stdoutMock));
    }

    void compare(long input, long output) {
        compare(String.valueOf(input), String.valueOf(output));
    }

    void compare(String input, String output) {
        try {
            initialize(input);
            processInput();
            final String result = stdoutMock.toString();
            assertThat(result.trim()).isEqualTo(output.trim());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    String readFile(String filename) {
        return new Scanner(AcmTest.class.getResourceAsStream(filename), "UTF-8").useDelimiter("\\A").next();
    }

    abstract void processInput() throws Exception;

}
