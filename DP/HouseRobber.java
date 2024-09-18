public class HouseRobber {
    public static void main(String[] args) {
        int[] HouseNetWorth = { 2, 7, 9, 3, 1 };
        int dp[] = new int[HouseNetWorth.length];
        System.out.println(houseRobberTopDown(dp, HouseNetWorth, 0));
        System.out.println(houseRobberBottomUp(HouseNetWorth));
    }

    private static int houseRobberTopDown(int[] dp, int[] HouseNetWorth, int currentIndex) {
        if (currentIndex >= HouseNetWorth.length) {
            return 0;
        }
        // be careful here, all cases of HouseNetWorth can be 0 hence dp won't be of any
        // use, you can go with -1 as well
        if (dp[currentIndex] == 0) {
            int robFirstHouse = HouseNetWorth[currentIndex] + houseRobberTopDown(dp, HouseNetWorth, currentIndex + 2);
            int skipFirstHouse = houseRobberTopDown(dp, HouseNetWorth, currentIndex + 1);
            dp[currentIndex] = Math.max(robFirstHouse, skipFirstHouse);
        }
        return dp[currentIndex];
    }

    private static int houseRobberBottomUp(int[] HouseNetWorth) {
        // we will start from last house,
        int[] dp = new int[HouseNetWorth.length + 2];
        for (int i = HouseNetWorth.length - 1; i >= 0; i--) {
            dp[i] = Math.max(HouseNetWorth[i] + dp[i + 2], dp[i + 1]);
            // same as rob first house aur skip first house, take max of both
        }
        return dp[0];
    }
}
