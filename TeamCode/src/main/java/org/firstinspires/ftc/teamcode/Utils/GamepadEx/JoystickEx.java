package org.firstinspires.ftc.teamcode.Utils.GamepadEx;

/**
 * Upgraded joystick commands
 */
public class JoystickEx {

    double joystickAxis;

    /**
     * Sets the JoystickEx
     * @param joystickAxis The axis you want
     */
    public JoystickEx(double joystickAxis) { this.joystickAxis = joystickAxis; }
    double joystickXAxis;
    double joystickYAxis;

    /**
     * Sets the JoystickEx<br>
     * This one specifically is if you want to check a whole joystick instead of one axis<hr>
     * @param joystickXAxis The X axis of the joystick
     * @param joystickYAxis The Y axis of the joystick
     */
    public JoystickEx(double joystickXAxis, double joystickYAxis) {
        this.joystickXAxis = joystickXAxis;
        this.joystickYAxis = joystickYAxis;
    }
    double deadzone = 0;

    /**
     * Sets a deadzone for the joystick<br>
     * <b>Deadzone:</b> The minimum amount of input for it to register. Useful for controllers suffering from stick
     * drift or if accidental inputs are common.<hr>
     * All methods in this class that return data account for the deadzone.<hr>
     * @param deadzone What you want to set the deadzone to (range from 0-1). A typical deadzone will be around 0.15.
     */
    public void setDeadzone(double deadzone) { this.deadzone = deadzone; }

    /**
     * Helper function for deadzones
     * @param value value that you want to input
     * @return input; unless it's in the deadzone, then retuns 0.
     */
    private double accountDeadzone(double value) {
        if (Math.abs(value) < deadzone) {
            return 0;
        } else {
            return value;
        }
    }

    /**
     * Returns the input. This one is <b>ONLY</b> works if you set only a single axis.
     */
    public double get() {
        if (joystickAxis < Math.abs(deadzone)) {
            return 0;
        } else {
            return joystickAxis;
        }
    }

    /**
     * @return the coordinates of the joystick: {x, y}
     */
    public double[] getCoordinates() {
        return new double[] { accountDeadzone(joystickXAxis), accountDeadzone(joystickYAxis) };
    }

    /**
     * @return the angle (in radians) the controller is at
     */
    public double getAngle() { return Math.atan2(accountDeadzone(joystickYAxis),accountDeadzone(joystickXAxis)); }
    public double getAngleDeg() {
        return Math.atan2(accountDeadzone(joystickYAxis),accountDeadzone(joystickXAxis)) * 180/Math.PI;
    }
}
