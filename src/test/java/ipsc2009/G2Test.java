package ipsc2009;

import org.apache.commons.io.output.TeeOutputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class G2Test {

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
        test("3\n1 10\n2 3\n3 3", "0/1\n1/9\n11/27");
    }

    @Test
    public void sample1() {
        test("1\n1 2", "0/1");
    }

    @Test
    public void trivial() {
        test("1\n1 1", "0/1");
    }

    @Test
    public void fileTest() throws Exception {
        final String input = readFile("/ispc2009/g1.in");
        final String output = readFile("/ispc2009/g1.out");

        test(input, output);
    }

    private void test(String input, String output) {
        initialize(input);
        new G2().solve();
        final String result = stdoutMock.toString();
        assertThat(result.trim()).isEqualTo(output.trim());
    }

    private String readFile(String filename)  {
        return new Scanner(G2Test.class.getResourceAsStream(filename), "UTF-8").useDelimiter("\\A").next();
    }

}