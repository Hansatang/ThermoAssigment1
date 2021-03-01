package temperature.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.mediator.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RadiatorViewModel implements PropertyChangeListener
{
  private StringProperty temperatureLabel;
  private TemperatureModel temperatureModel;

  public RadiatorViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    temperatureModel.addListener("TemperatureChanged", this);
    temperatureLabel = new SimpleStringProperty();

  }


  public StringProperty temperatureLabelProperty()
  {
    return temperatureLabel;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }
}
