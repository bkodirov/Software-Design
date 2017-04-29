package mediator.othello.mediator;

import mediator.othello.Player;
import mediator.othello.game.Position;

/**
 * Created by Beka on 28.04.17.
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void changeState(Player player);

    public abstract Player getPlayer();

    public abstract void clean();

    public abstract Position getPosition();
}
