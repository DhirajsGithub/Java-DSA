package com.Dhiraj;

public class Main {

    public static void main(String[] args) {
	// write your code here
        char a = 'a';
        char b = 'b';

        int [] nums = {1,1,2,3,3,4,4,8,8};

//        for(int i=0; i<nums.length; i++){
//            int start = 0;
//            int end = nums.length-1;
//            int count = 0;
//            while(start <=end){
//                int mid = start + (end - start)/2;
//                if(nums[i] < nums[mid]){
//                    end = mid-1;
//                }else if(nums[i] > nums[mid]){
//                    start = mid+1;
//                }else {
//                    count ++;
//                    // nums[mid] == nums[i];
//                    if(mid == 0 && nums[mid] != nums[mid+1] ){
//                        System.out.println(nums[mid]);
//                        System.out.println("first"+" "+ mid);
//                        count ++;
//                        break;
//                    }else if(mid == nums.length-1 && nums[mid] != nums[mid-1]){
//                        System.out.println(nums[mid]);
//                        System.out.println("second"+" "+ mid);
//                        break;
//                    }else if(nums[mid] != nums[mid-1] || nums[mid] != nums[mid+1]){
//                        System.out.println(nums[mid]);
//                        System.out.println("third"+" "+ mid);
//                        break;
//                    }else{
//                        break;
//                    }
//
//                }
//            }
//        }
//        int m = Integer.MAX_VALUE +1;       // -2147483648
        int m = Integer.MAX_VALUE +3483294;      // -2144000355
        System.out.println(m);

        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        System.out.println(nums[left]);
    }
}
