package model.radiator.states;

import model.radiator.Radiator;

public class Power3State implements RadiatorState
{

  private static final int POWER = 3;
  // Thread for checking if over heating.
  private Thread thread;

  public Power3State(Radiator radiator)
  {
    overHeating(radiator);
  }

  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Max power");
  }

  @Override public void turnDown(Radiator radiator)
  {
    thread.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }

  // If overheating then turn the power state one down.
  private void overHeating(Radiator radiator)
  {
    thread = new Thread(() -> {
      try
      {
        Thread.sleep(1000);
        radiator.setPowerState(new Power2State());
      }
      catch (InterruptedException e)
      {
        System.out.println("Interruption");
      }
    });
    thread.setDaemon(true);
    thread.start();
  }
}
