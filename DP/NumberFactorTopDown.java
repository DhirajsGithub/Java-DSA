import java.util.*;

public class NumberFactorTopDown {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] dp = new int[51];
        System.out.println(waysToGetNTopDownHelper2(6, dp));
    }

    private static int waysToGetNTopDownHelper2(int n, int[] dp) {
        if (n == 1 || n == 0 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (dp[n] == 0) {
            int i1 = waysToGetNTopDownHelper2(n - 1, dp);
            int i2 = waysToGetNTopDownHelper2(n - 3, dp);
            int i3 = waysToGetNTopDownHelper2(n - 4, dp);
            dp[n] = i1 + i2 + i3;
        }
        return dp[n];
    }

    private static int waysToGetNTopDownHelper(int n, HashMap<Integer, Integer> hashMap) {
        int ans = 0;
        if (n == 1 || n == 0 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            int i1 = waysToGetNTopDownHelper(n - 1, hashMap);
            int i2 = waysToGetNTopDownHelper(n - 3, hashMap);
            int i3 = waysToGetNTopDownHelper(n - 4, hashMap);
            hashMap.put(n, i1 + i2 + i3);
            return i1 + i2 + i3;
        }

    }
}
