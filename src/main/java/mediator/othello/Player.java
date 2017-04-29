package mediator.othello;

import javafx.scene.image.Image;

import java.net.URL;

/**
 * Created by Beka on 28.04.17.
 */
public enum Player {
    WHITE {
        @Override
        public Image getImage() {
            URL url = getClass().getResource("/reversi/white.png");
            return new Image(url.toExternalForm());
        }
    }, BLACK {
        @Override
        public Image getImage() {
            URL url = getClass().getResource("/reversi/black.png");
            return new Image(url.toExternalForm());
        }
    }, EMPTY {
        @Override
        public Image getImage() {
            URL url = getClass().getResource("/reversi/empty.png");
            return new Image(url.toExternalForm());
        }
    };

    public abstract Image getImage();
}
