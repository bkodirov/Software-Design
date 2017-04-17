package state;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * Created by Beka on 16.04.17.
 */
public class UiController {
    private IState state = new RegularState(this);

    @FXML private RadioButton regular;
    @FXML private RadioButton gravel;
    @FXML private RadioButton wet;
    @FXML private RadioButton ice;
    @FXML private Label label;

    @FXML
    void initialize(){
        ToggleGroup g = new ToggleGroup();
        regular.setToggleGroup(g);
        gravel.setToggleGroup(g);
        wet.setToggleGroup(g);
        ice.setToggleGroup(g);

        g.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton rb = (RadioButton) newValue;
            switch (rb.getId()) {
                case "regular":
                    state = new RegularState(this);
                    break;
                case "gravel":
                    state = new GravelState(this);
                    break;
                case "wet":
                    state = new WetState(this);
                    break;
                case "ice":
                    state = new IceState(this);
                    break;
            }
        });
    }

    public void onRight(ActionEvent actionEvent) {
        state.onRight();
    }

    public void onLeft(ActionEvent actionEvent) {
        state.onLeft();
    }

    public void onBrake(ActionEvent actionEvent) {
        state.onLeft();
    }

    public void onAccel(ActionEvent actionEvent) {
        state.onAccel();
    }

    public void setTitle(String title) {
        label.setText(title);
    }
}
