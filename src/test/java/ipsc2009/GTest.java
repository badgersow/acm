package ipsc2009;

import org.apache.commons.io.output.TeeOutputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GTest {

    private static ByteArrayInputStream stdinMock;

    private static ByteArrayOutputStream stdoutMock;

    private void initialize(String input) {
        stdinMock = new ByteArrayInputStream(input.getBytes());
        stdoutMock = new ByteArrayOutputStream(1_000_000);

        System.setIn(stdinMock);
        System.setOut(new PrintStream(new TeeOutputStream(System.out, stdoutMock)));
    }

    @Test
    public void sample() {
        initialize("3\n1 10\n2 3\n3 3 ");
        new G().solve();
        final String result = stdoutMock.toString();

        assertThat(result).isEqualTo("0/1\n1/9\n11/27");
    }

}