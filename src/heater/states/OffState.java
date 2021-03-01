package heater.states;

import heater.Heater;

public class OffState implements HeaterState{

    private int power = 0;

    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Heater heater) {
        //
    }

    @Override
    public int getPower() {
        return power;
    }
}
