package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.MecanumCMD;

@Autonomous
public class MecanumAutoTest extends LinearOpMode {
    MecanumCMD cmd;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        cmd.moveAtAngle(0.5, 0, 1000); // straight forward
        sleep(1000); //sleep makes the program pause whatever its doing for the specified milliseconds
        cmd.moveAtAngle(0.5, 180, 1000); // straight backward
        sleep(1000); //1000 milliseconds : 1 second
        cmd.moveAtAngle(0.5, 90, 1000); // strafe right
        sleep(1000);
        cmd.moveAtAngle(-0.5, 90, 1000); // strafe left
    }
}