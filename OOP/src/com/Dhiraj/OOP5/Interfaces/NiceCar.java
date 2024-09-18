package com.Dhiraj.OOP5.Interfaces;

public class NiceCar {
    private Engine engine;
    private Media player = new CDplayer();

    public NiceCar() {
        // initially by default engine is power engine
        engine = new PowerEngine();
    }

    public void stop (){
        engine.stop();
    }
    public void start (){
        engine.start();
    }
    public void stopMusic (){
        player.stop();
    }
    public void startMusic (){
        player.start();
    }

    public void upgradeEngine (){
        this.engine = new ElectricalEngine();
    }

}
