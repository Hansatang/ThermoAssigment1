package model.thermometer;

import model.heater.states.Power0State;
import model.heater.states.Power1State;
import model.heater.states.Power2State;
import model.mediator.radiator.RadiatorModel;
import model.mediator.temperature.TemperatureModel;

public class Thermometer implements Runnable
{
  private String id;
  private double t;
  private int d;
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  public Thermometer(String id, double temp, int d,
      TemperatureModel temperatureModel, RadiatorModel radiatorModel)
  {
    this.id = id;
    this.t = temp;
    this.d = d;
    this.temperatureModel = temperatureModel;
    this.radiatorModel = radiatorModel;
  }

  private int stateToPowerLevel()
  {
    //to switch
    if (radiatorModel.getHeater().getCurrentState() instanceof Power0State)
    {
      return 0;
    }
    else if (radiatorModel.getHeater().getCurrentState() instanceof Power1State)
    {
      return 1;
    }
    else if (radiatorModel.getHeater().getCurrentState() instanceof Power2State)
    {
      return 2;
    }
    else
    {
      return 3;
    }
  }


  private double temperature(int p, double t0, int s)
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
      temperatureModel
          .addTemperature(id, temperature(radiatorModel.getHeater().getCurrentState().getPower(), 0, 6));
      radiatorModel.update();
      System.out.println("A"+stateToPowerLevel());
      System.out.println("B"+radiatorModel.getHeater().getCurrentState().getPower());
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
