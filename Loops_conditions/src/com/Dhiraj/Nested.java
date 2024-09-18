package com.Dhiraj;

import java.util.Scanner;

public class Nested {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();

        // NOTE:
//        String a = "Kunal";
//        String b = "Kunal";
//        System.out.println(a == b);          // true // will check the value as well the pointing of refernce vairble towards the object i.e. both variable have same address for object or not
//        System.out.println(a.equals(b));    // true  // will only check if the value of a is equals to b or not // for char and string only

//        if (fruit.equals("mango")){
//            System.out.println("King of fruits");
//        }
//        if (fruit.equals("apple")){
//            System.out.println("Sweet fruit");
//        }
////        and so onn...

        // switch statement
        switch(fruit){
            case "mango":
                System.out.println("King of the fruits");
                System.out.print("fksdj");
                break;
            case "apple":
                System.out.println("sweet fruit");
                break;
            case "orange":
                System.out.println("Rount fruit");
                break;
            case "grapes":
                System.out.println("small fruit");    // if case is "grapes" and there is no break hence default will also execute
            default:
                System.out.println("invalid fruit");
        }

        // when you used break for each case/ or just the last case then you can make switch statemen more elegant by option+return in mac to enhance the switch statment

//        switch (fruit) {
//            case "mango" -> System.out.println("King of the fruits");
//            case "apple" -> System.out.println("sweet fruit");
//            case "orange" -> System.out.println("Rount fruit");
//            case "grapes" -> System.out.println("small fruit");
//            default -> System.out.println("invalid fruit");
//        }

// if break is not there then from that case to the next break it will execute
// if default is used in b/w cases then below cases won't execute once the default execute

        // dislplay day name b/w 1 and 7
        int day = in.nextInt();
//        switch(day){
//            case 1 -> System.out.println("monday");
//            case 2 -> {
//                System.out.println("tuesday");             // if wanna add multiple commands for that day
//            }
//            case 3 -> System.out.println("wednesday");
//            case 4 -> System.out.println("thursday");
//            case 5 -> System.out.println("friday");
//            case 6 -> System.out.println("saturday");
//            case 7 -> System.out.println("sunday");
//
//        }

        // weekdays and weekands with break ka funda

//        switch (day) {
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("Weekdays");
//                break;
//            case 6:
//            case 7:
//                System.out.println("Weekands");
//                break;
//        }

        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("Weekdays");
            case 6, 7 -> System.out.println("Weekands");
        }


        // nested switch statement
        int empID = in.nextInt();
        String empDep = in.next();


//        switch (empID){
//            case 1:
//                System.out.println("Kunal");
//                break;
//            case 2:
//                System.out.println("Rahul");
//                break;
//            case 3:
//                System.out.println("employee 3");
//                switch (empDep){
//                    case "IT":
//                        System.out.println("IT department");
//                        break;
//                    case "teacher":
//                        System.out.println("Teaching");
//                        break;
//                    case "management":
//                        System.out.println("Management department");
//                        break;
//                    default:
//                        System.out.println("No department enter");
//                }
//                break;
//            default:
//                System.out.println("invalid ID");
//        }
        // better way to write
        switch (empID) {
            case 1 -> System.out.println("Kunal");
            case 2 -> System.out.println("Rahul");
            case 3 -> {
                System.out.println("employee 3");
                switch (empDep) {
                    case "IT" -> System.out.println("IT department");
                    case "teacher" -> System.out.println("Teaching");
                    case "management" -> System.out.println("Management department");
                    default -> System.out.println("No department enter");
                }
            }
            default -> System.out.println("invalid ID");
        }

    }
}

/*
In switch statement you can jump to various cases based on your expression
syntax;
switch(expression){
// cases
case one:
// do something
break;
case two :
// do something
// break;
default:
// do something
}
 */

/*
NOTE:
- cases have to be the same type as expressions, must be a constant or literal
- duplicate case values are not allowed
- break is use to terminate the sequence
- This will stop the execution of more code and case testing inside the block.
- When a match is found, and the job is done, it's time for a break. There is no need for more testing.
- if break is not used, it will continue to next case
- default will execute when one of the above does not executed
- if default is not at the end, put break after it
 */