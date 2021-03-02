package model.radiator.states;

import model.radiator.Radiator;

public interface RadiatorState
{
    void turnUp(Radiator radiator);
    void turnDown(Radiator radiator);
    int getPower();
}
