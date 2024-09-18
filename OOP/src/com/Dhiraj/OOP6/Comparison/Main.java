package com.Dhiraj.OOP6.Comparison;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student stu1 = new Student(12, 88.9f);
        Student stu2 = new Student(14, 68.8f);
        Student stu3 = new Student(14, 99.8f);
        Student stu4 = new Student(14, 8.8f);

        Student [] list = {stu1, stu2, stu3, stu4};
        System.out.println(Arrays.toString(list));

//        Arrays.sort(list);            // since compareTo is overridden and is comparing w.r.t. marks in Student class
//        Arrays.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int)(o1.marks-o2.marks);
//            }
//        });
        Arrays.sort(list, (o1, o2) -> (int)(o1.marks-o2.marks));        // lambda function
        System.out.println(Arrays.toString(list));

//        if(stu1 < stu2){
//            System.out.println("stu2 has more marks");
//        }
        // from above comparison java got confuse which type to compare rollNo or marks
        // hence we implement Comparable interface

        System.out.println(stu1.compareTo(stu2));
        if(stu1.compareTo(stu2) < 0){
            System.out.println("stu2 has more marks");
        }else{
            System.out.println("stu1 has more marks");
        }


    }
}
