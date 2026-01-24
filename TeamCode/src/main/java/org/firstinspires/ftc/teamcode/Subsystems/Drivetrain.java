package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Utils.MotorGroup;


public class Drivetrain {
    public DcMotorEx frontLeft, backLeft, frontRight, backRight;
    public MotorGroup leftSide, rightSide;
    public Imu imu;
    public Drivetrain(HardwareMap hMap) {
        // We are defining the motors here:
        // Left side of the robot
        frontLeft = hMap.get(DcMotorEx.class, "frontLeft");
        backLeft = hMap.get(DcMotorEx.class, "backLeft");
        leftSide = new MotorGroup(frontLeft,backLeft, DcMotorSimple.Direction.REVERSE);

        // Right side of the robot
        frontRight = hMap.get(DcMotorEx.class, "frontRight");
        backRight = hMap.get(DcMotorEx.class, "backRight");
        rightSide = new MotorGroup(frontRight,backRight, DcMotorSimple.Direction.FORWARD);
    }

    public void arcadeDrive(double forward, double turn) {
        leftSide.setPower(forward - turn);
        rightSide.setPower(forward + turn);
    }
    public void tankDrive(double left, double right) {
        leftSide.setPower(left);
        rightSide.setPower(right);
    }
    public void mecanumDrive(double x, double y, double turn) {
        double robotHeading = imu.getRobotHeading();

        //Rotate the movement direction counter to the bot's rotation
        double driveRotation = (x) * Math.sin(-robotHeading) + (y) * Math.cos(-robotHeading);
        double strafeRotation = (x) * Math.cos(-robotHeading) - (y) * Math.sin(-robotHeading);

        double maxMotorPower = Math.abs(driveRotation) + Math.abs(strafeRotation) + Math.abs(x);
        double denominator = Math.max(maxMotorPower, 1);
        // If this wasn't here the robot would not stay straight, it actually has some weird
        // behavior where it tries to point at the center of the field. Comment out to see.

        frontLeft.setPower((driveRotation + strafeRotation + turn) / denominator);
        frontRight.setPower((driveRotation - strafeRotation - turn) / denominator);
        backLeft.setPower((driveRotation - strafeRotation + turn) / denominator);
        backRight.setPower((driveRotation + strafeRotation - turn) / denominator);
    }
}
