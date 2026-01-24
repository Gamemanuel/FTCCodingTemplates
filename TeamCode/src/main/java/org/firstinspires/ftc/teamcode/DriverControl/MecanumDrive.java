package org.firstinspires.ftc.teamcode.DriverControl;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

@TeleOp
public class MecanumDrive extends OpMode {
    Drivetrain drivetrain;

    @Override
    public void init() { // called once when INIT is pressed
        drivetrain = new Drivetrain(hardwareMap);

        telemetry.addData("Status", "Initialized"); // Displays this on Driver Station
        telemetry.update(); // updates the telemetry on the screen
    }

    public void start() {} // called once after ▶ is pressed

    public void loop() { // loops after ▶ is pressed
        telemetry.addData("Status", "Started");

        double leftJoyX = gamepad1.left_stick_x;
        double leftJoyY = -gamepad1.left_stick_y;
        double rightJoyX = -gamepad1.right_stick_x; // turn
        drivetrain.mecanumDrive(leftJoyX, leftJoyY, rightJoyX);

        telemetry.update();
    }
}
