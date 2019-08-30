package ipsc2000;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class C {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        final StringBuilder inputBuilder = new StringBuilder();
        while (in.hasNext()) {
            inputBuilder.append(in.nextLine());
        }
        final String input = inputBuilder.toString();

        final HashFunction hashFunction = Hashing.goodFastHash(64);
        final Map<Long, Integer> occurrencesByHash = new HashMap<>();
        for (int from = 0; from < input.length(); from++) {
            long hash = 0;
            for (int to = from + 1; to < input.length(); to++) {
                hash = (hash + input.charAt(to) * pow(base, from - to - 1)) % P;
                occurrencesByHash.compute(hash, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        final Multimap<Integer, Long> hashesByOccurance =
                ImmutableMultimap.copyOf(occurrencesByHash.entrySet()).inverse();

        final Map<Long, Integer> potentialOccurrencesByHash =
                occurrencesByHash.entrySet().stream()
                        .filter(e -> hashesByOccurance.get(e.getValue()).size() == 1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        final Map<String, Integer> potentialOccurrencesByWord = new HashMap<>();
        for (int from = 0; from < input.length(); from++) {
            long hash = 0;
            for (int to = from + 1; to < input.length(); to++) {
                hash = (hash + input.charAt(to) * pow(base, from - to - 1)) % P;
                if (potentialOccurrencesByHash.containsKey(hash)) {
                    potentialOccurrencesByWord.put(input.substring(from, to), potentialOccurrencesByHash.get(hash));
                }
            }
        }

        final Map<Integer, String> wordByOccurences = potentialOccurrencesByWord.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey,
                        (a, b) -> a, TreeMap::new));

        final AtomicInteger index = new AtomicInteger();
        wordByOccurences.forEach((occurrences, word) ->
                System.out.println(index.incrementAndGet() + " " + occurrences + " " + word));
    }

    private static long base = 257;

    private static long P = 1_000_000_009;

    private static long pow(long a, int n) {
        long r = 1L;
        while (n > 0) {
            if (n % 2 == 1) {
                r = (r * a) % P;
            }
            a = a * a % P;
            n /= 2;
        }
        return r;
    }
}
