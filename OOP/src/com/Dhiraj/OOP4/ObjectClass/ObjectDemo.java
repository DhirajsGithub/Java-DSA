package com.Dhiraj.OOP4.ObjectClass;

import com.Dhiraj.OOP4.access.A;

public class ObjectDemo {
    // overriding method in Object class

    int num;
    float gpa;

    public ObjectDemo(int num) {
        this.num = num;
    }

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }


    // hashcode is the random integer value form using an algorithm
    // hashcode implies uniqueness of the object
    @Override
    public int hashCode() {
        return super.hashCode();
//        return num;       // it will return the num from the instance
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        // changing equals method so that it will only compare isntances num
        return this.num == ((ObjectDemo)obj).num;
    }
//    // or
//    @Override
//    public boolean equals(ObjectDemo obj) {
////        return super.equals(obj);
//        // changing equals method so that it will only compare isntances num
//        return this.num == obj.num;
//    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // gives the string representation
    @Override
    public String toString() {
        return super.toString();
    }

    // get's called when garbage collection hits
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {

        // explaining hash code
        ObjectDemo obj = new ObjectDemo(34);
        ObjectDemo obj2 = new ObjectDemo(34);
        ObjectDemo obj3 = obj;
        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());

        // explaning equals and ==
        ObjectDemo ob3 = new ObjectDemo(34, 78.9f);
        ObjectDemo obj4 = new ObjectDemo(34, 67.6f);
        if(obj3 == obj4){
            System.out.println("Obj3 is == to obj4");
        }
        if(obj3.equals(obj4)){
            System.out.println("Obj3 is .equals to obj4");
        }

        // instnace of method
        System.out.println(obj instanceof ObjectDemo);
        System.out.println(obj instanceof Object);

        // getClass() method
//        @Override   // since getClass is set to be final method in Object class hence we cannot override it  
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getName());

        float num1 = 0.1f;
        float num2 = 0.2f;
        float ans = num1 + num2;
        System.out.println(ans);
        System.out.println(0.1 + 0.2);


    }
}

/*
every class extends Object class
if ever class extends Object class and a class can extend any class --> multiple inheritance, which is not allowed in java !
indirectly the class extends Object class

 */
