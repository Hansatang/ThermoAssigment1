package heater;

import heater.states.HeaterState;
import heater.states.OffState;
import temperature.mediator.radiator.RadiatorModel;
import temperature.mediator.temperature.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Heater implements PropertyChangeListener {

    private HeaterState currentState;
    private RadiatorModel radiatorModel;

    public Heater(RadiatorModel radiatorModel)
    {
        this.currentState= new OffState();
        this.radiatorModel = radiatorModel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public HeaterState getCurrentState()
    {
        return currentState;
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
