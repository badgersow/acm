// https://cses.fi/problemset/task/1704
// Network Renovation
// upsolve with rainboy
// https://cses.fi/problemset/hack/1704/entry/169196/ (Noam527)

import java.io.*;
import java.util.*;

public class CsesPlunderedNetworkRenovation extends PrintWriter {
    CsesPlunderedNetworkRenovation() {
        super(System.out);
    }

    static class Scanner {
        Scanner(InputStream in) {
            this.in = in;
        }

        InputStream in;
        int k, l;
        byte[] bb = new byte[1 << 15];

        byte getc() {
            if (k >= l) {
                k = 0;
                try {
                    l = in.read(bb);
                } catch (IOException e) {
                    l = 0;
                }
                if (l <= 0) return -1;
            }
            return bb[k++];
        }

        int nextInt() {
            byte c = 0;
            while (c <= 32) c = getc();
            int a = 0;
            while (c > 32) {
                a = a * 10 + c - '0';
                c = getc();
            }
            return a;
        }
    }

    Scanner sc = new Scanner(System.in);

    public static void main(String[] $) {
        CsesPlunderedNetworkRenovation c = new CsesPlunderedNetworkRenovation();
        c.main();
        c.flush();
    }

    ArrayList[] adjacent;
    int[] leaves;
    int n, leavesCount = 0;

    void dfs(int previous, int node) {
        ArrayList<Integer> adj = adjacent[node];
        if (adj.size() == 1)
            leaves[leavesCount++] = node;
        else
            for (int j : adj)
                if (j != previous)
                    dfs(node, j);
    }

    void main() {
        n = sc.nextInt();
        adjacent = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjacent[i] = new ArrayList<Integer>();
        for (int h = 0; h < n - 1; h++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            adjacent[i].add(j);
            adjacent[j].add(i);
        }
        int r = 0;
        while (adjacent[r].size() == 1)
            r++;
        leaves = new int[n];
        dfs(-1, r);
        int newEdges = (leavesCount + 1) / 2;
        println(newEdges);
        for (int h = 0; h < newEdges - 1; h++)
            println(leaves[h] + 1 + " " + (leaves[(newEdges - 1) * 2 - h] + 1));
        println(leaves[newEdges - 1] + 1 + " " + (leaves[leavesCount - 1] + 1));
    }
}