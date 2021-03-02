package model.radiator.states;

import model.radiator.Radiator;

public class Power0State implements RadiatorState
{

    private static final int POWER = 0;

    @Override
    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Radiator radiator) {
        System.out.println("Lowest state");
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
