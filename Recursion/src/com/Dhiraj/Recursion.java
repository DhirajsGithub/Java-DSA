package com.Dhiraj;

import static java.util.Arrays.binarySearch;

public class Recursion {
    // What is recursion --> Function calling itself
    public static void main(String[] args) {

        print(1);

        // Q. find nth fibonacci number
        // break it down into smaller problems, the base condition is represented by ans we already have
        // 1. find recurrence relation
        // 2. try to figure out recursive tree
        // fibo(N)  == fib (n-1) + fibo(n-2)
        int ans = fibo(6);
        int ans3 = fibo(50);  // wan't give ans as the recurssion tree wil grow exponentially  // comlexity is 1.681^n
        System.out.println(ans);

        // Binary Search using recursion
        int [] arr = {1,3,9, 18, 20, 34, 38, 79, 99, 100, 101};
        int target = 79;
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    static int binarySearch(int[] arr, int target, int s, int e) {
        if(s > e){
            return -1;
        }
        int m = s + (e-s)/2;
        if (arr[m] == target){
            return m;
        }
        if (target < arr[m]){
            return binarySearch(arr, target, s, m-1);
        }else{
            return binarySearch(arr, target, m+1, e);
        }
    }

    static int fibo(int i) {
        if(i< 2){
            return i;
        }
        // this is not a tail recursion as the extra addition is coming into picture
        return fibo(i-1) + fibo(i-2);
        // first of all all the fibo(i-1) will execute and then fibo(i-2) will execute
    }

    static void print(int n) {
        // it's a BASE CONDITION
        // condition where our funciton will stop making new calls
        // no base condition --> function call will keep happening, every call of the function will take some memory and stack will until it overflows and hence the error
        if (n == 5){
            System.out.println(n);
            return;       // ---> jump out of the stack now
        }
        System.out.println(n);
        // recursive call
        // if you are calling a function again and again you can treat it as a seperate call in the stack


        print(n + 1);

        // TAIL of recursive funtion --> the last function to be added in the stack
    }


}


// Why recusrion :
//1. it helps us in solving bigger/ complex problems easily
//2. you can convert recursion solution into iteration and vice versa
//3. space complexity is not constant because of recursive calls
// visualisation recursion --> recursive trees
// and stacks memory


// How to understand and approach recursion problems
// 1. Identify if you can break the problem into smaller problems
// 2. write the recurrence relation if needed. fibo(n) = fibo(n-1) + fibo(n-2)
// 3. draw the recursive tree
// 4. about the tree:
// a). see the flow of function, how they are gettin into stack
// b). identify and flow on left tree calls and right tree calls
// c). draw the tree and pointer again and again using pen and paper
// d). use the debugger to see the flow
// 5. see how the values and what types of values (int, string, etc) are returned at each step
// see where the fuction call will come out. in the end you will come out of the main function
// when you write the recursion into a formula is called a recursion relation


// very imp points:
// Variables in :  argument, return type, body of function

// types of recursion:
// 1. linear recursion relation --> fibo
// if we see the tree most of the values get repeated so that type of recursion is very poor
// 2. divide and conquer recurence relation (reduced by a factor)  --> Binary search


// 3. very imp : whatever variables you need to pass in future  function calls put inside the argument
// 4. what are the vairbles that only needed for that specific function call, that you don't need to pass in future recursion calls put them inside the bodey of the function
// 5. whenever you are calling a recursion call make sure you are returning it if there is a returning call
// 6. make sure you are returning type what are sub recursion calls are giving us

























