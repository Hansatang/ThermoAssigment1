package model.mediator.temperature;

import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport property;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    property = new PropertyChangeSupport(this);
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    temperatureList.addTemperature(temperature);
    property.firePropertyChange("TemperatureChanged",
        temperatureList.getLastTemperature("2"),
        temperatureList.getLastTemperature("1"));
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      property.addPropertyChangeListener(listener);
    }
    else
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
  }

}
