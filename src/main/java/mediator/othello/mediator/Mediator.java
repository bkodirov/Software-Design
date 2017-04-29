package mediator.othello.mediator;

import mediator.othello.Player;

/**
 * Created by Beka on 28.04.17.
 */
public interface Mediator {
    void addCell(Colleague cell);
    void clicked(Colleague colleague);
    void clear();

    void updateColleague(int x, int y, Player player);

    Colleague getColleague(int x, int y);
}
