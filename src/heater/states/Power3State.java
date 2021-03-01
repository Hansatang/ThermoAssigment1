package heater.states;

import heater.Heater;

public class Power3State implements HeaterState{


    private int power = 3;
    private Thread thread;

    public Power3State(Heater heater){
        System.out.println("Power3State");
        thread = new Thread(() -> {
            try
            {
                Thread.sleep(1000);
                System.out.println("A");
                heater.setPowerState(new Power2State());
                System.out.println("nab");
            }
            catch (InterruptedException e)
            {
                System.out.println("kupa");
            }
        });
        thread.setDaemon(true);
        thread.start();


    }

    @Override
    public void turnUp(Heater heater) {

    }

    @Override
    public void turnDown(Heater heater) {
        thread.interrupt();
        heater.setPowerState(new Power2State());
    }

    @Override
    public int getPower() {
        return power;
    }
}
