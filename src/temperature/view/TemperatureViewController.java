package temperature.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class TemperatureViewController
{
  @FXML private TextField MaxTemp;
  @FXML private TextField MinTemp;
  @FXML private Label outputLabel1;
  @FXML private Label outputLabel;
  @FXML private TextField filterField;
  @FXML private Label filterLabel;

  private TemperatureViewModel model;

  public void init(TemperatureViewModel viewModel)
  {
    this.model = viewModel;
    outputLabel.textProperty().bindBidirectional(model.outputLabelProperty());
    outputLabel1.textProperty().bindBidirectional(model.outputLabel1Property());
    filterField.textProperty().bindBidirectional(model.filterFieldProperty());
    MaxTemp.textProperty().bindBidirectional(model.maxTempProperty());
   MinTemp.textProperty().bindBidirectional(model.minTempProperty());
    filterLabel.textProperty().bindBidirectional(model.filterLabelProperty());
  }

  public void reset()
  {
    // empty
  }

  @FXML private void updateButtonPressed(ActionEvent actionEvent)
  {
    model.getLastTemp();
  }

  @FXML private void onFilter(ActionEvent actionEvent)
  {
    model.onFilter();
  }

  public void onChoose(ActionEvent actionEvent)
  {
    model.onChoose();
  }
}
