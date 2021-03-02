package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;
import view.radiator.RadiatorViewController;
import view.temperature.TemperatureViewController;

import java.io.IOException;

public class ViewHandler extends Application
{
  private Stage stage;


 private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start(Stage primaryStage)
  {
    this.stage = primaryStage;
    openView();
    openRadiator();
  }

  public void openView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/temperature/TemperatureView.fxml"));
    Parent root = null;

    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    TemperatureViewController ctrl = loader.getController();
    ctrl.init(vmf.getTemperatureViewModel());

    stage.setTitle("Thermometer");
    stage.setScene(new Scene(root));

    stage.show();
  }

  public void openRadiator()
  {

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/radiator/RadiatorView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    RadiatorViewController view = loader.getController();
    view.init(vmf.getRadiatorViewModel());
    Stage localStage = new Stage();
    localStage.setTitle("Heater");
    localStage.setScene(new Scene(root));
    localStage.show();
  }
}
