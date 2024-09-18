public class NumberFactorBottomUp {
    public static void main(String[] args) {
        System.out.println(numberFactor(6));
    }

    private static int numberFactor(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }

}
