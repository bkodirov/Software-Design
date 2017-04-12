package memento.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Originator (its state gets externalized to be stored in a
 * Memento object)
 */
public class Controller {
    private Timer timer = new Timer(true);
    private CareTaker careTaker = new CareTaker();

    @FXML
    TextArea textArea;

    public Controller() {
        timer.scheduleAtFixedRate(timerTask, 3000, 3000);
    }

    public Memento getState() {
        return new Memento(textArea.getText());
    }

    public void onLoad(ActionEvent actionEvent) {

    }

    public void onUndo(ActionEvent actionEvent) {
        Memento memento = careTaker.pop();
        if (memento != null) {
            textArea.setText(memento.text);
        }
    }

    public void onSave(ActionEvent actionEvent) {

    }

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Memento memento = getState();
            if (!memento.equals(careTaker.get())) {
                careTaker.add(memento);
            }
        }
    };

    static class Memento {
        private String text;

        private Memento(String text) {
            this.text = text;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Memento memento = (Memento) o;

            return text != null ? text.equals(memento.text) : memento.text == null;
        }

        @Override
        public int hashCode() {
            return text != null ? text.hashCode() : 0;
        }
    }
}
