package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class SixWheelAutoTest extends LinearOpMode { //TODO: no matter the configuration, the motors go brrr clackclackclackclackclack
    RobotClass robot;

    @Override
    public void runOpMode() {
        robot = new RobotClass(hardwareMap);
        waitForStart();
        while (!isStopRequested()) {
            driveBasic(0.75, 0.75, 1);
            driveBasic(-0.75, -0.75, 1);
            driveBasic(0.75, -0.75, 1);
            driveBasic(-0.75, 0.75, 1);
        }
    }
    public void driveBasic(double left,double right,long time) { //left: left side, right: right side, time: for how long
        robot.frontLeft.setPower(left);
        robot.backLeft.setPower(left);
        robot.frontRight.setPower(right);
        robot.backRight.setPower(-right);
        //set all motors
        sleep(time); //wait for however long
        robot.frontLeft.setPower(0);
        robot.backLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.backRight.setPower(0);
        //stop
    }
}