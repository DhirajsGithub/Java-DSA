package com.Dhiraj;

import java.util.ArrayList;

public class ArrayQue {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 0 };
        System.out.println(sortedOrNot(arr, 0));

        // int target = 6;
        // System.out.println(findIndex(arr, target, 0));
        //
        // // array list return
        //// ArrayList<Integer> ans = findAllIndex2(arr, 4, 0, new ArrayList<>());
        //// System.out.println(ans);
        // ArrayList<Integer> list2 = new ArrayList<>();
        // // same
        // ArrayList<Integer> ans = findAllIndex2(arr, 4, 0, list2);
        // System.out.println(ans);
        //
        //
        // // rotated binary serach
        // int[] arr4 = { 5, 6, 7, 8, 9, 1, 2, 3 };
        // case 1 if arr[s] <= arr[mid] --> subcases if (target>= arr[s] &&
        // target <= arr[mid]) else target is between mid+1 and end
        int[] arr4 = { 5, 6, 1, 2, 3, 4 }; // if arr[s] is not less than arr=mid
        // two cases again
        System.out.println(rotatedBS(arr4, 3, 0, arr4.length - 1));

        int[] arr2 = { 1, 2, 2, 3 };
        // System.out.println(findAllIndex3(arr2, 2 ,0));

    }

    static int rotatedBS(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[s] <= arr[mid]) {
            if (target >= arr[s] && target <= arr[mid]) {
                return rotatedBS(arr, target, s, mid - 1);
            } else {
                return rotatedBS(arr, target, mid + 1, e);
            }
        }
        if (target >= arr[mid] && target <= arr[e]) {
            return rotatedBS(arr, target, mid + 1, e);
        }
        return rotatedBS(arr, target, s, mid - 1);

    }

    static boolean sortedOrNot(int[] arr, int index) {
        // base condition
        if (index == arr.length - 1) {
            return true;
        }
        // in ascending order

        return arr[index] < arr[index + 1] && sortedOrNot(arr, index + 1);
        // think like when index reaches at base condition it returns true then it will
        // check as arr[arr.length-2] < arr[arr.length-1]
        // if both condition are ture the result is true
    }

    // linear search
    static boolean find(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        // if any of the condition is true it will return true
        return arr[index] == target || find(arr, target, index + 1);
    }

    static int findIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1; // it never will execute if we found the target coz target index will always
                       // less that arr.length
        }
        if (arr[index] == target) {
            return index;
        } else {
            return findIndex(arr, target, index + 1); // findIndex() will have a value which is either index or -1 which
                                                      // will be pass on
        }
        // if any of the condition is true it will return true
    }

    static int lastIndexTar(int[] arr, int target, int last) {
        if (last == -1) {
            return -1;
        }
        if (arr[last] == target) {
            return last;
        } else {
            return lastIndexTar(arr, target, last - 1);
        }
    }

    // if duplicates are present then store to array list
    static ArrayList<Integer> list = new ArrayList<>();

    static void findAllIndex(int[] arr2, int target, int index) {
        if (index == arr2.length) {
            return;
        }
        if (arr2[index] == target) {
            list.add(index);
        }
        findAllIndex(arr2, target, index + 1);
    }

    // returning an array list
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        // NOTE: same differnce reference vairble in each recursion call i.e. list is
        // refernce varibale pointig towards same object hence changes from any
        // reference variable will affect the original object
        return findAllIndex2(arr, target, index + 1, list);
        // all recursive call are pointing to the same object hence the original object
        // will get updated with every recursive call
        // when tha base condition hits i.e. index == arr.length it will have value of
        // arr.length then findAllIndex2(arr, target, index+1, list) will carry list
        // value when stack will be getting empty
    }

    // returning an array list wihout taking it to parameter instead take it to the
    // body
    static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowClass = findAllIndex3(arr, target, index + 1);
        list.addAll(ansFromBelowClass); // list.addAll extends the Array list
        return list;
    }

    // rotated binary search
    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[m] >= arr[s]) {
            // start binary search to the left part
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m - 1);
            } else {
                return search(arr, target, m + 1, e);
            }
        }
        // assumming arr[m] <= arr[e]
        if (target >= arr[m] && target <= arr[e]) {
            // start seraching to the right part
            return search(arr, target, m + 1, e);
        }
        return search(arr, target, s, m - 1);
    }
}
