package model.mediator.radiator;

import model.radiator.Radiator;
import model.radiator.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private Radiator radiator;
  private PropertyChangeSupport property;

  // Constructor initializes radiator and Property Change Support.
  public RadiatorModelManager()
  {
    this.radiator = new Radiator();
    property = new PropertyChangeSupport(this);
  }

  // Adds a listener to the Property Change Support if the it has a name.
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

  // Updates the state of the radiator.
  @Override public void update()
  {
    property
        .firePropertyChange("StateChanged", null, radiator.getCurrentState());
  }

  // Returns the radiator
  @Override public Radiator getRadiator()
  {
    return radiator;
  }

  // Tells the radiator to turn one state down.
  @Override public void lowerState()
  {
    radiator.downTurn();
    property
        .firePropertyChange("StateChanged", null, radiator.getCurrentState());
  }

  // Tells the radiator to turn one state up.
  @Override public void higherState()
  {
    radiator.upTurn();
    property
        .firePropertyChange("StateChanged", null, radiator.getCurrentState());
  }
}
