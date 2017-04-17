package state;

/**
 * Created by Beka on 17.04.17.
 */
public class GravelState implements IState {
    private UiController uiController;

    public GravelState(UiController uiController) {
        this.uiController = uiController;
    }

    @Override
    public void onRight() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Right, 5");
    }

    @Override
    public void onLeft() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Left, 5");
    }

    @Override
    public void onBrake() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Brake, 8");
    }

    @Override
    public void onAccel() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Accelerate, 9");
    }
}
