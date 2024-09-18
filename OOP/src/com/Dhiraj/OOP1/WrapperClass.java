package com.Dhiraj.OOP1;

public class WrapperClass {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
//        a.

        // primitives like an object
//        Integer num = new Integer(10);
         Integer num = 10;
         Integer num2 = 20;
//         num.

        swap(a, b);
        System.out.println(a+ " "+ b);    // not swap since they are not pass by reference only objects are pass by reference

        swap2(num, num2);
        System.out.println(num+" "+num2);   // though num and num2 being object but they didn't swap why ? coz Integer/primitves belong to final class

//        final int bonus = 3;          // need to initialize at time of declartion if you are using final keyword
//        bonus = 4;

        // what about final keyword and reference type i.e. objects
        final A kunal = new A("Kunal Kushawaha");
        kunal.name = "Change Name";

//        // when a non primitive is final you cannot reassign it
//        // but can change the property of the non primitve
//        kunal = new A("Somthing name");      // WRONG as Cannot assign a value to final variable 'kunal'

        A obj;
//        obj being refernece vairble pointing towards object in the heap
//        IMP : No more than one object can points towards SAME reference variable hence the remaining object will be removed by the garbage collector
//        it is done on it's own
//          garbage collectio wont be shown for less objects witout refernce varaibles
        for (int i = 0; i < 10000000; i++) {
            obj = new A("Random Name");

        }

    }
    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = a;
    }
    static void swap2(Integer a, Integer b){
        int Integer = a;
        a = b;
        b = a;
    }
}
class A{
    final int num = 10;
    String name;

    // shorcut to make a constructor as control + enter
    public A(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("Object is being deleted");
    }
}

/*

In Java, wrapper classes are used to wrap primitive data types such as int, char, etc. into objects.
This is useful when working with collections, where only objects can be stored, not primitive data types.
The wrapper classes also provide additional methods that can be useful in processing the wrapped data.


final Keyword:
A field can be declared as final. Doing so prevents its contents from being modified, making it, essentially, a constant.
This means that you must initialize a final field when it is declared.
It is a common coding convention to choose all uppercase identifiers for final fields:
     final int FILE_OPEN = 2;

Unfortunately, final guarantees immutability only when instance variables are primitive types, not reference types.
If an instance variable of a reference type has the final modifier, the value of that instance variable (the reference
to an object) will never change—it will always refer to the same object—but the value of the object itself can change.

The finalize( ) Method:
Sometimes an object will need to perform some action when it is destroyed.
To handle such situations, Java provides a mechanism called finalization. By using finalization,
you can define specific actions that will occur WHEN THE OBJECT IS JUST ABOUT TO RECLAIMED FROM GARBAGE COLLECTOR
To add a finalizer to a class, you simply define the finalize( ) method. The Java run time calls that method whenever
it is about to recycle an object of that class. Right before an asset is freed, the Java run time calls the finalize( )
method on the object.



 */
