package model.mediator.radiator;

import model.heater.Heater;

import model.mediator.propertyChange.NamedPropertyChangeSubject;


public interface RadiatorModel  extends NamedPropertyChangeSubject
{
  void update();
  Heater getHeater();
  void lowerState();
  void higherState();
}