package com.Dhiraj;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        // for binary search we know that sorted array if required what if don't kow wheteher it is sorted ascending or descending
        // for that we make comparison of first and end element while condition is true, why not first and second coz there might be a chance that both consecutive elements are same!
        int [] arr = {-40,-33,-22, -15, -9, -8, -7, -3, 0, 1,2,3,4,5,6,7,8,9,44, 545, 3522, 3058903,3058905};
        int target = 545;
        System.out.println(arr.length);
        int ans = BinarySerach(arr, target);
        System.out.println(ans);


    }




    static int BinarySerach(int [] array, int target){
        int start = 0;
        int end = array.length-1;

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


