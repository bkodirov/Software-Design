package state;

/**
 * Created by Beka on 17.04.17.
 */
public class WetState implements IState {
    private UiController uiController;

    public WetState(UiController uiController) {
        this.uiController = uiController;
    }

    @Override
    public void onRight() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Right, 4");
    }

    @Override
    public void onLeft() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Right, 4");
    }

    @Override
    public void onBrake() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Right, 7");
    }

    @Override
    public void onAccel() {
        uiController.setTitle("Condition is " + getClass().getSimpleName() + ", Accelerate, 9");
    }
}
