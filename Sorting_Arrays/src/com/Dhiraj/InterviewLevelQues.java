package com.Dhiraj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InterviewLevelQues {
    public static void main(String[] args) {
        // Q.1 Find the missing numbers, you have given n number from 0 to n find the missing number with big O (1) space and big O (N) time complexity
        // n = 4 therfore array is [0,4,1,3,2]  total 5 element, array given is [4,0, 2, 1] find the missing number
        // cyclic sort
        int [] arr = {4,0, 2, 1};
        System.out.println(missingNumber(arr));

        // Q.2 return array of missing number
        // given  nums[i] is in the range of [1, n] but some elements are missing
        int [] arr2 = {4,3,2,7,8,2,3,1};
        // the trick is the play with indices at inidice i element should be i+1
        System.out.println(missingNumberArray(arr2));

        // Q.3 given an array containing n+1 integers where each integer is fromm range 1 to n there is only one repeated element find that repeadted one
        int [] arr3 = {4,2,2,3,1};
        System.out.println(repeadtedNumber(arr3));

        // Q.4 find all the duplicates integers in an array containg all natural numbers from 1 to n some are repeating but all numbers till n are present
        int [] arr4 = {4,3,2,7,8,2,3,1,5, 6};
        System.out.println(repeatedNumArray(arr4));

        // Q.5 find the missing number and the repeadted number in an array given array contains [1, n] one is missing and one is duplicated
        int [] arr5 = {2,1,4,2,6,5};
        System.out.println(setMitchmatch(arr5));

        // Q.6 First missing positive in the array of given integers arr = [3,4,-1,1] cyclic condtion does not satisfy but we can ignore the -ve ones
        // condition of the que is space complexity is O(1) and time O(N).
        int [] arr6 = {3,4,-1,1};
        System.out.println(firstMissingPostive(arr6));

        System.out.println(Arrays.toString(intersect2(new int[] {1,2}, new int [] {1,1})));

        System.out.println(Arrays.deepToString(allCellsDistOrder(2, 2, 0, 1)));

        missNums(new int[] {5, 10, 2, 1});


    }
    // Q.1
    static int missingNumber(int [] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i]  ;
            if (arr[i] < arr.length && arr[i] != arr[correct]){      // ignoring the last one
                swap(arr, i, correct);
            }else{
                i ++;
            }
        }
        // search for the missing number
        for (int j=0; j< arr.length; j++){
            if (arr[j] != j){
                return j;
            }
        }
        return arr.length ;
    }

    // Q.2  missing numbers array
    static List<Integer> missingNumberArray(int [] arr){        // that's how we return array list
        int i = 0;
        while (i< arr.length){
            int correct = arr[i] -1;
            if (arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i ++ ;      // till here we have [1,2,3,4,3,2,7,8] index 4, 5 must containes 5, 6 but they don't
            }
        }
        // finding missing NumberS
        List<Integer> ans = new ArrayList<>();
        for (int j=0; j< arr.length; j++){
            if (arr[j] != j+1){
                ans.add(j+1);
            }
        }
        return ans;
    }

    // Q.3
    static int repeadtedNumber(int [] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] -1;
            if (arr[i] != arr[correct]){
                swap(arr, correct, i);
            }else{
                i ++;
            }
        }
//        // finding the repeated number
//        for (int j=0; j<arr.length; j++){
//            if(arr[j] !=j+1){
//                return j+1;
//            }
//        }
        return arr[arr.length-1];           // since only one duplicate is out there hence it will always left at the end
    }

    // Q.4
    static  List<Integer> repeatedNumArray(int [] arr){
        int i=0;
        while (i<arr.length){
            int correct = arr[i] -1;
            if (arr[i] != arr[correct]){
                swap(arr, correct, i);
            }else{
                i ++;
            }
        }
        // adding duplicates in ans2
        List<Integer> ans2 = new ArrayList<>();
        for (int j=0; j<arr.length; j++){
            if (arr[j] != j+1){
                ans2.add(arr[j]);
            }
        }
        return ans2;

    }

    // Q.5
    static int [] setMitchmatch (int [] arr){
        int i = 0;
        while (i<arr.length){
            int correct = arr[i] -1;
            if (arr[i] != arr[correct]){
                swap(arr, correct, i);
            }else{
                i ++;
            }
        }
        for (int j=0; j< arr.length; j++){
            if (arr[j] != j+1){
                // arr[j] is duplicate and j+1 is missing
               return new int [] {arr[j], j+1};
            }
        }
        return new int [] {-1, -1};

    }

    // Q.6 // Q.1
    static int firstMissingPostive(int [] arr){
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }

        // case 2
        return arr.length + 1;
    }


    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int [] intesect2Func(int [] nums1, int [] nums2){
        // nums1.length > nums2.length // must
        if(nums1.length<nums2.length){
            return new int [] {-1};
        }
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> un = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int k = 0; k < nums2.length; k++) {
                if(nums1[i] == nums2[k] && !un.contains(i)){
                    arr.add(nums1[i]);
                    un.add(i);
                }
            }
        }
        int ans [] = new int[arr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    static int [] intersect2(int [] nums1, int [] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0;
        int j=0;
        while (i< nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums2[j] < nums1[i]){
                j++;
            } else{
                arr.add(nums1[i]);
                i++;
                j++;
            }


        }

        int ans [] = new int[arr.size()];
        for (int k = 0; k < ans.length; k++) {
            ans[k] = arr.get(k);
        }
        return ans;

    }

    static void swap2 (int arr[][], int i, int j){
        int temp [] = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int [][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter){
        int ans [][] = new int[rows*cols][2];
        int distances [] = new int[rows*cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[k] = new int[] {i, j};
                k++;
            }
        }

        // bubble sort
//        ans = [[0, 0], [0, 1], [1, 0], [1, 1]]
        for (int i = 0; i < ans.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < ans.length-i; j++) {
                int r = i;
                int dis2 = Math.abs(rCenter - ans[j][0]) + Math.abs(cCenter-ans[j][1]);
                int dis1 =  Math.abs(rCenter - ans[j-1][0]) + Math.abs(cCenter-ans[j-1][1]);
                if(dis1 > dis2){
                    swap2(ans, j, j-1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        return ans;
    }

    public static int [] missNums(int arr []){
        int i = 0;
        while (i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]<=arr.length &&  arr[i]!= arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
            System.out.println("shi");
        }
        System.out.println("sorted array "+ Arrays.toString(arr));
        return new int[] {-1};
    }


}

// yaisa dekho yar is element at the correct index, if your are checking for element at 0th index then there might be possibility that the element is repeated
// and the next occuring element is at it's corrrect index like [3,1,3, 2, 4, 5]  3 is at correct index yes it is move on i++ is 1 at correct index no swap it with it's correct index !! and correct(arr[i] -1) in this case

// Note for cyclic sort
// if given [0, n] then we elements === index
// given [1, n] then element === index + 1
// if only one duplicate is present then it will come at last after sorting
// if more than one duplicates are present and are less than the biggest element and some numbers are missing them that duplicates will occupy the index of missing ones