package command.task;

/**
 * Created by Beka on 10.04.17.
 * This is a receiver
 */
public class GameBoard {
    public void scale(float scaleFactor) {

    }

    public void move(Direction direction, int step) {

    }

    public void create(int size) {

    }

    public void remove(int size) {

    }

    public enum Direction {
        RIGHT, LEFT, TOP, DOWN;

        public static Direction getOpposite(Direction direction) {
            switch (direction) {
                case DOWN:
                    return TOP;
                case LEFT:
                    return RIGHT;
                case RIGHT:
                    return LEFT;
                case TOP:
                    return DOWN;
            }
            return null;
        }
    }
}
