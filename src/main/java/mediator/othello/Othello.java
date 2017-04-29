package mediator.othello;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mediator.othello.board.ImageGridGame;

public class Othello extends ImageGridGame<Boolean> {

    @FXML Label statusLabel;

    @FXML
    protected void initialize() {
        super.initialize();
        imageGrid.setImage(true, "/othello/white.png");
        imageGrid.setImage(false, "/othello/black.png");
        imageGrid.setImage(null, "/othello/empty.png");
        newAction();
    }

    private Boolean player = true;

    @FXML
    void newAction() {
        fillGrid(null);
        setCell(3, 3, true);
        setCell(3, 4, false);
        setCell(4, 3, false);
        setCell(4, 4, true);
        player = true;
        updateStatus();
    }

    String getPlayerName(boolean player) {
        return player ? "White" : "Black";
    }


    private void updateStatus() {
        int whitePoints = countPieces(true), blackPoints = countPieces(false);
        String status = "White has " + whitePoints + " pieces, Black has " + blackPoints + " pieces.";
        if (player == null) {
            if (whitePoints > blackPoints) {
                status = status + " White won!";
            } else if (blackPoints > whitePoints) {
                status = status + " Black won!";
            } else {
                status = " It is a draw...";
            }
        } else {
            if (countPossibilities(!player) == 0) {
                status = status + getPlayerName(!player) + " must pass. ";
            }
            status = status + " " + getPlayerName(player) + "'s turn.";
        }
        statusLabel.setText(status);
    }

    private void nextPlayer() {
        if (countPossibilities(!player) > 0) {
            player = !player;
        }
        if (countPossibilities(player) == 0) {
            player = null;
        }
    }

    int countPieces(boolean player) {
        return countCellsIf((x, y) -> Boolean.valueOf(player) == getCell(x, y));
    }

    int countPossibilities(boolean player) {
        return countCellsIf((x, y) -> turnPieces(player, x, y, false) > 0);
    }


    protected boolean mouseClicked(int x, int y) {
        if (player == null ) {
            return false;
        }
        final int count = turnPieces(player, x, y, false);
        if (count > 0) {
            setCell(x, y, player);
            updateStatus();
            turnPieces(player, x, y, true);
            nextPlayer();
            updateStatus();
        }
        return true;
    }

    int turnPieces(boolean player, int x, int y, boolean reallyTurn) {
        int count = 0;
        if (getCell(x, y) == null || reallyTurn) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx != 0 || dy != 0) {
                        count = count + turnPieces(player, x + dx, y + dy, dx, dy, reallyTurn);
                    }
                }
            }
        }
        return count;
    }

    int turnPieces(boolean player, int x, int y, int dx, int dy, boolean reallyTurn) {
        int count = 0;
        while (isValidXY(x + count * dx, y + count * dy)) {
            Boolean otherCell = getCell(x + count * dx, y + count * dy);
            if (otherCell == null) {
                return 0;
            } else if (otherCell == player) {
                if (reallyTurn) {
                    for (int i = 0; i < count; i++) {
                        setCell(x + i * dx, y + i * dy, player);
                    }
                }
                return count;
            }
            count++;
        }
        return 0;
    }
}
