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
        //TODO: Variable names should not be capitalized replace 'Robot' with just 'robot'. Only classes should be capitalized.
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
            //TODO: calculate the denominator after you do the matrix rotation. It should be the last thing you calculate after you manipulate all the variables (Put these two line after line 38)
            //TODO: FIX YOUR VARIABLE NAMES sumOfDrivePlusStrafePlusTurn is an intermediate variable and can definitely be shortened to just 'maxMotorPower' or something.
            // Naming variables should help describe what they are used for not just what they contain. I can see that it is the sunOfDrivePlusStrafePlusTurn but why is that?

            //Rotate the movement direction counter to the bot's rotation
            double driveRotation = drive * Math.cos(-robotHeading) + strafe * Math.sin(-robotHeading);
            double strafeRotation = drive * -Math.sin(-robotHeading) + strafe * Math.cos(-robotHeading);

            //TODO: driveRotation is the Y AXIS and should be: X_AXIS_VARIABLE (strafe) * Math.sin(-robotHeading) + Y_AXIS_VARIABLE (drive) * Math.cos(-robotHeading)
            //TODO: strafeRotation is the X AXIS and should be: X_AXIS_VARIABLE (strafe) * Math.cos(-robotHeading) - Y_AXIS_VARIABLE (drive) * Math.sin(-robotHeading)

            driveRotation = driveRotation * 1.1;  // Counteract imperfect strafing
            //TODO: I know they put it in the wiki but don't just throw lines of code in that you aren't sure of what they do.
            // The intended purpose is to make strafing more aggressive to adjust for the increased motor friction when strafing.
            // but your code is adjusting the Y-AXIS power which is not helpful. Try to understand what code is intended for before implementing, with some exceptions of course.

            Robot.frontLeft.setPower((driveRotation + strafeRotation + turn) / denominator);
            Robot.frontRight.setPower((driveRotation - strafeRotation + turn) / denominator); // strafe is negative because of the wheels orientation
            Robot.BackLeft.setPower((driveRotation - strafeRotation - turn) / denominator);
            Robot.frontRight.setPower((driveRotation + strafeRotation - turn) / denominator);
            //TODO: YOUR CALLING frontRight TWICE. You never use backRight. Additionally, your 'turn' variable is powering 'frontLeft' and 'frontRight' positive. think about how turning works.
            // Why is BackLeft the only one capitalized? Variable names should start with a lower case letter. Unless its a class.

        }
    }

}
