package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class MecanumDrive extends LinearOpMode {
    RobotClass Robot;

    double robotHeading;

    @Override
    public void runOpMode() throws InterruptedException {
        //defines Robot Directories
        Robot = new RobotClass(hardwareMap);
        // makes the play button appear
        waitForStart();
        while (!isStopRequested()) {
            //define basic
            double strafe = -gamepad1.left_stick_x; //must be negative
            double drive = gamepad1.right_stick_y;
            double turn = -gamepad1.left_trigger + gamepad1.right_trigger;

            robotHeading = Robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            double sumOfDrivePlusStrafePlusTurn = Math.abs(strafe) + Math.abs(drive) + Math.abs(turn); //find the max power
            double denominator = Math.max(sumOfDrivePlusStrafePlusTurn, 1); // used in making all of the powers smaller

            // Rotate the movement direction counter to the bot's rotation
            double driveRotation = drive * Math.cos(-robotHeading) + strafe * Math.sin(-robotHeading);
            double strafeRotation = drive * -Math.sin(-robotHeading) + strafe * Math.cos(-robotHeading);

            driveRotation = driveRotation * 1.1;  // Counteract imperfect strafing
            //you calculate this after you denominator leading to > 1 power

            // defines motors for use
            Robot.frontLeft.setPower((driveRotation + strafeRotation + turn) / denominator);
            Robot.frontRight.setPower((driveRotation - strafeRotation + turn) / denominator); // strafe is negative because of the wheels orientation
            Robot.BackLeft.setPower((driveRotation - strafeRotation - turn) / denominator);
            Robot.frontRight.setPower((driveRotation + strafeRotation - turn) / denominator);

        }
    }

}
