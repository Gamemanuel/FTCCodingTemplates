package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class SixWheelAutoTest extends LinearOpMode {
    RobotClass robot;

    @Override
    public void runOpMode() {
        robot = new RobotClass(hardwareMap);
        waitForStart();
            driveBasic(0.5, 0.5, 1000);
        sleep(1000);
            driveBasic(-0.5, -0.5, 1000);
        sleep(1000);
            driveBasic(-0.75, 0.75, 1000);
        sleep(1000);
            driveBasic(0.75, -0.75, 1000);
    }
    public void driveBasic(double left,double right,long time) { //left: left side, right: right side, time: for how long
        robot.frontLeft.setPower(left);
        robot.backLeft.setPower(left);
        robot.frontRight.setPower(right);
        robot.backRight.setPower(right);
        //set all motors
        sleep(time); //wait for however long
        robot.frontLeft.setPower(0);
        robot.backLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backRight.setPower(0);
        //stop
    }
}