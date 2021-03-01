package temperature.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RadiatorViewController
{
  @FXML private Label stateLabel;
  private RadiatorViewModel model;

  public void init(RadiatorViewModel radiatorViewModel)
  {
    this.model = radiatorViewModel;
    stateLabel.textProperty().bind(model.temperatureLabelProperty());
  }

  @FXML private void stateDown(ActionEvent actionEvent)
  {
  }

  @FXML private void stateUp(ActionEvent actionEvent)
  {
  }
}
