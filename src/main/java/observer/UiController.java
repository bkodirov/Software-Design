package observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Created by Beka on 27.04.17.
 */
public class UiController extends Application implements Initializable {

    @FXML TextArea textArea;

    private final Collection collection = new Collection();
    private Observer observer = () -> {
        textArea.clear();
        for (String name : collection.getNames()) {
            textArea.setText(String.format("%s\n%s", textArea.getText(), name));
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collection.attach(observer);
    }

    public void onAdd(ActionEvent actionEvent) {
        collection.add(UUID.randomUUID().toString());
    }

    public void onRemove(ActionEvent actionEvent) {
        collection.remove(collection.getNames().get((int) (Math.random() * (collection.size() - 1))));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/observer.fxml"));
        primaryStage.setTitle("Observer pattern");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        collection.detach(observer);
        super.stop();
    }
}
