package com.Dhiraj;

import java.util.Arrays;

public class LeetCodeMedium {
    public static void main(String[] args) {
        int arr [] = {2,5,6,6, 6, 0,0,1,2};
//        System.out.println(Arrays.toString(firstLastPos(arr, 2)));
//        System.out.println(rotateSortedArr(arr, 4));

//        System.out.println(ceilingOfNumber(arr, 3));
        char arr2 [] = {'c','f','j'};
//        System.out.println(nextGreatestLetter(arr2, 'c'));
//        System.out.println(findPivotForRotateSortedArr(arr));

        int arr3 [] = {2, 1};
//        System.out.println(findMinInRotatedSortedArr(arr3));

        int arr4 [] = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr4));

        int arr5 [] = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr5));

        System.out.println("divide " +divide(2147483647, 1));

        int bloomDay [] = {7,7,7,7,12,7,7};
        System.out.println("min days "+minDays(bloomDay, 2, 3));


    }

    // array without duplicates value
    public static int findPivotForRotateSortedArr(int arr[]){
        int s = 0;
        int e = arr.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
           if(mid < e && arr[mid] > arr[mid+1]){
               return mid;
           }else if(mid > s && arr[mid-1] > arr[mid]){
               return mid-1;
           }else if(arr[mid] <= arr[s]){
               e = mid-1;
           }else{
               s = mid+1;
           }

        }
        return -1;
    }

    public static int findPivotWithDuplicateElements(int arr[]){
        int s = 0;
        int e = arr.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid < e && arr[mid] > arr[mid+1]){
                return mid;
            }else if(mid > s && arr[mid-1] > arr[mid]){
                return mid-1;

                // elementing the duplicates
            }else if(arr[mid] == arr[s] && arr[mid] == arr[e]){
                // check if start is pivot
                if(arr[s] > arr[s+1]){
                    return s;
                }
                s++;

                // check if end is pivot or not
                if(arr[e-1]> arr[e]){
                    return e-1;
                }
                e--;
            }
//            now satrt mid and end are not duplicates
            // condition that left part is sorted search for right part
            else if(arr[s] <arr[mid] || (arr[s] == arr[mid] && arr[mid]> arr[e])){
                s = mid+1;
            }else{
                e = mid-1;      // condition for right part is sorted search for left
            }

        }
        return -1;
    }


    public static int binarySearchOrderIgnostic (int [] arr, int s, int e, int target, boolean asc){
        int start = s;
        int end = e;
        while (start<=end){
            int m = start + (end-start)/2;
            if(arr[m] == target){
                return m;
            }
            if(asc){
                if(arr[m] < target){
                    start = m+1;
                }else{
                    end = m-1;
                }
            }else{
                 if(arr[m] < target){
                    end = m+1;
                }else{
                    start = m-1;
                }
            }
        }
        return -1;
    }

//    https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    public static int rotateSortedArr(int arr[], int target){
        int pivot = findPivotForRotateSortedArr(arr);
        if(pivot == -1){
            return binarySearchOrderIgnostic(arr, 0, arr.length-1, target, true);
        }
        int leftToPivot = binarySearchOrderIgnostic(arr, 0, pivot, target,true);

        if(leftToPivot == -1){
            return binarySearchOrderIgnostic(arr, pivot+1, arr.length-1, target,true);

        }else{
            return leftToPivot;
        }

    }

//    https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    public static int singleNonDuplicate(int arr []){
        int s = 0;
        int e = arr.length-1;
        int mid = 0;
        while (s<=e){
             mid = s + (e-s)/2;

             // found ans
             if(mid>s && arr[mid] != arr[mid-1] && mid<e && arr[mid] != arr[mid+1]){
                 return arr[mid];
             }

            // assuming 0th index as even
            if(mid%2 == 0){
                // then for part to be fair mid+1 must be equal to mid
                // implies left part is fair enought
                if(mid<e && arr[mid] == arr[mid+1]){
                    s = mid+1;
                }else {
                    e = mid-1;
                }
            }else{
                if(mid>0 && arr[mid] == arr[mid-1]){
                    s = mid+1;
                }else {
                    e = mid-1;
                }
            }
        }
        return arr[mid];
    }

    public static int binarySearch(int arr[], int s, int e, int target){
        int start = s;
        int end = e;
       while (start<=end){
           int m = start + (end-start)/2;
           if(arr[m] == target){
               return m;
           }else if(arr[m] < target){
                start = m+1;
           }else{
               end = m-1;
           }
       }
       return -1;
    }


    public static int searchLeft(int arr [], int s, int e, int target){
        // we know target is left
        int i = binarySearch(arr, s, e, target);
        if(i<0){
            return -1;
        }
        while(i-1 >= 0  && arr[i-1] == target ){
            int start = s;
            int end = i;
            i = binarySearch(arr, start, end, target);
        }
        return i;
    }
    public static int searchRight(int arr [], int s, int e, int target){
        // we know target is left
        int i = binarySearch(arr, s, e, target);
        if(i<0){
            return -1;
        }
        while( i>=0 && i+1<arr.length  && arr[i+1] == target ){
            int start = i+1;
            int end = e;
            i = binarySearch(arr, start, end, target);
        }
        return i;
    }

