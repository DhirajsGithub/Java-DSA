package com.Dhiraj;

import java.util.*;

public class LeetCodeMedium {
    public static void main(String[] args) {
        String[] s = new String[5];
//        System.out.println(Arrays.toString(s));
        int temp[][] = new int[3][3];
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = count;
                count++;
            }
        }
//        System.out.println(Arrays.deepToString(temp));
//        System.out.println(Arrays.deepToString(spiralMatrix3(1, 2, 0, 1)));

//        int arr [][] = {{0, 2, 0, 5}, {3, 4, 5, 6}, {1, 2, 6, 3}};
//        System.out.println(Arrays.deepToString(arr));
//        setMatrixZeroes(arr);
//        System.out.println(Arrays.deepToString(arr));

        int arr2 [] = {-1,1,0,-3,3};
//        System.out.println(Arrays.toString(productExceptSelf(arr2)));

        int arr3 [] = {1,1,1,2,2,3};

        System.out.println(Arrays.toString(topKFrequesntElement(arr3, 2)));

        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(maxArea(new int[]{1,2}));

        System.out.println(threeSum(new int [] {-1,0,1,2,-1,-4}));

    }
    public static int [][] spiralMatrix3 (int rows, int cols, int rStart, int cStart){
        int [][] temp = new int [(rows*cols)][2];
        int [][] arr = new int[rows][cols];

        int k = 0;
        int l = cStart;
        int r = cStart + 1;
        int t = rStart;
        int b = rStart + 1;


        while(k<rows*cols){
            // left to right
            for(int i=l; i<r; i++){
                if(i< cols && i>=0 && t < rows && t>=0){
                    temp[k] = new int [] {t, i};
                    k++;
                }
            }

            // bottom to top
            for (int i = t; i<b; i++) {
                if(i<rows && i>=0 &&  r<cols && r>=0 ){
                    temp[k] = new int [] {i, r};
                    k++;
                }
            }


            l--;
            // right to left
            for(int i=r; i>l; i-- ){
                if(i>=0 && i<cols && b<rows && b>=0){
                    temp[k] = new int [] {b, i};
                    k++;
                }
            }
            r++;
            t--;

            // top to bottom
            for (int i = b; i>t; i--) {
                if(i<rows && i>=0 &&  l<cols && l>=0 ){
                    temp[k] = new int [] {i, l};
                    k++;
                }
            }
            b++;

        }

        return temp;

    }

    public static int [][] spiralMatrix2 (int n){
        int [][] temp = new int [n][n];
        int [][] arr = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        int l = 0;
        int r = n;
        int t = 0;
        int b = n;
        int k = 0;
        int row = 0;
        int col = 0;
        while(l<r && t<b && row < n ){
           // left to right
            for(int i=l; i<r && col<n && row<n; i++){
                temp[t][i] = arr[row][col];
                col ++;
                k++;
                if(k >= n){
                    k = 0;
                    col = 0;
                    row ++;
                }
            }

            t++;
            // top to bottom
            for (int i = t; i < b && col<n && row<n; i++) {
                temp[i][r-1] = arr[row][col];
                k++;
                col++;
                if(k >= n){
                    k = 0;
                    col = 0;
                    row ++;
                }
            }

            r--;
            // right to left
            for (int i = r-1; i >=l && col<n  && row<n; i--) {
                temp[b-1][i] = arr[row][col];
                col++;
                k++;
                if(k >= n){
                    k = 0;
                    col = 0;
                    row ++;
                }
            }


            b--;
            // bottom to top
            for (int i = b-1; i >=t && col<n && row<n; i--) {
                temp[i][l] = arr[row][col];
                col++;
                k++;
                if(k >= n){
                    k = 0;
                    col = 0;
                    row ++;
                }
            }

            l++;
        }
        return temp;
    }

    public static int [] spiralMatrix(int [] [] arr){
        int l = 0;
        int r = arr[0].length;
        int t = 0;
        int b = arr.length;
        int temp [] = new int[arr[0].length*arr.length];
        int k = 0;
        while(l<r && t<b){
            // left to right
            for(int i=l; i<r && k<temp.length; i++){
                temp[k] = arr[t][i];
                k ++;
            }

           t++;
            // top to bottom
            for(int i=t; i<b && k<temp.length; i++){
                temp[k] = arr[i][r-1];
                k++;
            }

            r--;
            // right to left
            for(int i=r-1; i>=l && k<temp.length; i--){
                temp[k] = arr[b-1][i];
                k ++;
            }
            b--;

            // bottom to top
            for(int i=b-1; i>=t && k<temp.length; i--){
                temp[k] = arr[i][l];
                k++;
            }
            l++;

        }

        return temp;
    }

    public static int[] goAround(int [] [] arr, int l, int r, int t, int b){
        int size = ((arr.length-1) + (arr[0].length -1))*2;
        if(arr.length == 1){
            size = arr[0].length;
        }
        if(arr[0].length == 1){
            size = arr.length;
        }

        if(size < 0){
            return new int[-1];
        }
        if(size == 0){
            size = 1;
        }
        int [] temp = new int[size];
        int k=0;
        // left to right
        for(int i=0; i<arr[0].length && k<size; i++){
            temp[k]  = arr[0][i];
            k++;
        }
        // top to bottom]]
        for(int i=1; i<arr.length && k<size; i++){
            temp[k] = arr[i][arr[0].length-1];
            k++;
        }
        // right to left
        // r wil be 2 initally and it will get increased
        for(int i=arr[0].length-2; i>=0 && k<size; i--){
            System.out.println("right to left "+ arr[arr.length-1][i]);
            temp[k]  = arr[arr.length-1][i];
            k++;
        }
        // bottom to top
        for(int i=arr.length-2; i>0 && k<size; i--){
            temp[k] = arr[i][0];
            k++;
        }
        return temp;
    }

    public static void makeRowColZero(int [][] arr, int r, int c){
        for(int i=0; i<arr[0].length; i++){
            arr[r][i] = 0;
        }
        for(int i=0; i<arr.length; i++){
            arr[i][c] = 0;
        }
    }

    public static void setMatrixZeroes(int [][] arr){
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    li.add(temp);
                }
            }
        }

        for (int i = 0; i < li.size(); i++) {
            makeRowColZero(arr, li.get(i).get(0), li.get(i).get(1));
        }
    }

    public static int [] productExceptSelf(int arr[]){

        int product1 = 1;
        int product2 = 1;        // for zero
        int numOfZeroes = 0;
        for(int num : arr){
           if(num != 0){
               product2 = product2*num;
           }
           if(num == 0){
               numOfZeroes++;
           }
           product1 = product1*num;
        }
        for (int i = 0; i < arr.length; i++) {
            if(numOfZeroes <=1 ){
                if(arr[i] == 0){
                    arr[i] = product2;
                }else{
                    arr[i] = product1/arr[i];
                }
            }else{
                arr[i] = 0;
            }
        }
        return arr;
    }


