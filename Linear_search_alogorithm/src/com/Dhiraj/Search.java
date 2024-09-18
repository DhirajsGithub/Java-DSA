package com.Dhiraj;

public class Search {
    public static void main(String[] args) {

        int [] arr = {2,45,657,9,9};
        int t = 45;
//        int ans = linearSearch(arr, t);
//        System.out.println(ans);

//        int ans = linearSearch2(arr, t);
//        System.out.println(ans);

        boolean ans = linearSearch3(arr, t);
//        System.out.println(ans);

    }

//    static int linearSearch(int [] array, int target){
//
//        if (array.length < -1){
//            return -1;
//        }
//
//        for (int i=0; i<= array.length; i++){
//            // check for element at every index if is = target
//            if (array[i] == target){
//                return i;
//            }
//        }
//        // this line will execute if none of the above return statement executed
//        // hence the target is not found
//        return -1;
//    }

//    static int linearSearch2(int [] array, int target){
//
//        if (array.length < -1){
//            return -1;
//        }
//
//        for (int element : array){
//            // check for element at every index if is = target
//            if (element == target){
//                return element;
//            }
//        }
//        // this line will execute if none of the above return statement executed
//        // hence the target is not found
//        return -1;
//    }

    static boolean linearSearch3(int [] array, int target){

        if (array.length < -1){
            return false;
        }

        for (int i=0; i<= array.length; i++){
            // check for element at every index if is = target
            if (array[i] == target){
                return true;
            }
        }
        // this line will execute if none of the above return statement executed
        // hence the target is not found
        return false;
    }
}
