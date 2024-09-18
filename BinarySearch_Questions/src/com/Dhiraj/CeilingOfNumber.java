package com.Dhiraj;

public class CeilingOfNumber {
    public static void main(String[] args) {

        int[] array = { 2, 3, 5, 9, 14, 16, 18 };
        int target = 14;
        int ans = ceilingNumber(array, target);
        System.out.println(ans);

    }

    // ceiling of a number is the number smallest number that is greater or equal to
    // the target element
    static int ceilingNumber(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        // int mid = 0;

        boolean asci = arr[start] < arr[arr.length - 1];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return arr[mid];
            }
            if (asci) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        // try to visualise it, everytime start is updating to mid +1 for ascending
        // sorted array so take case of 14-16 remaining then in that case start is index
        // 4 and end is index 5 and hence mid is index 4 from formula
        // hence if target == mid then it will return tarkget but if target!= mid then
        // start get updated as 4+1 and that's the required index for target == 15
        return arr[start];
    }

    // floor of a number is the gretest number smaller of equal to the target number
    static int floorNumber(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        // int mid = 0;

        boolean asci = arr[start] < arr[arr.length - 1];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return arr[mid];
            }
            if (asci) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return arr[end];
    }

}
