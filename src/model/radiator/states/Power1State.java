package model.radiator.states;

import model.radiator.Radiator;

public class Power1State implements RadiatorState
{

    private static final int POWER = 1;

    @Override
    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power2State());
    }

    @Override
    public void turnDown(Radiator radiator) {
        radiator.setPowerState(new Power0State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
