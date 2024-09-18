package com.Dhiraj;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(fiboFormula(55));

    }
    static long fiboFormula(int n ){
//        long ans = (int)((Math.pow(((1 + Math.sqrt(5))/2), n)) - (Math.pow(((1 - Math.sqrt(5))/2), n)))/(Math.sqrt(5));
        // ignoring the less dominat terms
       long ans = (int)(Math.pow(((1 + Math.sqrt(5))/2), n));
       return ans;
    }

    static int fibo(int n){
        // base condition
        if(n < 2){
            return n;
        }
        return  fibo(n-1) + fibo(n-2);
    }
}



/*

time complexity is not machine dependent, time complexity is not time taken
time complexity : function that gives us the relationship about how the time will grow as the input grows

Procedures for analysis complexity
1. always look for worst case complexity
2. always look at complexity for large/ infinite data
3. y=x , y=2x, y=3x, ... time complexity is O(N)
Even though value of actual time is different they are growing linearly, We don't care about acutal time, This is why we ignore all constants
4. O(N^3 + log(N))    --> O(N^3)   Always ignore less donminating terms
O(3N^3 + 4N^2 + 5N + 6 )  --> O(N^3)
O(1)    < O(log(N))    < O(N)    < O(2^N)
y = k   y = log(x)     y = kx     y = 2^x

*/

/*
big-oh notation :
word defination --> upper bound --> our alogrithm with big-oh time complexity will never exceed than big-oh it can be less than big-oh
f(n) = O (g(n))   ( f(n) is big O of g(x) )
f <= g
lim n--> infin  f(n)/g(n)  < infn (any finite value)

big-omega :
min time to execute an algorithm
opposite of big-oh   --> lower bound
lim n--> infin   f(n)/g(n)   > 0
f >= g

Theta notation:
Combining both upper and lower bound :
 0 < lim n--> infin   f(n)/g(n)  < infin

little-o notation:
loose upper bound, strictly slower than g
 upper bound / lose upper
f(n) = o (g(n))  then  f < g
lim n--> infin  f(n)/g(n)   = 0
stronger statement

little-omega
lower lose bound
f > g
lim n--> infin   f(n)/g(n)  = inf

*/

/*

space complexity :
space complexity == input space + auxiliary space(extra space or temporary space taken by an algorithm)
in binary search space complexity was constant that means auxiliary space was constant it was not taking any extra space
// we always talk about auxiliary space
binary /linear search insertation/selection/bubble sorts space complexity is constant


Recursive Programme:
at any particular point of time no two function call at the same level of recurssion will be at the stack at the same time
first
Trick: only calls that are interlinked will be in the stack at the same time
space complexity of recurssive programme is maximum height(path) of the tree
for nth fibonacci number space complexity is O(N)

types of recursion :
linear : f(N) = f(n-1) + f(n-2)
divide and conquer : f(N) = f(N/2) + O(1)

1. divide and conquer:
T(x) = a1T(b1(x) + e1(x) ) + a2T(b2x + e2(x)) + ....akT(bk(x) + ek(x)) + g(x)
if a1 = 1, b1 = 1/2 and e(x) = 0 then T(x) = T(x/2) + c
what g(x)/g(u) represent, when you get answer from one half and other half of the array and you merger them to get the result
that merging also take some tim/ space that merging is what g(x) is

How to actually solve to get the complexity ?

with akra bazzi theorem
for merge sort T(x) is :
T(N) = 2T(N/2) + (N - 1)
here a = 2, b = 1/2
hence p : a1.(b1)^p = 1 hence p = 1

g(u) in the formula is g(x) in T(x) expression
when you unable to get the value of p
when p < power of g(x) then ans is i.e. time complexity is  O(g(x))
if p < power of g(x) then it comes in addition as nondominating term hence we can ignore it

2. linear recurrence relation:
homogenous linear recurrence no g(x) in this f(x)
a.) f(x) = a1f(x-1) + a2f(x-2) + a3f(x-3)...   + anf(x-n)
for ai, n is fixed and it's nth order of recurrence
solution for fibonacci number:
linear : f(N) = f(n-1) + f(n-2)
N --> t^n
t^n = t^(n-1) + t^(n-2)
solve the above equation
we have t^2 - t - 1 = 0 having rooots as (1 +- root(5))/2

if you have two roots t1 and t2 then:
b.) f(n) = c1(t1)^n + c2(t2)^n     is a solution for fibonacci series
     = f(n-1) + f(n-2)

if you have one root t1 then:
f(n) = c1(t1)^n

c.) fact : number of roots you have is equal to number of answers you have already
soving the above eqn(b) by n = 0  and  n =1
we have c1 = -c2  and c1= 1/root(5) putting this values in below eqn we have
f(n)  = c1((1 + root(5))/2)^n  + c2((1 - root(5))/2)^n

NOTE: formula for nth fibonacci number f(n)  : 1/root(5) * ((1 + root(5))/2)^n - 1/root(5) * ((1 - root(5))/2)^n

for larger n  c2((1 - root(5))/2)^n tends to zero hence time complexity is O((1 + root(5))/2)^n golden ratio
T(n) = O (0.6180)^n


// solve recurrence relation with equal roots
if t1, t2, t3, ... are equal = k then :
k^n, n(k)^n, n^2(k)^n, ... are all solution to the recurrence
if t1, t2 = 1 = k
the 1, n are solution to the recurrence
hence f(n) = c1(1)^n  +  c2(n)(1)^n  is the equation putting f(0) = 0 and f(1) = 1 we have c1 = 0 and c2 = n, hence the time complexity is O (N)

// non homogenous linear recurrence relation
when g(x) the extra function is there then the linear equation is non-homogenous recurrence relation
a.) f(x) = a1f(x-1) + a2f(x-2) + a3f(x-3)...   + anf(x-n) + g(x)

// how to guess a particular solution



*/



























