package com.Dhiraj;

public class RotatedSortedArray {
    public static void main(String[] args) {
        //  given array [0,1,2,4,5,6,7] might be roatated at pivot index 3 and become [4,5,6,7,0,1,2] with all DISTINCT element
        // find the index of target element
        // 1. find pivot(from where your next nos are asc) in the array search in the first half (binary search) other wise search in the second half
        // case 1: when you find that mid > mid + 1 element i.e. pivot
        // case 2 : if mid element < mid-1 element i.e. also my ans = mid-1
        // case 3 start element > mid element ==> all element from mid will be smaller than start hence we can ignore all this elements since we are looking for peak i.e. largest element e = mid-1
        // case 4 start element < mid element  start = mid + 1 binary seach apply there
        int [] array = {4,5,6,7,0,1,2};
        int target = 7;
        int ans = search(array, target);
        System.out.println(ans);
    }

    static int search(int [] nums, int target){
        int pivot = findPivot(nums);
        // if you did not find a pivot, it means the arrya is not roatated
        if (pivot == -1){
            // just do normal binary search
            return BinarySerach(nums, target, 0, nums.length-1);
        }
        // 1 if pivot is found then, you have found 2 ascending sorted arrays
        if(nums[pivot] == target){
            return pivot;
        }
        // 2 target > start element. search space = (start, pivot -1) coz all number after pivot are smaller that start
        if (target >= nums[0]){
            return BinarySerach(nums, target, 0, pivot-1);
        }

        // 3 target < start element. i.e. we know that all elements from start, pivot are going to be greater than target. serach space is (pivot+1, till end)
        return BinarySerach(nums, target, pivot+1, nums.length-1);


    }

    static int BinarySerach(int [] array, int target, int start, int end){

        while (start <= end){
            int mid = start + (end - start)/2;

            if (target < array[mid]){
                end = mid -1;
            }else if(target > array[mid]){
                start = mid +1 ;
            }else {
                // ans found time colexity bigO of (1)    -----> constant
                return mid;
            }

        }
//        worst time complexity bigO of lg(arra.length), but much better than worst time complexity of linear search i.e array.length
        return -1;

    }

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

}
