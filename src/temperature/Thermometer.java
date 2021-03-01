package temperature;

import heater.states.OffState;
import heater.states.Power1State;
import heater.states.Power2State;
import temperature.mediator.radiator.RadiatorModel;
import temperature.mediator.temperature.TemperatureModel;

public class Thermometer implements Runnable
{
  private String id;
  private double t;
  private int d;
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  public Thermometer(String id, double temp, int d, TemperatureModel temperatureModel,RadiatorModel radiatorModel)
  {
    this.id = id;
    this.t = temp;
    this.d=d;
    this.temperatureModel = temperatureModel;
    this.radiatorModel = radiatorModel;
  }

  private int stateToPowerLevel(){
    if (radiatorModel.getHeaterState() instanceof OffState)
    {
      return 0;
    }
    else if (radiatorModel.getHeaterState() instanceof Power1State)
    {
      return 1;
    }
    else if (radiatorModel.getHeaterState() instanceof Power2State)
    {
      return 2;
    }
    else
    {
      return 3;
    }
  }



  private double temperature( int p, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }

    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    this.t = t;
    return t;
  }

  @Override public void run()
  {
    while (true)
    {
//    System.out.println("looo panie"+ stateToPowerLevel());
      temperatureModel.addTemperature(id, temperature( stateToPowerLevel(), 0, 6));
      radiatorModel.getHeaterState();
      System.out.println(stateToPowerLevel());
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
