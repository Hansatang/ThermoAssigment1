package temperature.view;

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
  private StringProperty filterField;
  private StringProperty MaxTemp;
  private StringProperty MinTemp;
  private StringProperty filterLabel;
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
    filterField = new SimpleStringProperty();
    MaxTemp = new SimpleStringProperty();
    MinTemp = new SimpleStringProperty();
    Warn1 = new SimpleStringProperty();
    Warn2 = new SimpleStringProperty();
    filterLabel = new SimpleStringProperty("All");
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

  public StringProperty filterFieldProperty()
  {
    return filterField;
  }

  public StringProperty filterLabelProperty()
  {
    return filterLabel;
  }

  public void onFilter()
  {
    String oldValue = filterLabel.get();
    if (oldValue.equals(null))
    {
      oldValue = null;
    }
    if (oldValue.equals("All"))
    {
      oldValue = null;
    }
    thermometerId = filterField.get();
    if (filterField.get() == null)
    {
      thermometerId = null;
      filterLabel.set("All");
    }
    else if (thermometerId.isEmpty())
    {
      thermometerId = null;
      filterLabel.set("All");
    }
    else
    {
      filterLabel.set(thermometerId);
    }
    filterField.set(null);
    getLastTemp();
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
          if (temperature.getValue() > maxT)
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
