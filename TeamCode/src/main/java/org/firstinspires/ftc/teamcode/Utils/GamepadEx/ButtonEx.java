package org.firstinspires.ftc.teamcode.Utils.GamepadEx;
public class ButtonEx {
    private final boolean currentInput;
    private boolean lastInput;
    /**
     * Creates a button that has extra functionality.
     * @author Will
     * @version 0.1
     */
    public ButtonEx(boolean input) {
        this.currentInput = input;
    }

    /**
     * Checks if the button is currently pressed.
     */
    public boolean pressed() {
        return currentInput;
    }

    /**
     * Checks if the button is currently released.
     */
    public boolean released() {
        return !currentInput;
    }

    /**
     * Only returns true the first time that you pressed the button.
     */
    public boolean wasJustPressed() {
        boolean check = (!lastInput && currentInput);
        lastInput = currentInput;
        return check;
    }

    /**
     * Only returns true the first time you released the button.
     */
    public boolean wasJustReleased() {
        boolean check = (lastInput && !currentInput);
        lastInput = currentInput;
        return check;
    }

    /**
     * Checks if the last check was different from the current one.
     */
    public boolean stateJustChanged() {
        boolean check = (lastInput != currentInput);
        lastInput = currentInput;
        return check;
    }

    public void periodic() {
        lastInput = currentInput;
    }
}
