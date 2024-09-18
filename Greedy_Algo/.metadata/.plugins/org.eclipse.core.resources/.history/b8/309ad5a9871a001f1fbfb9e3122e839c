package greedyAlgo;

import java.util.Arrays;

public class CoinChangeProblem {
	
	public static void main(String[] args) {
		int [] coins = {1, 2, 5, 10, 20, 50, 100, 1000};
		int amount = 2035;
		coinChangeProblem(coins, amount);
	}
	
	
	public static void coinChangeProblem(int[] coins, int N) {
		Arrays.sort(coins);
		int index = coins.length-1;
		while(true) {
			// denominations = {1, 2, 5, 10, 20, 50, 100, 1000}
			int coinValue = coins[index];
			index--;
			int maxAmount = (N/coinValue)*coinValue;		
			// coinValue is 1000 and N is 2035 we know we can use 1000 two time, hence maxAmount using above will be 2000
			if(maxAmount > 0) {
				System.out.println("Coin value: "+coinValue+ " taken count : "+ (N/coinValue));
				// taken count is like 2035/1000 which will be 2 and indeed we use 1000 two time in one go
				N = N - maxAmount;
			}
			// see after doing 2035-2000 we have 35 left and index is now at 100 the for next iteration maxAmoun will be zero 
			// as (35/100)*100 = 0 coz (35/100) will be zero coz they are integers hence we will go to lower index and so on
			if(N==0) {
				break;
			}
		}
	}
	

}
