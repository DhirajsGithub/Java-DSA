package com.Dhiraj;

public class RSADuplicateValues {
    public static void main(String[] args) {

        int [] array = {4,5,6,7,0,1,2};
        int target = 7;
        int ans = search(array, target);
        System.out.println(ans);

    }
    static int search(int [] nums, int target){
        int pivot = findPivotWithDuplicates(nums);
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
