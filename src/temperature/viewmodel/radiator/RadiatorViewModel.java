package temperature.viewmodel.radiator;

import heater.states.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.mediator.radiator.RadiatorModel;
import temperature.mediator.temperature.TemperatureModel;

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
        if (heaterState instanceof OffState)
        {
          temperatureLabel.set("OffState");
        }
        else  if (heaterState instanceof Power1State)
        {
          temperatureLabel.set("1 Power state");
        }
        else  if (heaterState instanceof Power2State)
        {
          temperatureLabel.set("2 Power state");
        }
        else  if (heaterState instanceof Power3State)
        {
          temperatureLabel.set("3 Power state");
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
