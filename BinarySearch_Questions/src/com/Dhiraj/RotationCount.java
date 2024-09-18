package com.Dhiraj;

public class RotationCount {
    public static void main(String[] args) {

        // given a rotated array find the number of times the array is rotated
        int [] arr = {4,5,6,7,0,1,2};


    }
    static int RoatationCount(int[] array){
        int pivot = findPivotWithDuplicates(array);
//        if(pivot == -1) {
//            // array is not sorted
//            return 0;
//        }

        return pivot + 1;       // same as if it is returning -1 then -1 + 1 resulatant return
    }
    // use this for non duplicates
    static int findPivot (int [] arr){
        int start = 0;
        int end = arr.length -1 ;
        while (start <= end){
            int mid = start + (end-start)/2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }if (mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }if (arr[mid] <= arr[start]){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    // use this for duplicates
    static int findPivotWithDuplicates(int [] arr){
        int start = 0;
        int end = arr.length -1 ;
        while (start <= end){
            int mid = start + (end-start)/2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }if (mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }
//            if (arr[mid] <= arr[start]){
//                end = mid -1;
//            }else{
//                start = mid+1;
//            }
            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){
                // skip the duplicates
                // Note what if these elements at start and end are pivot
                // check whether start is pivot or not
                if (arr[start] > arr[start+1]){
                    return start;
                }
                start ++;

                // check whetther end is pivot or not
                if (arr[end]  < arr[end-1]){
                    return end - 1;
                }
                end --;
            }else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}
