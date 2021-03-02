package model.mediator.radiator;

import model.radiator.Radiator;

import model.mediator.propertyChange.NamedPropertyChangeSubject;


public interface RadiatorModel  extends NamedPropertyChangeSubject
{
  void update();
  Radiator getHeater();
  void lowerState();
  void higherState();
}