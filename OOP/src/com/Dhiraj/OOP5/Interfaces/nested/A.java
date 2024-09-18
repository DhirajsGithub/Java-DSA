package com.Dhiraj.OOP5.Interfaces.nested;

public class A {
    // nested interface
    // the only deference this has from top level interface is that the nested interface can be declared as public, private or default one
    // but the top level is default or public one
    public interface NestedInterface{
        boolean isOdd(int num);
    }
}

class B implements A.NestedInterface{

    @Override
    public boolean isOdd(int num) {
        return ((num & 1) == 1);
    }
}
