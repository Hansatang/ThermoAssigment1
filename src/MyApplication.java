import javafx.application.Application;
import javafx.stage.Stage;
import model.thermometer.Thermometer;
import model.core.ModelFactory;
import viewmodel.ViewModelFactory;
import view.ViewHandler;

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
    Thermometer therm1 = new Thermometer("1", 15, 1, mf.getTemperatureModel(),
        mf.getRadiatorModel());
    Thermometer therm2 = new Thermometer("2", 25, 1, mf.getTemperatureModel(),
        mf.getRadiatorModel());
    Thread t1 = new Thread(therm1);
    Thread t2 = new Thread(therm2);
    t1.start();
    t2.start();
  }
}
