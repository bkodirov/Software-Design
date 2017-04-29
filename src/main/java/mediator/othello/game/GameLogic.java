package mediator.othello.game;

import mediator.othello.mediator.BoardMediatorImpl;
import mediator.othello.mediator.Mediator;
import mediator.othello.Player;

/**
 * Created by Beka on 28.04.17.
 */
public class GameLogic {
    private final int row;
    private final int column;
    private Mediator mediator;
    private OnGameStatusChangeListener statusChangeListener;

    public GameLogic(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setStatusChangeListener(OnGameStatusChangeListener statusChangeListener) {
        this.statusChangeListener = statusChangeListener;
    }

    private boolean isValidXY(int x, int y) {
        return x >= 0 && x < column && y >= 0 && y < row;
    }


    private Player player = Player.WHITE;

    private void updateStatus() {
        int whitePoints = countPieces(Player.WHITE), blackPoints = countPieces(Player.BLACK);
        String status = "White has " + whitePoints + " pieces, Black has " + blackPoints + " pieces.";
        if (player == Player.EMPTY) {

            if (whitePoints > blackPoints) {
                status = status + " White won!";
            } else if (blackPoints > whitePoints) {
                status = status + " Black won!";
            } else {
                status = " It is a draw... ";
            }
        } else {
            Player opposite = getOpposite(player);
            if (countPossibilities(opposite) == 0) {
                status = status + player + " must pass. ";
            }
            status = status + " " + player + "'s turn.";
        }
        statusChangeListener.onStatusChanged(status);
        System.out.println(status);
    }

    private void nextPlayer() {
        Player opposite = getOpposite(player);

        if (countPossibilities(opposite) > 0) {
            player = opposite;
        }
        if (countPossibilities(player) == 0) {
            player = Player.EMPTY;
        }
    }

    private Player getOpposite(Player player) {
        if (player == Player.WHITE) return Player.BLACK;
        else if (player == Player.BLACK) return Player.WHITE;
        return null;
    }

    int countPieces(Player player) {
        return countCellsIf((x, y) -> player == mediator.getColleague(x, y).getPlayer());
    }

    int countPossibilities(Player player) {
        return countCellsIf((x, y) -> turnPieces(player, x, y, false) > 0);
    }

    public int countCellsIf(CellFunction<Boolean> fun) {
        return countCells((x, y) -> fun.applyCell(x, y) ? 1 : 0, 0, 0, column, row);
    }

    public int countCells(CellFunction<Integer> fun, int startX, int startY, int width, int height) {
        int accum = 0;
        for (int x = startX; x < (startX + width) && x < column; x++) {
            for (int y = startY; y < (startY + height) && y < row; y++) {
                accum += fun.applyCell(x, y);
            }
        }
        return accum;
    }

    public boolean mouseClicked(int x, int y) {
        if (player == null) {
            return false;
        }
        final int count = turnPieces(player, x, y, false);
        if (count > 0) {
            mediator.updateColleague(x, y, player);
            updateStatus();
            turnPieces(player, x, y, true);
            nextPlayer();
            updateStatus();
        }
        return true;
    }


    private int turnPieces(Player player, int x, int y, boolean reallyTurn) {
        int count = 0;
        if (mediator.getColleague(x, y).getPlayer() == Player.EMPTY || reallyTurn) {
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

    private int turnPieces(Player player, int x, int y, int dx, int dy, boolean reallyTurn) {
        int count = 0;
        while (isValidXY(x + count * dx, y + count * dy)) {
            Player otherCell = mediator.getColleague(x + count * dx, y + count * dy).getPlayer();
            if (otherCell == Player.EMPTY) {
                return 0;
            } else if (otherCell == player) {
                if (reallyTurn) {
                    for (int i = 0; i < count; i++) {
                        mediator.updateColleague(x + i * dx, y + i * dy, player);
                    }
                }
                return count;
            }
            count++;
        }
        return 0;
    }

    public void setMediator(BoardMediatorImpl mediator) {
        this.mediator = mediator;
    }

    public interface OnGameStatusChangeListener{
        void onStatusChanged(String status);
    }

    // count cells
    public  interface CellFunction<T> {
        T applyCell(int x, int y);
    }
}
