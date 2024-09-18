import java.util.HashMap;

public class FibonacciMemoization {
    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(nthFibo(43, memo));
    }

    private static int nthFibo(int n, HashMap<Integer, Integer> memo) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int res = nthFibo(n - 1, memo) + nthFibo(n - 2, memo);
            memo.put(n, res);
            return res;
        }
    }
}
