package com.Dhiraj;

public class FindInMountainArray {
    public static void main(String[] args) {

        // given an element [1,2,3,4,5,3,1]   --> mountian array target = 3 find the target index LEAST one !
        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int ans = FindLeastIndex(arr, target);
        System.out.println(ans);


    }
    static int FindLeastIndex(int [] array, int target){
      int peak = maxElement(array);
      int firstTry = binarySearch(array, target, 0, peak);
      // try searching in ascending array i.e array of left of peak
      if (firstTry != -1){
          return firstTry;
      }
      // else try serach towards right of peak
        return OrderIgnoist(array, target, peak+1, array.length-1);
    }

    static int maxElement(int[] arr){
        int start = 0;
        int end = arr.length -1;
        int max = 0;

        while(start<end){
            int mid = start + (end - start)/2;
            // this is ascending part of the array coz we know that mid+1 element is > mid
            if (arr[mid] < arr[mid+1]){
                start = mid + 1;
            }else {
                // you are in descending part of the array
                // this may be the ans but look at the left
                // this is why end != mid -1
                end = mid;
            }

        }
        // in the end start == end coz of the two checks above
        // start and end are always try to find max element in above two checks
        // hence when they are pointing to just one element that is the max one
        // at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining hence cuz of the above line that is the best possible ans

        return start;

    }
    public static int peakIndexInMArr(int arr[]){

        int s=0;
        int e= arr.length-1;
        while (s<e){
            int mid = s + (e-s)/2;
            if(mid-1>=0 && mid+1<arr.length && arr[mid-1] <arr[mid] && arr[mid+1] < arr[mid]){
                return mid;
            }
            if(mid-1>=0 && mid+1<arr.length && arr[mid-1] <arr[mid] && arr[mid+1] > arr[mid]){
                s = mid;
            }else if(mid-1>=0 && mid+1<arr.length && arr[mid-1] >arr[mid] && arr[mid+1] < arr[mid]){
                e=mid;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    static int OrderIgnoist(int [] array, int target, int start, int end){

        // find whether the array is sorted ascending or descending order
        boolean asci = array[start]< array[end];

        while (start <= end){
            int mid = start + (end - start)/2;

            if (array[mid] == target){
                return mid;
            }
            if (asci) {
                if (target < array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }else{
                if (target > array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
//        worst time complexity bigO of lg(arra.length), but much better than worst time complexity of linear search i.e array.length
        return -1;

    }

}
