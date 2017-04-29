package mediator.othello.mediator;

import mediator.othello.Player;
import mediator.othello.game.GameLogic;
import mediator.othello.game.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beka on 28.04.17.
 */
public class BoardMediatorImpl implements Mediator {
    private final List<Colleague> colleagueList = new ArrayList<>();
    private final GameLogic gameLogic;

    public BoardMediatorImpl(GameLogic  gameLogic, List<Colleague> colleagues) {
        this.gameLogic = gameLogic;
        for (Colleague colleague : colleagues) {
            colleague.setMediator(this);
        }
        colleagueList.addAll(colleagues);
        gameLogic.setMediator(this);
        updateColleague(3,3, Player.WHITE);
        updateColleague(3,4,Player.BLACK);
        updateColleague(4,3,Player.BLACK);
        updateColleague(4,4,Player.WHITE);
    }

    @Override
    public void addCell(Colleague colleague) {
        colleagueList.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    public void clicked(Colleague colleague) {
        gameLogic.mouseClicked(colleague.getPosition().getX(),colleague.getPosition().getY());
    }

    @Override
    public void clear() {
        for (Colleague colleague : colleagueList) {
            colleague.clean();
        }
    }

    @Override
    public void updateColleague(int x, int y, Player player) {
        Position position=new Position(x,y);
        for (Colleague colleague : colleagueList) {
            if (colleague.getPosition().equals(position)){
                colleague.changeState(player);
                break;
            }
        }
    }

    @Override
    public Colleague getColleague(int x, int y) {
        Position position=new Position(x,y);
        for (Colleague colleague : colleagueList) {
            if (colleague.getPosition().equals(position))return colleague;
        }
        return null;
    }
}
