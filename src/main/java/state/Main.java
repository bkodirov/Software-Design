package state;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Beka on 17.04.17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/state.fxml"));
        primaryStage.setTitle("Player pattern");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
