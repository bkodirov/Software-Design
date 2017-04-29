package mediator.othello;

import javafx.scene.image.ImageView;
import mediator.othello.game.Position;

/**
 * Created by Beka on 28.04.17.
 */
public class Cell extends Colleague {
    private Player player = Player.EMPTY;
    private final ImageView imageView;
    private final Position position;


    public Cell(ImageView imageView, Position position) {
        this.imageView = imageView;
        this.position = position;
        imageView.setImage(player.getImage());
        System.out.println("Image set " + player.getImage());
        this.imageView.setOnMouseClicked(event -> mediator.clicked(this));
    }

    @Override
    public void changeState(Player player) {
        this.player = player;
        imageView.setImage(player.getImage());
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void clean() {
        imageView.setOnMouseClicked(null);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
