package com.Dhiraj;

import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char ch = in.next().trim().charAt(0);
        // trim() method will remove all the spaces and charAt() method will take indexed character

        if (ch>'a' && ch<'z'){
            System.out.println("lower case");
        }else{
            System.out.println("upper case");
        }
        if(ch > 'a' || ch < 'z'){
            System.out.println("something case");
        }
    }
}
