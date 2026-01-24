package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;

@Autonomous
public class TestDrivetrain extends LinearOpMode {

    SixWheelCMD cmd;

    @Override
    public void runOpMode() throws InterruptedException{
        waitForStart();

        while (!gamepad1.a && !isStopRequested()) {
            // watch the motors on the drive train and they should all spin forward, if they don't then you need to reverse them if
            // they don't spin at all then you need to fix the hardware issue

            // spins the all of the drivetrain motors in a positive direction
            // NOTE: they all should spin at the same power as well if they do not check the
            // voltage on the driver station and make sure the motors are configured correctly

            cmd.setMotors(1,1);


        }
        // if you press the controller button a then you stop all motors
        cmd.setMotors(0,0);
    }
}
