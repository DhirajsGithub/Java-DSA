package com.Dhiraj.OOP6.Comparison;

public class Student implements Comparable<Student> {
    // Compare Students
    int rollNo;
    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // compare with marks
    // compare to must be in this class for Students array to be sort as Arrays.sort(arr)
    @Override
    public int compareTo(Student o) {
         // here we will provide what to compare with
        int diff = (int)(this.marks - o.marks) ;     // since (this.marks - o.marks) is type float
        return diff;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }
}
