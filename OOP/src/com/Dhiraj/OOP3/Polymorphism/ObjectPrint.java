package com.Dhiraj.OOP3.Polymorphism;

public class ObjectPrint {
    int num;

    public ObjectPrint(int num) {
        this.num = num;
    }

    @Override        // no error hence it implies ObjectPrint Overrides the toString method
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public static void main(String[] args) {
        ObjectPrint obj = new ObjectPrint(44);

        System.out.println(obj);     // com.Dhiraj.OOP3.Polymorphism.ObjectPrint@4617c264
        // we know internally every class extend java Object class
        // obj --> obj.toString() method from Object parent class of child ObjectPrint
    }
}
