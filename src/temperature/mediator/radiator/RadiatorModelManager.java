package temperature.mediator.radiator;

import heater.Heater;
import heater.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private HeaterState heaterState;
  private Heater heater;
  private PropertyChangeSupport property;

  public RadiatorModelManager()
  {
    this.heater = new Heater(this);
    this.heaterState = new OffState();
    property = new PropertyChangeSupport(this);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      property.addPropertyChangeListener(listener);
    }
    else // a specific event
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      property.removePropertyChangeListener(listener);
    }
    else // a specific event
    {
      property.removePropertyChangeListener(propertyName, listener);
    }
  }

  @Override public HeaterState getHeaterState()
  {
    return heaterState;
  }

  @Override public void lowerState()
  {
    System.out.println("Nah");
    HeaterState oldState = heater.getCurrentState();
    heater.downTurn();
    heaterState = heater.getCurrentState();
    property.firePropertyChange("StateChanged", oldState, heater.getCurrentState());
  }

  @Override public void higherState()
  {
    System.out.println("Yay");
    HeaterState oldState = heaterState;
    if (oldState instanceof OffState)
    {
      heater.upTurn();
      heaterState = new Power1State();
    }
    else if (oldState instanceof Power1State)
    {
      heater.upTurn();
      heaterState = new Power2State();
    }
    //    else if (oldState instanceof Power2State){
    //      heaterState = new Power3State();
    //    }
    property.firePropertyChange("StateChanged", oldState, heater.getCurrentState());
  }
}
