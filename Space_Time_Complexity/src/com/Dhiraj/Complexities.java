package com.Dhiraj;

public class Complexities {
    public static void main(String[] args) {

    }
}

/*

How to measure Recursive Algorithm?

sampleArray
public int findMaxNumRec(int [] sampleArray, int n){                    --- > M(n)
    if (n == 1) {                                                    --- > O(1)
   return sampleArray[0];
   }
    return max(sampleArray[n-1],findMaxNumRec(sampleArray, n-1));       --------> M(n-1)
}
  M(n)=O(1)+M(n-1)
  M(1)=O(1)
M(n-1)=O(1)+M((n-1)-1)
 M(n-2)=O(1)+M((n-2)-1)
M(n)=1+M(n-1) =1+(1+M((n-1)-1))
=2+M(n-2) =2+1+M((n-2)-1) =3+M(n-3)
.
. =a+M(n-a)
=n-1+M(n-(n-1)) =n-1+1
=n

 */