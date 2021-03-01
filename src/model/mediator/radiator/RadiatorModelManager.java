package model.mediator.radiator;

import model.heater.Heater;
import model.heater.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private HeaterState heaterState;
  private Heater heater;
  private PropertyChangeSupport property;

  public RadiatorModelManager()
  {
    this.heater = new Heater();
    this.heaterState = new Power0State();
    property = new PropertyChangeSupport(this);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener) throws Exception
  {
    if (propertyName != null)
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
    else
    {
      throw new Exception("Chuj ci w dupe");
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName != null)
    {
      property.removePropertyChangeListener(propertyName, listener);
    }
    else
    {
      property.removePropertyChangeListener(listener);
    }
  }

  @Override public HeaterState getHeaterState()
  {
    property
        .firePropertyChange("StateChanged", null, heater.getCurrentState());
    heaterState = heater.getCurrentState();
    return heaterState;
  }

  @Override public void lowerState()
  {
    System.out.println("Nah");
    HeaterState oldState = heater.getCurrentState();
    heater.downTurn();
    heaterState = heater.getCurrentState();
    property
        .firePropertyChange("StateChanged", oldState, heater.getCurrentState());
  }

  @Override public void higherState()
  {
    System.out.println("Yay");
    HeaterState oldState = heaterState;
    heater.upTurn();
    System.out.println("1"+heater.getCurrentState().getPower());
    heaterState = heater.getCurrentState();
    System.out.println("1"+heater.getCurrentState().getPower());
    property
        .firePropertyChange("StateChanged", oldState, heater.getCurrentState());
  }
}
