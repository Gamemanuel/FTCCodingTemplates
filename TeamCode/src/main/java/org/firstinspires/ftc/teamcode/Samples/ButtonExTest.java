package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Utils.GamepadEx.ButtonEx;
import org.firstinspires.ftc.teamcode.Utils.GamepadEx.GamepadEx;

public class ButtonExTest extends OpMode {
    GamepadEx gamepadEx;
    ButtonEx A;

    public void init() {
        gamepadEx = new GamepadEx();
        gamepadEx.buttons.add(A = new ButtonEx(gamepad1.a));
    }

    public void loop() {
        telemetry.addData("Pressed", A.pressed());
        telemetry.addData("Released", A.released());
        telemetry.addData("Was just pressed", A.wasJustPressed());
        telemetry.addData("Was just released", A.wasJustReleased());
        telemetry.addData("State just changed", A.stateJustChanged());

        telemetry.update();

        gamepadEx.update();
    }
}
