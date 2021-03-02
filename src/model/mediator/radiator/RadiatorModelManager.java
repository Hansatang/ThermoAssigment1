package model.mediator.radiator;

import model.radiator.Radiator;
import model.radiator.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private Radiator radiator;
  private PropertyChangeSupport property;

  public RadiatorModelManager()
  {
    this.radiator = new Radiator();
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
        .firePropertyChange("StateChanged", null, radiator.getCurrentState());
  }

  @Override public Radiator getHeater()
  {
    return radiator;
  }

  @Override public void lowerState()
  {
    System.out.println("Nah");
    RadiatorState oldState = radiator.getCurrentState();
    radiator.downTurn();
    property.firePropertyChange("StateChanged", oldState,
        radiator.getCurrentState());
  }

  @Override public void higherState()
  {
    System.out.println("Yay");
    RadiatorState oldState = radiator.getCurrentState();
    System.out.println("1" + radiator.getCurrentState().getPower());
    radiator.upTurn();
    System.out.println("1" + radiator.getCurrentState().getPower());
    property.firePropertyChange("StateChanged", oldState,
        radiator.getCurrentState());
  }
}
