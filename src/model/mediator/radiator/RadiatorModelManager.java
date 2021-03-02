package model.mediator.radiator;

import model.heater.Heater;
import model.heater.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private Heater heater;
  private PropertyChangeSupport property;

  public RadiatorModelManager()
  {
    this.heater = new Heater();
    property = new PropertyChangeSupport(this);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      System.out.println("Add listener error");
    }
    else
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void update()
  {
    property
        .firePropertyChange("StateChanged", null, heater.getCurrentState());
  }

  @Override public Heater getHeater()
  {
    return heater;
  }

  @Override public void lowerState()
  {
    System.out.println("Nah");
    HeaterState oldState = heater.getCurrentState();
    heater.downTurn();
    property
        .firePropertyChange("StateChanged", oldState, heater.getCurrentState());
  }

  @Override public void higherState()
  {
    System.out.println("Yay");
    HeaterState oldState = heater.getCurrentState();
    System.out.println("1"+heater.getCurrentState().getPower());
    heater.upTurn();
    System.out.println("1"+heater.getCurrentState().getPower());
    property
        .firePropertyChange("StateChanged", oldState, heater.getCurrentState());
  }
}
