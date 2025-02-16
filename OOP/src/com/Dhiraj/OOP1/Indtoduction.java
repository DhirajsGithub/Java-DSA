package com.Dhiraj.OOP1;

import java.util.Arrays;

public class Indtoduction {
    public static void main(String[] args) {
        // create a data type which stores each student rNo, name, marks
        // for that we need to create our own data type for each student it will be applicable then we will store this student data type in an array whose data type will be agin student
        int myNums [] = new int [5];           // rNo is an instance of class int
        System.out.println(Arrays.toString(myNums));   // by default primitves data type will be 0(for int/long) 0.0 for (float/double) false(for boolean)    (for char)
        Students kunal [] = new Students[5];    // kunal is an instance of class Students

        // dynamic memory allocation
//        Students kunal []  happens at compile time        // declaration
//        new Students[5]    happens at run time            // initialization
//        System.out.println(Arrays.toString(kunal));    // by default object are store as a null in the memory if not initialize

        // just declaring
//        Students ayush;
//         ayush = new Students();
        Students ayush = new Students();       // before craeting constructor function
        System.out.println(ayush.marks);       // default is set to 85.4
        System.out.println(ayush.name);         // default is set to null
        System.out.println(ayush.rNo);          // default is set to 0

        ayush.rNo = 8;
        ayush.marks = 99.3f;
        ayush.name = "ayush";
        // the above initalizion for instance variable will be repetatitive for each object/student
        // to avoid this we have constructor as like we have hulk from avengers :)


        System.out.println(ayush.marks);
        System.out.println(ayush.name);
        System.out.println(ayush.rNo);

        // constructor overloading
        Students saksham = new Students();
        Students shivesh = new Students(32, "Shivesh", 99.99f);

        System.out.println(saksham.name);
        System.out.println(saksham.rNo);
        System.out.println(shivesh.name);
        System.out.println(shivesh.rNo);
        saksham.changeName("Saksham");
        System.out.println(saksham.name);

        // passing an object inside costructor of an object
        Students Aaryan = new Students(shivesh, "Aaryan");
        System.out.println(Aaryan.name);
        System.out.println(Aaryan.rNo);       // same as shivesh
        System.out.println(Aaryan.marks);     // same as shivesh


        // calling a constructor from another constructor example
        Students randomStudent = new Students();
        System.out.println(randomStudent.name);
        System.out.println(randomStudent.marks);

        // memory allocation of new keyword
        Students one = new Students();
        Students two = one;
        // one and two are being store in stack pointing towards same object in the heap memory, hence any change in two will leads to change in one and vice versa
        one.name = "Somthing Something";
        System.out.println(two.name);

    }
}

//// create a class // class without constructor
////for every single student
//class Students {
//    int rNo;
//    String name;
//    float marks = 85.4f;
//}

class Students {
    int rNo;
    String name;
    float marks = 85.4f;

//    // I want ayush which is instance of class Students to have predefined instance variable
//    // since we are no limited to ayush hence we can't use direstly instance of a class we will be using 'this' keyword
//    Students(){
//        ayush.rNo = 8;
//        ayush.marks = 99.3f;
//        ayush.name = "ayush";
//    }

    // we need a way to add the values of the above properties objects by objects
    void greeting (){
        System.out.println("Greeting to "+ this.name);
    }
    void changeName (String newName){
        this.name = newName;
    }

//    // constructor without parameters
//    Students(){
//        this.rNo = 8;
//        this.marks = 99.2f;
//        this.name = "Kunal Kushwaha";
//    }

    // constructor with parameters
    // Student arpit = new Student(45, "arpit", 84.8f);
    // here this will be replace by arpit
    Students(int rollNo, String name, float marks){
        this.name = name;
        this.marks = marks;
        rNo = rollNo;
        // if parameters name and instance variable name is different we can point instance variable to that parameter directly without using 'this' keyword
        // but it's best practise to use 'this' keyword in any condition
    }

    // create a method which takes properties of other objects
    Students (Students other, String newName){
//        this.name = other.name;
        this.rNo = other.rNo;
        this.marks = other.marks;
        this.name = newName;
    }

    // calling a constructor from another constructor
    // for deafault values we can use this
    Students (){
        // internally :new Students(13, "Defautl Person", 100.0f);
        this(13, "Defautl Person", 100.0f);
    }

}

/*
A class is a name group of properties and functions
A class is a template for an object, and an object is an instance of a class.
A class creates a new data type that can be used to create objects.

When you declare an object of a class, you are creating an instance of that class.
Thus, a class is a logical construct. An object has physical reality. (That is, an object occupies space in memory.)

Objects are characterized by three essential properties: STATE, IDENTITY, and BEHAVIOUR.
The state of an object is a value from its data type. The identity of an object distinguishes one object from another.
It is useful to think of an object’s identity as the place where its value is stored in memory.
The behavior of an object is the effect of data-type operations.

The dot operator links the name of the object with the name of an instance variable (roll no, name, marks).     reference variable (student1)
Although commonly referred to as the dot operator, the formal specification for Java categorizes the . as a separator.
The 'new' keyword dynamically allocates(that is, allocates at run time)memory for an object & returns a reference to it.
This reference is, more or less, the address in memory of the object allocated by new.
This reference is then stored in the variable.
Thus, in Java, all class objects must be dynamically allocated.

Box mybox; // declare reference to object
     mybox = new Box(); // allocate a Box object
The first line declares mybox as a reference to an object of type Box. At this point, mybox does not yet refer to an
actual object. The next line allocates an object and assigns a reference to it to mybox. After the second line executes,
you can use mybox as if it were a Box object. But in reality, mybox simply holds, in essence, the memory address of the
actual Box object.
The key to Java’s safety is that you cannot manipulate references as you can actual pointers.
Thus, you cannot cause an object reference to point to an arbitrary memory location or manipulate it like an integer.

You might be wondering why you do not need to use new for such things as integers or characters.
The answer is that Java’s primitive types are not implemented as objects.
Rather, they are implemented as “normal” variables, hence they are store in stacks    int a = 10;  10 being objet store in heap but not in case of java
This is done in the interest of efficiency.

It is important to understand that "new" allocates memory for an object during RUN TIME.

Box b1 = new Box();
Box b2 = b1;
b1 and b2 will both refer to the same object. The assignment of b1 to b2 did not allocate any memory or copy any part
of the original object. It simply makes b2 refer to the same object as does b1. Thus, any changes made to the object
through b2 will affect the object to which b1 is referring, since they are the same object.
When you assign one object reference variable to another object reference variable, you are not creating a copy of the
object, you are only making a copy of the reference.

ONE REFERENCE VARIABLE CAN ONLY REFER TO ONE OBJECT AT A TIME    --> linked list

// Constructor of a class
The class name followed by parentheses specifies the constructor for the class. A constructor defines
what occurs when an object of a class is created.

The this Keyword:
Sometimes a method will need to refer to the object that invoked it. To allow this, Java defines the this keyword.
this can be used inside any method to refer to the current object. That is, this is always a reference to the object on
which the method was invoked.



 */