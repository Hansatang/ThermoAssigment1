package temperature.mediator.radiator;

import heater.states.HeaterState;
import temperature.mediator.NamedPropertyChangeSubject;


public interface RadiatorModel  extends NamedPropertyChangeSubject
{
  HeaterState getHeaterState();
  void lowerState();
  void higherState();
}