package temperature.viewmodel.temperature;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewModel implements PropertyChangeListener
{
  private StringProperty outputLabel;
  private StringProperty Warn1;
  private StringProperty Warn2;
  private StringProperty outputLabel1;
  private StringProperty MaxTemp;
  private StringProperty MinTemp;
  private String thermometerId;
  private double maxT = 30;
  private double minT = -10;

  private TemperatureModel temperatureModel;

  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    temperatureModel.addListener("TemperatureChanged", this);
    outputLabel = new SimpleStringProperty();
    outputLabel1 = new SimpleStringProperty();
    MaxTemp = new SimpleStringProperty();
    MinTemp = new SimpleStringProperty();
    Warn1 = new SimpleStringProperty();
    Warn2 = new SimpleStringProperty();
    this.thermometerId = null;
  }

  public void getLastTemp()
  {
    Temperature t = temperatureModel.getLastInsertedTemperature("1");
    Temperature t2 = temperatureModel.getLastInsertedTemperature("2");
    if (t != null)
    {
      outputLabel.set(t.toString());
      outputLabel1.set(t2.toString());
    }
    else
    {
      outputLabel.set("No data");
      outputLabel1.set("No data");

    }
  }

  public StringProperty warn1Property()
  {
    return Warn1;
  }

  public StringProperty warn2Property()
  {
    return Warn2;
  }

  public StringProperty maxTempProperty()
  {
    return MaxTemp;
  }

  public StringProperty minTempProperty()
  {
    return MinTemp;
  }

  public StringProperty outputLabelProperty()
  {
    return outputLabel;
  }

  public StringProperty outputLabel1Property()
  {
    return outputLabel1;
  }



  public void onChoose()
  {
    if (MaxTemp.get() != null)
    {
      maxT = Double.parseDouble((MaxTemp.get()));
    }
    if (MinTemp.get() != null)
    {
      minT = Double.parseDouble((MinTemp.get()));
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(new Runnable()
    {
      @Override public void run()
      {
        Temperature temperature = (Temperature) evt.getNewValue();
        Temperature temperature2 = (Temperature) evt.getOldValue();
        if (evt.getNewValue() != null)
        {
          outputLabel.set(evt.getNewValue().toString());
          if (temperature.getValue() > maxT)
          {
            Warn1.set("Warning");
          }
          else
          {
            Warn1.set(null);
          }
        }
        if (evt.getOldValue() != null)
        {
          outputLabel1.set(evt.getOldValue().toString());
          if (temperature2.getValue() > maxT)
          {
            Warn2.set("Warning");
          }
          else
          {
            Warn1.set(null);
          }
        }
      }
    });
  }
}
