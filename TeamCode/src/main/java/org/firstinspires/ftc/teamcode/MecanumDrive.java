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
        //TODO: ALL TODOS ARE COMMENTS ARE FROM SUSHI
        //defines Robot Directories
        Robot = new RobotClass(hardwareMap);
        //TODO: Variable names should not be capitalized replace with just 'robot'. Only classes should be capitalized.
        //makes the play button appear
        waitForStart();
        while (!isStopRequested()) {
            //define basic
            double strafe = -gamepad1.left_stick_x; //must be negative
            double drive = gamepad1.right_stick_y; //TODO: the Y axis is negative, not the x axis.
            double turn = -gamepad1.left_trigger + gamepad1.right_trigger;

            robotHeading = Robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            double sumOfDrivePlusStrafePlusTurn = Math.abs(strafe) + Math.abs(drive) + Math.abs(turn); //find the max power
            double denominator = Math.max(sumOfDrivePlusStrafePlusTurn, 1); // used in making all of the powers smaller
            //TODO: calculate the sunOfDrive variable after you do the matrix rotation. It should be the last thing you calculate after you manipulate all the variables (Put these two line after line 38)
            //TODO: FIX YOUR VARIABLE NAMES sumOfDrivePlusStrafePlusTurn is unnecessarily long and only describes what it contains and not what it is used for.

            //Rotate the movement direction counter to the bot's rotation
            double driveRotation = drive * Math.cos(-robotHeading) + strafe * Math.sin(-robotHeading);
            double strafeRotation = drive * -Math.sin(-robotHeading) + strafe * Math.cos(-robotHeading);

            //TODO: driveRotation is Y AXIS should be: X_AXIS_VARIABLE (strafe) * Math.sin(-robotHeading) + Y_AXIS_VARIABLE (drive) * Math.cos(-robotHeading)
            //TODO: strafeRotation is X AXIS should be: X_AXIS_VARIABLE (strafe) * Math.cos(-robotHeading) - Y_AXIS_VARIABLE (drive) * Math.sin(-robotHeading)

            driveRotation = driveRotation * 1.1;  // Counteract imperfect strafing
            //TODO: I know they put it in the wiki but don't just throw lines of code in that you aren't sure of what they do. This only makes strafing more aggressive and
            // possibly is not useful. Write the ideal code and then correct for hardware issues; don't future proof.

            Robot.frontLeft.setPower((driveRotation + strafeRotation + turn) / denominator);
            Robot.frontRight.setPower((driveRotation - strafeRotation + turn) / denominator); // strafe is negative because of the wheels orientation
            Robot.BackLeft.setPower((driveRotation - strafeRotation - turn) / denominator);
            Robot.frontRight.setPower((driveRotation + strafeRotation - turn) / denominator);
            //TODO: YOUR CALLING frontRight TWICE. You never use backRight. Additionally, your turn variable is powering 'frontLeft' and 'frontRight' positive. think about how turning works.
            // Why is BackLeft the only one capitalized? Variable names should start with a lower case letter. Unless its a class.

        }
    }

}
