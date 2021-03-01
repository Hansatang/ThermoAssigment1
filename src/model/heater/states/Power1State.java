package model.heater.states;

import model.heater.Heater;

public class Power1State implements HeaterState{

    private static final int POWER = 1;

    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power2State());
    }

    @Override
    public void turnDown(Heater heater) {
        heater.setPowerState(new Power0State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
