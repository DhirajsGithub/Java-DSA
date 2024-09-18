package com.Dhiraj;
import java.util.ArrayList;
import java.util.Arrays;

public class leetcode {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
//        int ans = checkIfPangram(sentence);
//        System.out.println(ans);

//        int popArr [][] = {{1993,1999},{2000,2010}};
//         System.out.println(maximumPopulation(popArr));
//        System.out.println(false || false || false || true);

        System.out.println(minCostToMoveChips(new int [] {1,2,2,2,2}));


    }
    static int checkIfPangram(String sentence) {
        // int [] apl = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char [] apl = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//         // converting full string to array of character
        char [] req = sentence.toCharArray();


        ArrayList<Character> ch = new ArrayList<>();
        int count = 0;
        for (char c : req){
            int start = 0;
            int end = apl.length - 1;

            while(start<=end){
                System.out.println("looping running");
                int mid = start + (end - start)/2;
                if (ch.contains(c)){
                    continue;
                }else{
                    ch.add(c);
                    if (apl[mid] == c){
                        count++;
                    }
                    else if(apl[mid] > c){
                        end = mid-1;
                    }else{
                        start = end + 1;
                    }

                }


            }
        }

        return (count);
//         ArrayList<Character> ch = new ArrayList<>();
//         int count = 0;
//         for (char c : apl){
//             for(char d : req) {
//                 if (ch.contains(d)){
//                     continue;
//                 }else if (c==d){
//                     ch.add(d);
//                     count ++;
//                 }
//             }
//         }

//         return (count == 26);
    }
    static int maximumPopulation(int[][] logs) {
        int maxYearPop = 1950;          // let 1950 be the year having maximum population
        int maxPop = 0;
        for (int i = 1950; i <= 2050; i++) {
            int count = 0;      // couting the population of each year
            for(int pers [] : logs){
                if(i>=pers[0] && i< pers[1]){
                    count ++;
                }
            }
            if(count>maxPop){
                maxYearPop = i;
                maxPop = count;
                System.out.println("max year pop "+ count + " year " + maxYearPop);
            }

        }
        return maxYearPop;
    }

    static boolean findRotation (int [][]mat, int [][] target){
        int n = target.length;
        boolean r1 = true;
        boolean r2 = true;
        boolean r3 = true;
        boolean r4 = true;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if( ( target[i][j] == mat[i][j] )){
                    r1 =  false;
                }
            }
        }
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if(  target[i][j] != mat[n-1-j][i]){
                    r2 =  false;
                }
            }
        }
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if( ( target[i][j] == mat[n-1-i][n-1-j] )){
                    r3 =  false;
                }
            }
        }
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if( (target[i][j] == mat[j][n-i-1])){
                    r4 =  false;
                }
            }
        }
        return r1||r2||r3||r4;
    }

    // remove -ve prefix --> sliding window

    static int maxSubArray(int [] nums){
        int maxSub = nums[0];
        int curSum = 0;
        for (int n : nums){
            if(curSum < 0){
                curSum = 0; // starting from new index
            }
            maxSub = Math.max(maxSub, curSum);   // tracking old subarrays, having max sum
        }
        return maxSub;
    }

    static int minCostToMoveChips (int [] position){
        // chips will be place either at even or old  place
        // each element is the position of ith chip
        int even = 0;
        int odd = 0;
        for(int chip: position){
            if(chip%2 ==0){
                even ++;        // moving chips to event position
            }else{
                odd ++;     // moving chips to odd position
            }
        }
        return Math.min(even, odd);
    }
}
