package heater;

import heater.states.HeaterState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Heater implements PropertyChangeListener {

    private HeaterState currentState;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void upTurn(){
        currentState.turnUp(this);
    }

    public void downTurn(){
        currentState.turnDown(this);
    }

    public void setPowerState(HeaterState state){
        currentState = state;
    }

    public int getPower(){
        return currentState.getPower();
    }


}
