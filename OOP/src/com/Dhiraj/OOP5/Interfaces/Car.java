package com.Dhiraj.OOP5.Interfaces;

public class Car implements Brake, Engine, Media{
    // must implement all method of parent class Brake, Engine, Media and they need to be public 
    @Override
    public void brake() {
        System.out.println("I brake like a normal brake");
    }

    @Override
    public void start() {
        System.out.println("I start like a normal start");

    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal stop");

    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal acc");

    }
}
