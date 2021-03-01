import javafx.application.Application;
import javafx.stage.Stage;
import temperature.Thermometer;
import temperature.core.ModelFactory;
import temperature.core.ViewModelFactory;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.core.ViewHandler;

public class MyApplication extends Application
{
  @Override public void start(Stage primaryStage)
  {

    // View
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler view = new ViewHandler(vmf);
    view.start(primaryStage);

    //Thermometers
    Thermometer thermo1 = new Thermometer("1", 15, 1, mf.getTemperatureModel());
    Thermometer thermo2 = new Thermometer("2", 25, 1,mf.getTemperatureModel());
    Thread t1 = new Thread(thermo1);
    Thread t2 = new Thread(thermo2);
    t1.start();
    t2.start();
  }
}
