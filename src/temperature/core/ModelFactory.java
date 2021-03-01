package temperature.core;

import temperature.mediator.radiator.RadiatorModel;
import temperature.mediator.radiator.RadiatorModelManager;
import temperature.mediator.temperature.TemperatureModel;
import temperature.mediator.temperature.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null)
      temperatureModel = new TemperatureModelManager();
    return temperatureModel;
  }


  public RadiatorModel getRadiatorModel(){
    if (radiatorModel == null){
      radiatorModel = new RadiatorModelManager();
    }
    return radiatorModel;
  }
}
