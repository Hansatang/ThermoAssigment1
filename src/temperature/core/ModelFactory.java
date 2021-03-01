package temperature.core;

import temperature.mediator.temperature.TemperatureModel;
import temperature.mediator.temperature.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null)
      temperatureModel = new TemperatureModelManager();
    return temperatureModel;
  }
}
