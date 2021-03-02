package model.radiator;

import model.radiator.states.RadiatorState;
import model.radiator.states.Power0State;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Radiator implements PropertyChangeListener
{

  private RadiatorState currentState;

  public Radiator()
  {
    this.currentState = new Power0State();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }

  public RadiatorState getCurrentState()
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

  public void setPowerState(RadiatorState state)
  {
    currentState = state;
  }

  public int getPower()
  {
    return currentState.getPower();
  }

}
