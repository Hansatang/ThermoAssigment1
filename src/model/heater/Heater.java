package model.heater;

import model.heater.states.HeaterState;
import model.heater.states.Power0State;
import model.mediator.radiator.RadiatorModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Heater implements PropertyChangeListener
{

  private HeaterState currentState;

  public Heater()
  {
    this.currentState = new Power0State();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }

  public HeaterState getCurrentState()
  {
    return currentState;
  }

  public void upTurn()
  {
    currentState.turnUp(this);
  }

  public void downTurn()
  {
    currentState.turnDown(this);
  }

  public void setPowerState(HeaterState state)
  {
    currentState = state;
  }

  public int getPower()
  {
    return currentState.getPower();
  }

}
