package model.core;

import model.mediator.radiator.RadiatorModel;
import model.mediator.radiator.RadiatorModelManager;
import model.mediator.temperature.TemperatureModel;
import model.mediator.temperature.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  /** Returns temperature model, and if it isn't initialized then it does that and returns it.  * */
  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null)
      temperatureModel = new TemperatureModelManager();
    return temperatureModel;
  }

  /** Returns radiator model, and if it isn't initialized then it does that and returns it.  * */
  public RadiatorModel getRadiatorModel(){
    if (radiatorModel == null){
      radiatorModel = new RadiatorModelManager();
    }
    return radiatorModel;
  }
}
