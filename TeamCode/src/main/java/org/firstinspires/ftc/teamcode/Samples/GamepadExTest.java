package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Utils.GamepadEx.ButtonEx;
import org.firstinspires.ftc.teamcode.Utils.GamepadEx.GamepadEx;
import org.firstinspires.ftc.teamcode.Utils.GamepadEx.JoystickEx;

public class GamepadExTest extends OpMode {
    GamepadEx gamepadEx;
    ButtonEx A;
    JoystickEx leftJoystick;

    public void init() {
        gamepadEx = new GamepadEx();
        gamepadEx.buttons.add(A = new ButtonEx(gamepad1.a));

        leftJoystick = new JoystickEx(gamepad1.left_stick_x, gamepad1.left_stick_y);
        leftJoystick.setDeadzone(.15);
    }

    public void loop() {
        telemetry.addLine("Button A:");
        telemetry.addData("    Pressed", A.pressed());
        telemetry.addData("    Released", A.released());
        telemetry.addData("    Was just pressed", A.wasJustPressed());
        telemetry.addData("    Was just released", A.wasJustReleased());
        telemetry.addData("    State just changed", A.stateJustChanged());

        telemetry.addLine("Left Joystick:");
        telemetry.addData("    Left joystick coordinates", leftJoystick.getCoordinates());
        telemetry.addData("    Left joytick angle (degrees)", leftJoystick.getAngleDeg());

        telemetry.update();

        gamepadEx.update();
    }
}
