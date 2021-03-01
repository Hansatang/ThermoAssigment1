package temperature.core;

import temperature.view.RadiatorViewModel;
import temperature.view.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private TemperatureViewModel temperatureViewModel;
  private RadiatorViewModel radiatorViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
    this.temperatureViewModel = new TemperatureViewModel(
        mf.getTemperatureModel());
    this.radiatorViewModel = new RadiatorViewModel(mf.getTemperatureModel());
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    if (temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(mf.getTemperatureModel());
    }
    return temperatureViewModel;
  }

  public RadiatorViewModel getRadiatorViewModel()
  {
    if (radiatorViewModel == null)
    {
      radiatorViewModel = new RadiatorViewModel(mf.getTemperatureModel());
    }
    return radiatorViewModel;
  }
}
