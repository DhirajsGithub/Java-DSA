package com.Dhiraj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetcodeMedium {
    public static void main(String[] args) {
//        int arr [] = {1};
//        System.out.println(findDuplicateNumber(arr));

//        int arr2 [] = {4,3,2,7,8,2,3,1};
//        findAllDuplicates(arr2);
//        System.out.println(findAllDuplicates(arr2));



        int arr3 [] = {-1,0,1,2,-1,-4};
//        System.out.println(threeSum(arr3));

        int arr4 [] = {2,3,4};
//        System.out.println(Arrays.toString(twoSum2(arr4, 6)));

        int arr5 [] = {-1,2,1,-4};
//        System.out.println(threeSumClosest(arr5, 1));

        int arr6 [] = {1000000000,1000000000,1000000000,1000000000};
//        System.out.println(fourSum(arr6, -294967296));

        long num1 = (long)1000000000*4;
        long n1 = arr6[0];
        long n2 = arr6[1];
        long n3 = arr6[2];
        long n4 = arr6[3];
        int n5 = 434245;

        long sum = (n1 + n2 + n3 + n4);
        System.out.println(num1);
        System.out.println(sum);

    }

    public static void swap(int [] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

//    https://leetcode.com/problems/find-the-duplicate-number/description/
    public static int findDuplicateNumber(int arr[]){
        // guranted only one element is repeated and numbers will be from 1 to n
        // we are using cyclic sort,
        // if current element is not at it's desire position and on it's desire position there exist a element which satisfies the position is the
        // element which is repeated !
        int i=0;
        int repeat = -1;
        while (i<arr.length){
            if(arr[i] != i+1 && arr[arr[i]-1] == arr[i]){
                repeat =  arr[i];
                break;
            }
            else if(arr[i] != i+1){
                // this guranted arr[i] is now at it's desire position
                swap(arr, i, arr[i]-1);

            }else{
                i++;
            }
            System.out.println(Arrays.toString(arr));
        }
        return repeat;
    }


//    https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
    public static List<Integer> findAllDuplicates(int [] arr){
        List<Integer> li = new ArrayList<>();
        int i=0;
        while (i<arr.length){
            int correct = arr[i] -1;

            if (arr[i] != arr[correct]){
                swap(arr, correct, i);
            }else{
                i ++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1){
                li.add(arr[j]);
            }
        }
        System.out.println(li);
        return li;
    }


    //    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    public static int [] twoSum2 (int [] arr, int target){
        // provided array is sorted in non decreasing order
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i] + arr[j] == target){
//                    return new int [] {i+1, j+1};
//                }
//                if(arr[i] + arr[j] > target){
//                    break;
//                }
//            }
//        }

        // much more cleaner and niter than above one
        int i=0;
        int j = arr.length-1;
        // since array is sorted
        while(i<j){
            if(arr[i] + arr[j] == target){
                return new int [] {i+1, j+1};
            }
            if(arr[i] + arr[j] > target){
                j--;
            }
            i++;
        }

        return new int [] {-1, -1};
    }

//    https://leetcode.com/problems/3sum/description/
    public static List<List<Integer>> threeSum (int [] arr){
        List<List<Integer>> li = new ArrayList<>();
        Arrays.sort(arr);
        // same as two-sum-ii problem, except one number will get add up, and that number must be unique
        // sorting will help skipping the duplicates, see the line below if arr[i] == arr[i-1] it get's continue
        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int j=i+1;
            int k = arr.length-1;
            while(j<k){
                if(arr[i] + arr[j] + arr[k] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    li.add(temp);
                   // for two sum we are returning from here, hence no need to check for duplicates
                    // but since we are storing elements we need to check for duplicates here
                    j++;
                    while(j<k && j>0&& arr[j] == arr[j-1]){
                        j++;
                    }
                }
                if(arr[i] + arr[j] + arr[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return li;
        // time will be N(logN) (sorting) + O(N^2) (worst cast) = O(N^2)
        // space will be O(N) for sorting
    }



//    https://leetcode.com/problems/3sum-closest/
    public static int threeSumClosest (int [] nums, int traget){


        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            int k = nums.length-1;
            while (j<k){
                if(Math.abs(nums[i] + nums[j] + nums[k] - traget) < Math.abs(result-traget)){
                    result = nums[i] + nums[j] + nums[k];
                }
                if(nums[i] + nums[j] + nums[k] > traget){
                    k--;
                }else{
                    j++;
                }



            }

        }

        return result;

        // we learn whenever there is closest part we need to think of difference
    }

//    https://leetcode.com/problems/4sum/
//    public static List<List<Integer>> fourSum (int [] arr, int target){
//        List<List<Integer>> li = new ArrayList<>();
//
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        // try to solve same as 3sum, but with extra loop
//        for (int i = 0; i < arr.length; i++) {
//            if(i>0 && arr[i] == arr[i-1]){
//                continue;
//            }
//            for (int j = i+1; j < arr.length; j++) {
//                if(j>i+1 && arr[j] == arr[j-1]){
//                    continue;
//                }
//                int k=j+1;
//                int l = arr.length-1;
//                while (k<l){
//                    long n1 = arr[i];
//                    long n2 = arr[j];
//                    long n3 = arr[k];
//                    long n4 = arr[l];
//
//                    long sum = (n1 + n2 + n3 + n4);
//                         // -294967296
//                    System.out.println(sum);
//                    if( sum == (long)target){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(arr[i]);
//                        temp.add(arr[j]);
//                        temp.add(arr[k]);
//                        temp.add(arr[l]);
//                        li.add(temp);
//
//                        k++;
//                        while ( k<l && arr[k] == arr[k-1]){
//                            k++;
//                        }
//
//
//                    }
//                    if( arr[i] + arr[j] + arr[k] + arr[l] > target){
//                        l--;
//                    }else{
//                        k++;
//                    }
//                }
//            }
//        }
//
//        return li;
//    }

    // time complexity problem with above solution, also it is valid for 4sum only, we need a general approach for ksum
    // it will be done using recursion
    public static void kSum(int arr[], int k, int start, int target, List<List<Integer>> li){

        Arrays.sort(arr);       // to remove duplicates quadruples or triplets

        if(k!=2){
            for (int i = start; i < arr.length-k+1; i++) {
                // if it's four sum k=4, and this loop will run only once
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                kSum(arr, k-1, i+1, target-arr[i], li);
                temp.remove(temp.size()-1);

            }
        }else{
//            // it's twoSum-2 problem now
//            int j=i+1;
//            int k = arr.length-1;
//            while(j<k){
//                if(arr[i] + arr[j] + arr[k] == 0){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(arr[i]);
//                    temp.add(arr[j]);
//                    temp.add(arr[k]);
//                    li.add(temp);
//                    // for two sum we are returning from here, hence no need to check for duplicates
//                    // but since we are storing elements we need to check for duplicates here
//                    j++;
//                    while(j<k && j>0&& arr[j] == arr[j-1]){
//                        j++;
//                    }
//                }
//                if(arr[i] + arr[j] + arr[k] > 0){
//                    k--;
//                }else{
//                    j++;
//                }
//            }
        }

    }


}