//    https://leetcode.com/problems/jump-game/description/
    public static boolean jumpGame(int arr []){
        
        return false;
    }

//    https://leetcode.com/problems/top-k-frequent-elements/description/

    public static int [] topKFrequesntElement(int arr [], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        ArrayList<Integer> list2 = new ArrayList<>(list.subList(0, k));

        int[] ans = new int[list2.size()];
        int j = 0;
        for (var entry : map.entrySet()) {
            if (list2.contains(entry.getValue())) {
                ans[j++] = entry.getKey();
            }
        }

        return ans;
    }

//    https://leetcode.com/problems/maximum-subarray/description/
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        int j=1;
        while (j<nums.length){
            if(curSum < 0){
                curSum = 0;
            }
            curSum += nums[j];
            maxSum = Math.max(curSum, maxSum);
            j++;
        }

        return maxSum;
    }

//    https://leetcode.com/problems/container-with-most-water/description/
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int curArea = 0;
        int j=height.length-1;
        int i=0;
        // heights will contain atleast 2 elements

        while (i<j){
            // initially base is max we know, search for that height which is max for descent base

            curArea = (j-i)*Math.min(height[i], height[j]);

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
            System.out.println(curArea);
            maxArea = Math.max(maxArea, curArea);


            // brute force
//            for (int k = 0; k < height.length-1 && k<j; k++) {
//                curArea = (j-k)*Math.min(height[k], height[j]);
//                maxArea = Math.max(maxArea, curArea);
//                System.out.println(curArea);
//            }
//            j--;

        }


        return maxArea;
    }

//    https://leetcode.com/problems/3sum/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        Arrays.sort(nums);
        // same as two-sum-ii problem, except one number will get add up, and that number must be unique
        // sorting will help skipping the duplicates, see the line below if nums[i] == nums[i-1] it get's continue
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j=i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    li.add(temp);
                    // for two sum we are returning from here, hence no need to check for duplicates
                    // but since we are storing elements we need to check for duplicates here
                    j++;
                    while(j<k && j>0&& nums[j] == nums[j-1]){
                        j++;
                    }
                }
                if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return li;
    }
}














