package org.firstinspires.ftc.teamcode.DriverControl;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

//Made by Finch (Will)

@TeleOp
public class SixWheelDrive extends OpMode{
    Drivetrain drivetrain;
    boolean usingTankDrive = false; //easy switch between tank drive and arcade drive
    //tank drive: left_stick_y is used for forward and back for the left side, same for right_stick_y and right side
    //arcade drive: left_stick_y is used for forward and back for both sides, right_stick_x is used for turning

    public void init() { // called once when INIT is pressed
        //hardware mapping from driver hub
        drivetrain = new Drivetrain(hardwareMap);

        telemetry.addData("Status", "Initialized"); // Displays this on Driver Station
        telemetry.update(); // updates the telemetry on the screen
    }

    public void start() {} // called once after ▶ is pressed

    public void loop() { // loops after ▶ is pressed
        telemetry.addData("Status", "Started");

        // gamepad1: drivetrain gamepad
        // gamepad2: tools gamepad
        double leftJoyY = -gamepad1.left_stick_y;
        double rightJoyY = gamepad1.right_stick_y;
        double rightJoyX = gamepad1.right_stick_x;
        // if you need to reverse a control, you can just add "-" before

        if (usingTankDrive) {
            drivetrain.tankDrive(leftJoyY, rightJoyY);
            // Left joystick Y axis -> left side of drivetrain
            // Right joystick Y axis -> right side of drivetrain
        } else {
            drivetrain.arcadeDrive(leftJoyY,rightJoyX);
            // Left joystick Y axis -> drive straight
            // Right joystick X axis -> turn
        }
        telemetry.update(); // last thing you do in the loop is update telemetry
    }
}
