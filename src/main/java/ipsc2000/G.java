package ipsc2000;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Windy office
 */
public class G {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            final int n = in.nextInt();
            final Multimap<Integer, Integer> procedureByPage = HashMultimap.create();

            for (int i = 0; i < n; i++) {
                procedureByPage.put(in.nextInt(), in.nextInt());
            }

            solve(procedureByPage);
        }
    }

    private static void solve(Multimap<Integer, Integer> procedureByPage) {
        final Multimap<Integer, Integer> pageByProcedure =
                ImmutableMultimap.copyOf(procedureByPage).inverse();
        final Multimap<Integer, Integer> pagesGraph = HashMultimap.create();
        for (Map.Entry<Integer, Collection<Integer>> entry : pageByProcedure.asMap().entrySet()) {
            final Collection<Integer> pages = entry.getValue();

            final List<Integer> pagesWithMoreThanOneProcedure =
                    pages.stream().filter(p -> procedureByPage.get(p).size() > 1).collect(Collectors.toList());
            final List<Integer> pagesWithOneProcedure =
                    pages.stream().filter(p -> procedureByPage.get(p).size() == 1).collect(Collectors.toList());

            if (pagesWithMoreThanOneProcedure.size() > 2) {
                // Not possible
                System.out.println("NO");
                return;
            }

            final List<Integer> lineOrder =
                    Stream.concat(
                            Stream.concat(pagesWithMoreThanOneProcedure.stream().limit(1),
                                    pagesWithOneProcedure.stream()
                            ),
                            pagesWithMoreThanOneProcedure.stream().skip(1)
                    ).collect(Collectors.toList());

            for (int i = 0; i < lineOrder.size() - 1; i++) {
                pagesGraph.put(lineOrder.get(i), lineOrder.get(i + 1));
                pagesGraph.put(lineOrder.get(i + 1), lineOrder.get(i));
            }
        }

        final int maxDegree = pagesGraph.asMap().values().stream().mapToInt(Collection::size).max().orElse(0);
        if (maxDegree > 2) {
            // Impossible to reconstruct the order
            System.out.println("NO");
            return;
        }

        final HashSet<Integer> visited = new HashSet<>();
        for (Integer page : procedureByPage.keySet()) {
            if (visited.contains(page)) {
                continue;
            }

            boolean cycle = checkCycles(page, null, pagesGraph, visited);
            if (cycle) {
                System.out.println("NO");
                return;
            }
        }

        visited.clear();
        for (Integer page : procedureByPage.keySet()) {
            if (visited.contains(page) || pagesGraph.get(page).size() > 1) {
                continue;
            }

            printDfs(page, null, pagesGraph, visited);
        }
    }

    private static void printDfs(Integer page, Integer previous, Multimap<Integer, Integer> pagesGraph, HashSet<Integer> visited) {
        visited.add(page);
        System.out.println(page);

        for (Integer child : pagesGraph.get(page)) {
            if (child.equals(previous)) {
                continue;
            }

            if (visited.contains(child)) {
                throw new IllegalStateException("This shouldn't happen");
            }

            printDfs(child, page, pagesGraph, visited);
        }
    }

    private static boolean checkCycles(Integer page, Integer previous, Multimap<Integer, Integer> pagesGraph, HashSet<Integer> visited) {
        visited.add(page);
        for (Integer child : pagesGraph.get(page)) {
            if (child.equals(previous)) {
                continue;
            }

            if (visited.contains(child)) {
                return true;
            }

            if (checkCycles(child, page, pagesGraph, visited)) {
                return true;
            }
        }

        return false;
    }

}
