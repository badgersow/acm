import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CsesAdditionalChessTournament {

    public static void main(String[] args) throws Exception {
        new CsesAdditionalChessTournament().solve();
    }

    private final FastReader in = new FastReader();

    private final PrintWriter out = new PrintWriter(System.out);

    static class Node {
        int degree;

        List<Integer> players;

        Node next;

        public Node(int degree) {
            this(degree, new ArrayList<>(), null);
        }

        public Node(int degree, List<Integer> players, Node next) {
            this.degree = degree;
            this.players = players;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "degree=" + degree +
                    ", players=" + players +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return degree == node.degree &&
                    players.equals(node.players) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(degree, players, next);
        }
    }

    public void solve() throws Exception {
        final int n = in.nextInt();
        final int[][] a = new int[n][];

        int sumDegrees = 0;
        for (int i = 0; i < n; i++) {
            final int degree = in.nextInt();
            a[i] = new int[]{i + 1, degree};
            sumDegrees += degree;
        }

        if (sumDegrees % 2 == 1) {
            out.println("IMPOSSIBLE");
            out.flush();
            return;
        }

        Arrays.sort(a, Comparator.comparingInt((int[] arr) -> arr[1]).reversed());

        Node root = new Node(a[0][1]);
        Node current = root;
        for (int i = 0; i < a.length; i++) {
            if (a[i][1] < current.degree) {
                // Create new node
                Node next = new Node(a[i][1]);
                current.next = next;
                current = next;
            }

            current.players.add(a[i][0]);
        }

        int edges = sumDegrees / 2;
        final StringBuilder result = new StringBuilder(500_000);
        result.append(edges + "\n");
        while (true) {
            if (root == null || edges < root.degree) {
                out.println("IMPOSSIBLE");
                out.flush();
                return;
            }
            edges -= root.degree;
            root = step(root, result);
            if (edges == 0) {
                break;
            }
        }

        out.println(result);
        out.flush();
    }

    /**
     * @return null if the operation is not possible. Otherwise returns the next root.
     */
    static Node step(Node root, StringBuilder result) {
        // First, let's look at the root's degree
        int remainingNodes = root.degree;
        int rootPlayer = root.players.get(root.players.size() - 1);
        root.players.remove(root.players.size() - 1);

        Node current = root.players.isEmpty() ? root.next : root;
        while (remainingNodes > 0) {
            if (current == null || current.degree == 0) {
                // Impossible
                return null;
            }

            if (current.players.size() <= remainingNodes) {
                remainingNodes -= current.players.size();
                for (Integer player : current.players) {
                    result.append(rootPlayer)
                            .append(" ")
                            .append(player)
                            .append("\n");
                }
                current.degree--;
                current = current.next;
                continue;
            }

            // We know that part of people will decrement and part will not.
            Node second = new Node(current.degree - 1);
            for (int i = 0; i < remainingNodes; i++) {
                second.players.add(current.players.remove(current.players.size() - 1));
                result.append(rootPlayer)
                        .append(" ")
                        .append(second.players.get(second.players.size() - 1))
                        .append("\n");
            }

            second.next = current.next;
            current.next = second;

            current = current.next;
            break;
        }

        Node lastToMerge = current;
        current = root;

        while (true) {
            if (current == null || current.next == null) {
                // Nothing to do
                break;
            }

            // Merge
            if (current.degree == current.next.degree) {
                current.players.addAll(current.next.players);
                current.next = current.next.next;
            }

            if (current == lastToMerge) {
                break;
            }
            current = current.next;
        }

        return (root.players.isEmpty() || root.degree == 0) ? root.next : root;
    }

    private static class FastReader {

        private final int BUFFER_SIZE = 1 << 20;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) {
            try {
                din = new DataInputStream(new FileInputStream(fileName));
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String readLine() {
            byte[] buf = new byte[1001]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() {
            try {
                din.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int[] fillIntegerArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = nextInt();
            return array;
        }

        public long[] fillLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++)
                array[i] = nextLong();
            return array;
        }

        public <T extends List<Long>> T fillList(T list, int n) {
            for (int i = 0; i < n; i++)
                list.add(nextLong());
            return list;
        }
    }
}
