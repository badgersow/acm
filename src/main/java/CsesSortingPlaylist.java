import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

public class CsesSortingPlaylist {

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private PrintWriter out = new PrintWriter(System.out);

    private int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        new CsesSortingPlaylist().solve();
    }

    public void solve() throws Exception {
        final int n = nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }

        out.println(itya(a));
        out.flush();
    }

    public int itya(int[] playlist) {
        int maxSize = 1;
        int firstPointer = 0;
        int secondPointer = 1;
        Set<Integer> currentSequence = new HashSet<>();
        currentSequence.add(playlist[firstPointer]);
        while (secondPointer < playlist.length) {
            int nextSymbol = playlist[secondPointer];
            while (currentSequence.contains(nextSymbol)) {
                currentSequence.remove(playlist[firstPointer]);
                firstPointer++;
            }
            currentSequence.add(nextSymbol);
            maxSize = Math.max(maxSize, secondPointer - firstPointer + 1);
            secondPointer++;
        }
        return maxSize;
    }

}
