package model.heater.states;

import model.heater.Heater;

public class Power0State implements HeaterState{

    private static final int POWER = 0;

    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Heater heater) {
        System.out.println("Lowest state");
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
