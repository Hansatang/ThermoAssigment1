package model.heater.states;

import model.heater.Heater;

public class Power3State implements HeaterState{

    private static final int POWER = 3;
    private Thread thread;

    public Power3State(Heater heater){
        overHeating(heater);
    }

    @Override
    public void turnUp(Heater heater) {
        System.out.println("Max power");
    }

    @Override
    public void turnDown(Heater heater) {
        thread.interrupt();
        heater.setPowerState(new Power2State());
    }

    @Override
    public int getPower() {
        return POWER;
    }

    private void overHeating(Heater heater){
        thread = new Thread(() -> {
            try
            {
                Thread.sleep(3000);
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
}
