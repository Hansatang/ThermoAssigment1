package model.mediator.temperature;

import model.mediator.propertyChange.NamedPropertyChangeSubject;
import model.temperature.Temperature;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
