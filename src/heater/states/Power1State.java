package heater.states;

import heater.Heater;

public class Power1State implements HeaterState{

    private int power = 1;

    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power2State());
    }

    @Override
    public void turnDown(Heater heater) {
        heater.setPowerState(new OffState());
    }

    @Override
    public int getPower() {
        return power;
    }
}
