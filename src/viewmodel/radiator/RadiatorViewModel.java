package viewmodel.radiator;

import model.radiator.states.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.mediator.radiator.RadiatorModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RadiatorViewModel implements PropertyChangeListener
{
  private StringProperty temperatureLabel;
  private RadiatorModel radiatorModel;

  /** Constructor initializes RadiatorModel object and StringProperty object temperatureLabel.
   *  RadiatorModel object adds a this (RadiatorViewModel) as a listener. */
  public RadiatorViewModel(RadiatorModel radiatorModel)
  {
    this.radiatorModel = radiatorModel;
    radiatorModel.addListener("StateChanged", this);
    temperatureLabel = new SimpleStringProperty();
  }

  /** Return temperatureLabel */
  public StringProperty temperatureLabelProperty()
  {
    return temperatureLabel;
  }

  /** Update the label upon Radiator state change */
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(new Runnable()
    {
      @Override public void run()
      {
        RadiatorState radiatorState  = (RadiatorState) evt.getNewValue();
        temperatureLabel.set(radiatorState.getPower()+" State");
      }
    });
  }

  /** Turn down a state */
  public void stateDown()
  {
    radiatorModel.lowerState();
  }

  /** Turn up a state */
  public void stateUp()
  {
    radiatorModel.higherState();
  }
}
