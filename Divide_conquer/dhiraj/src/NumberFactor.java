public class NumberFactor {
    public static void main(String[] args) {
        // given N find number of ways to express N as sum of 1, 3, 4
        System.out.println(numberOfWays(0));
    }

    public static int numberOfWays(int n) {
        int ans = 0;
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else if (n == 3) { // {1, 1, 1}, {3}
            return 2;
        } else if (n == 4) { // {1,1, 1, 1}, {1, 3}, {3, 1}, {4}
            return 4;
        }
        ans += (numberOfWays(n - 1)) + (numberOfWays(n - 3)) + (numberOfWays(n - 4));
        return ans;
    }
}
