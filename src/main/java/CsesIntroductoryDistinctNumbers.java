import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CsesIntroductoryDistinctNumbers {

    public static void main(String[] args) {
        new CsesIntroductoryDistinctNumbers().solve();
    }

    public void solve() {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < n; i++) {
            numbers.add(in.nextInt());
        }

        System.out.println(numbers.size());
    }

}
