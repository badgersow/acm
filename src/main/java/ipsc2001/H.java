package ipsc2001;

import com.google.common.collect.Comparators;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H {
    public static void main(String[] args) {
        final PrintWriter out = new PrintWriter(System.out);
        int n = 7;
        final Map<List<Integer>, Integer> cardBySet = new HashMap<>();
        fillTheSet(n, cardBySet);
        final Map<List<Integer>, Integer> cardByLargeSet = toLargeSet(cardBySet);
        cardByLargeSet.forEach();
    }

    private static Map<List<Integer>, Integer> toLargeSet(Map<List<Integer>, Integer> cardBySet) {
        return cardBySet.entrySet().stream()
                .sorted(e -> Comparators.lexicographical())
    }

}
