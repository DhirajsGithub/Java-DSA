package com.Dhiraj;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        // [1,3,5,2,1]     ---> biotonic/mountain array first increases up to maximum then decreasess
        // find the peak index in mountain array and the given array does not contain duplicate numbers
        int [] array = {1, 3, 18, 9, 8, 7, 6, 5, 4};
        System.out.println("something");
        int ans = maxElement(array);

        System.out.println(ans);
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

        return arr[start];
        // can't access mid coz it is not in scope at this time start and end poiniting towards same  element hence return that

    }
}
