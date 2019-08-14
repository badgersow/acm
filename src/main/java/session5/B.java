package session5;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(new File("input.txt"));
        final PrintWriter out = new PrintWriter("output.txt");
        final int n = in.nextInt();

        final Map<LocalDate, Integer> peopleByDay = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final int m = in.nextInt(), d = in.nextInt(), p = in.nextInt(), t = in.nextInt();
            final LocalDate olimpDate = LocalDate.of(2013, m, d);
            for (int offset = 1; offset <= t; offset++) {
                final LocalDate preparation = olimpDate.minusDays(offset);
                peopleByDay.compute(preparation, (date, people) -> p + (people == null ? 0 : people));
            }
        }

        final int result = peopleByDay.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        out.println(result);
        out.close();
    }

}
