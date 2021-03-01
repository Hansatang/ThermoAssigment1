package model.heater.states;

import model.heater.Heater;

public class Power2State implements HeaterState{

    private static final int POWER = 2;

    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power3State(heater));
    }

    @Override
    public void turnDown(Heater heater) {
        heater.setPowerState(new Power1State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
