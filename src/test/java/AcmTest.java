import org.apache.commons.io.output.TeeOutputStream;

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
        stdoutMock = new ByteArrayOutputStream(100_000_000);

        System.setIn(stdinMock);
        System.setOut(new PrintStream(new TeeOutputStream(System.out, stdoutMock)));
    }

    void compare(String input, String output) {
        initialize(input);
        processInput();
        final String result = stdoutMock.toString();
        assertThat(result.trim()).isEqualTo(output.trim());
    }

    String readFile(String filename) {
        return new Scanner(AcmTest.class.getResourceAsStream(filename), "UTF-8").useDelimiter("\\A").next();
    }

    abstract void processInput();

}
