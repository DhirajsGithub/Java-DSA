package com.Dhiraj;

import java.util.Arrays;

/*
can be used in between two indices problems
sum, greatest, avg.... between two indices
 */
public class SQRTdecomposition {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;
        int sqrt = (int)Math.sqrt(n);

        // build a blocks array
        int blocks_id = -1;
        int block[] = new int[sqrt + 1];

        for (int i = 0; i < n; i++) {
            // new block
            if(i%sqrt == 0){
                blocks_id++;
            }
            block[blocks_id] += arr[i];
        }

        System.out.println("Block " + Arrays.toString(block));
        System.out.println("Ans is " + query(block, arr, 2, 7, sqrt));

    }

    public static int query(int [] blocks, int [] arr, int l, int r, int sqrt){
        int ans = 0;

        // left part
        while (l%sqrt != 0 && l<r && l!= 0){
            ans+= arr[l];
            l++;
        }

        // middle part
        while (l + sqrt <= r){
            ans+= blocks[l/sqrt];
            l += sqrt;
        }

        // right part
        while(l<=r){
            ans+= arr[l];
            l++;
        }

        return ans;
    }

    public void update(int [] blocks, int [] arr, int i, int val, int sqrt){
        int block_id = i/sqrt;
        blocks[block_id] += (val-arr[i]);
        arr[i] = val;
    }


}
