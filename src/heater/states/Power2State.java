package heater.states;

import heater.Heater;

public class Power2State implements HeaterState{

    private int power = 2;

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
        return power;
    }
}
