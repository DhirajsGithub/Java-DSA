import java.util.ArrayList;
import java.util.List;

public class FibonacciTabulation {
    public static void main(String[] args) {
        System.out.println(fiboTabulation(43));
    }

    private static int fiboTabulation(int n) {
        ArrayList<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for (int i = 2; i < n; i++) {
            int first = tb.get(i - 2);
            int second = tb.get(i - 1);
            tb.add(first + second);
        }
        return tb.get(n - 1);
    }
}
