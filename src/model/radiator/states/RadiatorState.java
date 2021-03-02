package model.radiator.states;

import model.radiator.Radiator;

public interface RadiatorState
{
    // Turn up a state.
    void turnUp(Radiator radiator);
    // Turn down a state.
    void turnDown(Radiator radiator);
    // Return the current power (int)
    int getPower();
}
