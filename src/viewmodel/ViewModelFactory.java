package viewmodel;

import model.core.ModelFactory;
import viewmodel.radiator.RadiatorViewModel;
import viewmodel.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private TemperatureViewModel temperatureViewModel;
  private RadiatorViewModel radiatorViewModel;

  /** Initialize values */
  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
    this.temperatureViewModel = new TemperatureViewModel(
        mf.getTemperatureModel());
    this.radiatorViewModel = new RadiatorViewModel(mf.getRadiatorModel());
  }

  /** Return {@link TemperatureViewModel} object */
  public TemperatureViewModel getTemperatureViewModel()
  {
    if (temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(mf.getTemperatureModel());
    }
    return temperatureViewModel;
  }

  /** Return {@link RadiatorViewModel} object */
  public RadiatorViewModel getRadiatorViewModel()
  {
    if (radiatorViewModel == null)
    {
      radiatorViewModel = new RadiatorViewModel(mf.getRadiatorModel());
    }
    return radiatorViewModel;
  }
}
