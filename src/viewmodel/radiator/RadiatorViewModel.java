package viewmodel.radiator;

import model.heater.states.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.mediator.radiator.RadiatorModel;
import model.mediator.temperature.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RadiatorViewModel implements PropertyChangeListener
{
  private StringProperty temperatureLabel;
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  public RadiatorViewModel(TemperatureModel temperatureModel,
      RadiatorModel radiatorModel)
  {
    this.temperatureModel = temperatureModel;
    this.radiatorModel = radiatorModel;
    temperatureModel.addListener("TemperatureChanged", this);
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
        HeaterState heaterState = radiatorModel.getHeaterState();
        if (heaterState instanceof Power0State)
        {
          temperatureLabel.set("OffState");
        }
        else if (heaterState instanceof Power1State)
        {
          temperatureLabel.set("1 state");
        }
        else if (heaterState instanceof Power2State)
        {
          temperatureLabel.set("2 state");
        }
        else if (heaterState instanceof Power3State)
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
