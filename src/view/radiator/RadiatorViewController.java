package view.radiator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import viewmodel.radiator.RadiatorViewModel;

public class RadiatorViewController
{
  @FXML private Label stateLabel;
  private RadiatorViewModel model;

  public void init(RadiatorViewModel radiatorViewModel)
  {
    this.model = radiatorViewModel;
    stateLabel.textProperty().bindBidirectional(model.temperatureLabelProperty());
  }

  @FXML private void stateDown(ActionEvent actionEvent)
  {
    model.stateDown();
  }

  @FXML private void stateUp(ActionEvent actionEvent)
  {
    model.stateUp();
  }
}
