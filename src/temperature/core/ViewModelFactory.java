package temperature.core;

import temperature.view.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public TemperatureViewModel getTemperatureViewModel(){
    if (temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(mf.getTemperatureModel());
    }
    return temperatureViewModel;
  }
}
