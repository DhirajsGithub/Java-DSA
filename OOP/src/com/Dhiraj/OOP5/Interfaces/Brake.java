package com.Dhiraj.OOP5.Interfaces;

public interface Brake {
    void brake();

    // this start won't matter in class car as it is already overriding a start method of any of the parent class that it don't have any idea of
    void start();
}
