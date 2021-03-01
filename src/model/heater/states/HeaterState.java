package model.heater.states;

import model.heater.Heater;

public interface HeaterState{
    void turnUp(Heater heater);
    void turnDown(Heater heater);
    int getPower();
}
