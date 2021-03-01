package model.mediator.radiator;

import model.heater.states.HeaterState;
import model.mediator.propertyChange.NamedPropertyChangeSubject;


public interface RadiatorModel  extends NamedPropertyChangeSubject
{
  HeaterState getHeaterState();
  void lowerState();
  void higherState();
}