//    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int [] firstLastPos(int arr [], int target){
        // arr is sorted in non decreasing order
        int left = searchLeft(arr, 0, arr.length-1, target);
        int right = searchRight(arr, 0, arr.length-1, target);
        return new int [] {left, right};
    }


//    https://leetcode.com/problems/search-insert-position/description/
    public static int ceilingOfNumber(int arr[], int target){
        int s = 0;
        int e= arr.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                 e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
    }


//    https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    public static char nextGreatestLetter(char [] letters, char target){
        int s = 0;
        int e = letters.length-1;
        if(letters[letters.length-1] == target){
            return letters[0];
        }
        while(s<=e){
            int mid= s + (e-s)/2;
            if(letters[mid] <= target){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return letters[s];
    }

    public static int findMinInRotatedSortedArr(int [] arr){
        // find pivot if pivot is not the last element return pivot+1 th element else return 0th element
        int pivot = -1;
        int s = 0;
        int e = arr.length-1;
        while (s<=e){
            int m = s + (e-s)/2;
            if( m<e && arr[m] > arr[m+1] ){
                pivot = m;
                break;
            }else if(m>s && arr[m] < arr[m-1]){
                pivot = m-1;
                break;
            }
            else if(arr[m] <= arr[s]){
                e = m-1;
            }else{
                s = m+1;
            }
        }

        // pivot is last element
        if(pivot == -1){
            return arr[0];
        }else{
            return arr[pivot+1];
        }
    }


//    https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static int peakOfMountainArray (int arr []){
        int s = 0;
        int e = arr.length-1;
        while (s<e){
            int mid = s + (e-s)/2;

            // descending part
            if(arr[mid] > arr[mid+1]){
                e = mid;        // e != mid-1 coz mid can be a answer
            }else{
                s = mid+1;      // arr[mid] <= arr[mid+1]   s != mid coz mid+1 can be a answer
            }

        }
        return s;
    }

//    https://leetcode.com/problems/find-peak-element/description/
    public static int findPeakElement(int [] nums){
        int s =0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            // found peak element ---> element greater than it's neighbours
            if(mid > 0 && nums[mid] < nums[mid-1]){
                e = mid-1;
            }else if(mid+1< nums.length && nums[mid] < nums[mid+1]){
                s = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int divide(int dividend, int divisor ){
        int result = 0;
        if(dividend == 1<<31 && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ;    // + --> true

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

//        while (dividend -divisor >=0){
//            int count = 0;
//            while (dividend - divisor*Math.pow(2, count+1) >=0){
//               count ++;
//
//            }
//            result = result + (int)Math.pow(2, count);
//            dividend = dividend - (int)Math.pow(2, count)*divisor;
//        }
        while (dividend -divisor >=0){
            int count = 0;
            while (dividend - (divisor <<1<<count) >=0){
                count ++;

            }
            result += 1<<count;
            dividend -= divisor << count;
        }


        return sign ? result : -result;
    }

    public static int minDays(int [] bloomDay, int m, int k){

        // brute force
//        // m --> bouquets
//        // k --> flowers for each bouquets must be adjacent
//        // required flowers are greater than number of flowers in a garden
//        if(m*k > bloomDay.length){
//            return -1;
//        }
//        int minDays = Integer.MAX_VALUE;
//        for (int i = 0; i < bloomDay.length; i++) {
//            int count =0;
//            int bouq = m;
//            for (int j = 0; j < bloomDay.length; j++) {
//                if(bloomDay[i] >= bloomDay[j]){
//                    count++;
//                }else{
//                   count = 0;
//                }
//                if(count>=k){
//                    bouq --;
//                    count = 0;
//                }
//            }
//            System.out.println(bouq);
//
//            if (bouq <=0 && bloomDay[i] < minDays){
//                minDays = bloomDay[i];
//            }
//
//        }
//        return minDays;

        // binary search
        long cc = (long)m*k;
        if(cc > bloomDay.length){
            return -1;
        }
        int minDays = Integer.MAX_VALUE;
        int c [] = Arrays.copyOfRange(bloomDay, 0, bloomDay.length);
        Arrays.sort(c);
        int s=0;
        int e = c.length-1;
        while (s<=e){
            int mid = s + (e-s)/2;
            int count =0;
            int bouq = m;
            for (int j = 0; j < bloomDay.length; j++) {
                if(c[mid] >= bloomDay[j]){
                    count++;
                }else{
                    count = 0;
                }
                if(count>=k){
                    bouq --;
                    count = 0;
                }
            }
            System.out.println(c[mid]);
            if(bouq >0){
                s = mid+1;
            }else{
                e = mid-1;
            }
            if (bouq <=0 && c[mid] < minDays){
                minDays = c[mid];
            }
        }
        return minDays;
    }

    public static int findMaxIndex(int arr [], int s, int e){
        int maxIndex = s;
        for (int i = s; i < e; i++) {
            if (arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }


}
