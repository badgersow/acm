import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CsesIntroductoryRepetitions {

    public static void main(String[] args) throws Exception {
        new CsesIntroductoryRepetitions().solve();
    }

    void solve() throws Exception {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] input = in.readLine().toCharArray();

        int maxSeq = 1;
        int seq = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                seq++;
            } else {
                maxSeq = Math.max(seq, maxSeq);
                seq = 1;
            }
        }

        System.out.println(Math.max(seq, maxSeq));
    }
}
