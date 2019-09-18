package experimental;

public class Experiment {
    public static void main(String[] args) {
        int x = 8 + 4 + 2 + 1;
        int b = 0;
        do {
            System.out.println(b);
        } while ((b = (b - x) & x) != 0);
    }
}
