package heater.states;

import heater.Heater;

public class Power3State implements HeaterState{


    private int power = 3;

    public Power3State(Heater heater){
        try
        {
            Thread.sleep(1000);
            System.out.println("A");
            heater.setPowerState(new Power2State());
        }
        catch (InterruptedException e)
        {
            System.out.println("kupa");
        }
    }

    @Override
    public void turnUp(Heater heater) {

    }

    @Override
    public void turnDown(Heater heater) {
        heater.setPowerState(new Power2State());
    }

    @Override
    public int getPower() {
        return power;
    }
}
