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
            URL url = getClass().getResource("/othello/white.png");
            return new Image(url.toExternalForm());
        }
    }, BLACK {
        @Override
        public Image getImage() {
            URL url = getClass().getResource("/othello/black.png");
            return new Image(url.toExternalForm());
        }
    }, EMPTY {
        @Override
        public Image getImage() {
            URL url = getClass().getResource("/othello/empty.png");
            return new Image(url.toExternalForm());
        }
    };

    public abstract Image getImage();
}
