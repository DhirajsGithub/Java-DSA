public class HouseRobber {
    // given N number of houses along the street with some amount of money
    // adjacent houses cannot be stolen
    // find the maximum amount that can be stolen

    // approach --> we can start from first house skipping the second
    // or we can start from second house skipping the first
    // take max of both

    // houses = [6, 7, 1, 30, 8, 2, 4]
    // we can skip the first house we will have then [7, 1, 30, 8, 2, 4] houses
    // or we can take the first house then we will have [1, 30, 8, 2, 4] as we can't
    // really take adjacent houses
    public static void main(String[] args) {
        int houses[] = { 6, 7, 1, 30, 8, 2, 4 };
        System.out.println(maxMoney(houses, 0));
    }

    private static int maxMoney(int[] housesNetWorth, int currentIndex) {
        if (currentIndex >= housesNetWorth.length) {
            return 0;
        }

        int robFromFirstHouse = housesNetWorth[currentIndex] + maxMoney(housesNetWorth, currentIndex + 2);
        int robFromSecHouse = 0 + maxMoney(housesNetWorth, currentIndex + 1);

        return Math.max(robFromFirstHouse, robFromSecHouse);

    }
}
