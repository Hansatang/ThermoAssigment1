package heater.states;

import heater.Heater;

public interface HeaterState{
    void turnUp(Heater heater);
    void turnDown(Heater heater);
    int getPower();
}
