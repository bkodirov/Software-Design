package state;

/**
 * Created by Beka on 17.04.17.
 */
public interface IState {
    void onRight();

    void onLeft();

    void onBrake();

    void onAccel();
}
