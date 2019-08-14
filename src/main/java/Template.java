import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Template {

    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    private static String nextString() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws Exception {
        // your code here
        out.flush();
    }
}
