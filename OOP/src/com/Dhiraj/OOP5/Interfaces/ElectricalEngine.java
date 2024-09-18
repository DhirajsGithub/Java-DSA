package com.Dhiraj.OOP5.Interfaces;

public class ElectricalEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electrical Engine Starts");
    }

    @Override
    public void stop() {
        System.out.println("Electrical Engine Stops");
    }

    @Override
    public void acc() {
        System.out.println("Electical Engine Accelerates");
    }
}
