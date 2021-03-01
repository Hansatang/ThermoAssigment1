package temperature.mediator.radiator;

import heater.states.*;
import temperature.model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private HeaterState heaterState;
  private PropertyChangeSupport property;

  public RadiatorModelManager()
  {
    this.heaterState=new OffState();
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
    HeaterState oldState = heaterState;
    if (oldState instanceof Power3State){
      heaterState = new Power2State();
    }
    else if (oldState instanceof Power2State){
      heaterState = new Power1State();
    }
    else if (oldState instanceof Power1State){
      heaterState = new OffState();
    }
    property.firePropertyChange("StateChanged",
        oldState,
        heaterState);
  }


  @Override public void higherState()
  {
    System.out.println("Yay");
    HeaterState oldState = heaterState;
    if (oldState instanceof OffState){
      heaterState = new Power1State();
    }
    else if (oldState instanceof Power1State){
      heaterState = new Power2State();
    }
//    else if (oldState instanceof Power2State){
//      heaterState = new Power3State();
//    }
    property.firePropertyChange("StateChanged",
        oldState,
        heaterState);
  }
}
