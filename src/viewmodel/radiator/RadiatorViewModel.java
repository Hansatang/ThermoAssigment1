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

  public RadiatorViewModel(RadiatorModel radiatorModel)
  {
    this.radiatorModel = radiatorModel;
    radiatorModel.addListener("StateChanged", this);
    temperatureLabel = new SimpleStringProperty();
  }

  public StringProperty temperatureLabelProperty()
  {
    return temperatureLabel;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(new Runnable()
    {
      @Override public void run()
      {
        RadiatorState radiatorState = radiatorModel.getHeater().getCurrentState();
        // HeaterState heaterState = (HeaterState) evt.getNewValue();
        if (radiatorState instanceof Power0State)
        {
          temperatureLabel.set("OffState");
        }
        else if (radiatorState instanceof Power1State)
        {
          temperatureLabel.set("1 state");
        }
        else if (radiatorState instanceof Power2State)
        {
          temperatureLabel.set("2 state");
        }
        else if (radiatorState instanceof Power3State)
        {
          temperatureLabel.set("3 state");
        }
      }
    });
  }

  public void stateDown()
  {
    radiatorModel.lowerState();
  }

  public void stateUp()
  {
    radiatorModel.higherState();
  }
}
