package mediator.othello;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import mediator.othello.board.BoardGrid;
import mediator.othello.game.GameLogic;
import mediator.othello.game.Position;
import mediator.othello.mediator.BoardMediatorImpl;
import mediator.othello.mediator.Cell;
import mediator.othello.mediator.Colleague;
import mediator.othello.mediator.Mediator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Reversi implements Initializable {

    @FXML Label statusLabel;
    @FXML protected BoardGrid gridPanel;
    private Mediator mediator;
    private GameLogic game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newAction();
    }

    @FXML
    void newAction() {
        List<Colleague> colleagues = new ArrayList<>();
        ImageView[] views = gridPanel.getCells();
        for (int i = 0; i < views.length; i++) {
            Position position = new Position(i % gridPanel.getColumnCount(), i / gridPanel.getColumnCount());
            Colleague cell = new Cell(views[i], position);
            colleagues.add(cell);
        }

        game = new GameLogic(gridPanel.getRowCount(), gridPanel.getColumnCount());
        game.setStatusChangeListener(statusLabel::setText);
        mediator = new BoardMediatorImpl(game, colleagues);
    }
}
