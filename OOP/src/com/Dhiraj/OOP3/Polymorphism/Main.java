package com.Dhiraj.OOP3.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes obj = new Shapes();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

       circle.area();
       obj.area();
       triangle.area();

       Shapes circle2 = new Circle();
       Shapes triangle2  = new Triangle();
       circle2.area();            // Area From Circle
        triangle2.area();         // Area From Triangle
        // why is that, we learnt till this point that what variable we want to acces that depend on LHS or ref variable but it showing object variable/ methods
        // NOTE : What is being access does not depend on Object it is depend on reference type
        // which one it's able to access depends on object


    }

}

/*

Poly --> Many
Morphism --> Ways to represent

Types of Polymorphism :
1.) Compile Time / Static Polymorphism
Achieve via method overloading
Same name but types, arguments, return types, ordering can be different
e.g. multiple constructors

2.)Runtime / Dynamic polymorphism
achieved via method overriding
How Overriding works
Parent obj = new Child();
Here, which method to call depends on Child, but the method must be Present in Parent as well to Override it
This is Known as Upcasting

How Java Determines this ?
Dynamic method dispatch
Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than
compile time. Dynamic method dispatch is important because this is how Java implements run-time polymorphism.
It is just a mechanism by which a call to overridden method is resolve at runtime rather than compile time


overriding :
In a class hierarchy, when a method in a subclass has the same name and type signature as a method in its superclass,
then the method in the subclass is said to override the method in the superclass. When an overridden method is called
from within its subclass, it will always refer to the version of that method defined by the subclass. The version of the
method defined by the superclass will be hidden.
Method overriding occurs only when the names and the type signatures of the two methods are identical.
If they are not, then the two methods are simply overloaded.

Let’s begin by restating an important principle: a superclass reference variable can refer to a subclass object.
When an overridden method is called through a superclass reference, Java determines which version of that method to
execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is
made at run time.
In other words, it is the type of the object being referred to (not the type of the reference variable)
that determines which version of an overridden method will be executed.
If B extends A then you can override a method in A through B with changing the return type of method to B.

You cannot override the method that is final
performance inhancement --> compiler is free to inline the calls to constructor with final keyword
Early Binding: The binding which can be resolved at compile time by the compiler is known as static or early binding. (using final keyword or..)
Binding of all the static, private and final methods is done at compile-time.
Late binding: In the late binding or dynamic binding, the compiler doesn’t decide the method to be called.
Overriding is a perfect example of dynamic binding. In overriding both parent and child classes have the same method.


Overlaoding
In Java, it is possible to define two or more methods within the same class that share the same name,
as long as their parameter declarations are different.
While overloaded methods may have different return types, the return type alone is insufficient to distinguish two
versions of a method. When Java encounters a call to an overloaded method, it simply executes the version of the method
whose parameters match the arguments used in the call.
In some cases, Java’s automatic type conversions can play a role in overload resolution.


 */



















