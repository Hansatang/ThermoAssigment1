package temperature.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import temperature.view.TemperatureViewController;

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
  }

  public void openView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/TemperatureView.fxml"));
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
    Scene uppercaseScene = new Scene(root);

    String title = "";
    stage.setTitle(title);
    stage.setScene(uppercaseScene);

    stage.show();
  }


}
