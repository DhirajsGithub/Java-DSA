package com.Dhiraj.OOP2.StaticExample;

public class InnerClass {

//    // non static class
//    class Test {
//        String name;
//
//        public Test(String name) {
//            this.name = name;
//        }
//    }


    // static class
    // to run this class we are not require to objects of class InnerClass
    static class Test2 {
        String name;
        int num;
        public Test2(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        // to String method will be check as like first in the object then in the class then outsidE the class and then the inbuild java file
        public String toString() {
            return name;
        }
    }



    public static void main(String[] args) {
        // again same problem, cannot use non static inside static one, hence non static class is define ouside


        Test a = new Test("kunal", 3);
        Test b  = new Test("Rahul", 8);
        System.out.println(a.num);               // 8      // static variable get updated
        System.out.println(b.num);               // 8


        // though Test2 class is static(i.e. does not depend on objects)
        // whenever we are talking about static we should know where it is mention as static
        // hence Test2 class is independent of objects of class InnerClass but it has it's own object c and d which are not the objects of InnerClass
        Test2 c = new Test2("Kiran", 5);
        Test2 d = new Test2("Sam", 79);
        System.out.println(c.num);
        System.out.println(d.num);


        // internal workgin of some statements
        System.out.println("Me being Me");
//        System class has out method out has again println method which internally converted anthing to string and displays out



    }


}

// non static class
class Test {
    String name;
    static int num;
    public Test(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

// NOT ALLOWED
//static class A{
//
//}



/*


NOTE: Only nested classes can be static.
NOTE: Static inner classes can have static variables

You cant override the inherited static methods, as in java overriding takes place by resolving the type of object at
run-time and not compile time, and then calling the respective method.
Static methods are class level methods, so it is always resolved during compile time.
Static INTERFACE METHODS are not inherited by either an implementing class or a sub-interface.

The static keyword may modify the declaration of a member type C within the body of a non-inner class or interface T.
Its effect is to declare that C is not an inner class. Just as a static method of T has no current instance of T in its
body, C also has no current instance of T, nor does it have any lexically enclosing instances.
Here, test does not have any instance of it's outer class InnerClass. Neither does main.
But main & Test can have instances of each other.

 */














