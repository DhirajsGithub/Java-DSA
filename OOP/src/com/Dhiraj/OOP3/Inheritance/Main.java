package com.Dhiraj.OOP3.Inheritance;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(2.3, 4, 9.5);
//        System.out.println(box.l+ " " + box.b + " "+ box.h);
        // can't access l as it is set to private
        System.out.println( box.b + " "+ box.h);

        Box box2 = new Box(box);
//        System.out.println(box2.l+ " "+ box2.b+ " "+ box2.h);
        System.out.println( box2.b+ " "+ box2.h);


        // inheritance boxes
        BoxWeight box3 = new BoxWeight();
        System.out.println(box3.weight);
        BoxWeight box4 = new BoxWeight(2, 3, 4, 78);
//        System.out.println(box4.l);        // we can initialised l but can't use it as it is private
        System.out.println(box4.b+" "+ box4.h+ " "+ box4.weight);


        // refernce is parent(Box) and type is object child(BoxWeight)
        Box box5 = new BoxWeight(3, 2, 5, 89);
//        System.out.println(box5.weight);
        System.out.println(box5.b);
        // NOTE: it is the type of the reference variable and not the object that determines what memebers can be accessd
        // box5 is in stack and BoxWeight is in heap


        // reference variable is child(BoxWeight) and type is parent (Box)
        // there are many variables in both parent and child
        // you are given an access to variables that are in ref type i.e. BoxWeight
        // hence you should access to weight variable
        // this also means, that the ones you are trying to access should be initialized
        // but here, when the obj itself is type of parent class then how you will call the constructor of child class
//        BoxWeight box6 = new Box(3, 25, 5, 54);
//        System.out.println(box6.weight);

        // showing example if static method can be overriden or not
        Box box7 = new BoxWeight();
        box7.greeting();          // Iam in Box, greetings from Box
        Box.greeting();             // Iam in Box, greetings from Box
        BoxWeight.greeting();      // Iam In BoxWeight class Greetings from BoxWeight
        // overriding depends on object static does not depend on object hence static method cannot be overriden
        // you can inherit but you cannot override


    }
}


/*

To inherit a class, you simply incorporate the definition of one class into another by using the extends keyword.

You can only specify one superclass for any subclass that you create. Java does not support the inheritance of
multiple superclasses into a single subclass. You can, as stated, create a hierarchy of inheritance in which a subclass
becomes a superclass of another subclass. However, no class can be a superclass of itself.

Although a SUBCLASS includes all of the members of its superclass, it CANNOT ACCESS those members of the superclass
that have been declared as PRIVATE.

A Superclass Variable Can Reference a Subclass Object:
It is important to understand that it is the type of the reference variable—not the type of the object that it refers
to—that determines what members can be accessed.
When a reference to a subclass object is assigned to a superclass reference variable, you will have access only to
those parts of the object defined by the superclass.

Using super:
Whenever a subclass needs to refer to its immediate superclass, it can do so by use of the keyword super.
SUPER has TWO general FORMS. The first calls the superclass’ constructor.
The second is used to access a member of the superclass that has been hidden by a member of a subclass.

Thus, super( ) always refers to the superclass immediately above the calling class.
This is true even in a multileveled hierarchy.

Notice that super() is passed an object of type BoxWeight—not of type Box.This still invokes the constructor Box(Box ob).
NOTE: A superclass variable can be used to reference any object derived from that class.
Thus, we are able to pass a BoxWeight object to the Box constructor.Of course,Box only has knowledge of its own members.

A Second Use for super
The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in
which it is used.

Here, member can be either a method or an instance variable. This second form of super is most applicable to situations
in which member names of a subclass hide members by the same name in the superclass.

super( ) always refers to the constructor in the closest superclass. The super( ) in BoxPrice calls the constructor in
BoxWeight. The super( ) in BoxWeight calls the constructor in Box. In a class hierarchy, if a superclass constructor
requires parameters, then all subclasses must pass those parameters “up the line.” This is true whether or not a
subclass needs parameters of its own.

If you think about it, it makes sense that constructors complete their execution in order of derivation.
Because a superclass has no knowledge of any subclass, any initialization it needs to perform is separate from and
possibly prerequisite to any initialization performed by the subclass. Therefore, it must complete its execution first.

NOTE: If super( ) is not used in subclass' constructor, then the default or parameterless constructor of each superclass
will be executed.

Types of inheritance

Single inheritance

Multiple inheritance     --> one class is extending more than one classes, not allowed in java(coz if two or more parent classes has same property
then child class will get confused which one to take), hence we have interfaces in java

Hierarchial inheritance   --> One class is inheritate by many classes like Box class is inheritae by BoxWeight and BoxPrice class

Hybrid inheritance   --> combination of single and multiple inheritance, we don't have in java


 */





















