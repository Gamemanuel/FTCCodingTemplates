package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;

@Autonomous
public class SixWheelAutoTest extends LinearOpMode {
    SixWheelCMD cmd;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        cmd.driveBasic(0.5, 0.5, 1000); //both sides are moving forward: move forward
        sleep(1000); //sleep makes the program pause whatever its doing for the specified milliseconds
        cmd.driveBasic(-0.5, -0.5, 1000); //both sides are moving backward: move backward
        sleep(1000); //1000 milliseconds : 1 second
        //both sides are moving in a different way: turn
        cmd.driveBasic(-0.75, 0.75, 1000); //left side is going backward: turn left (counterclockwise)
        sleep(1000);
        cmd.driveBasic(0.75, -0.75, 1000); //right side is going backward: turn right (clockwise)
    }
}