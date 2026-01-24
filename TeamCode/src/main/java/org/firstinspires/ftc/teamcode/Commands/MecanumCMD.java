package org.firstinspires.ftc.teamcode.Commands;

import static java.lang.Thread.sleep;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class MecanumCMD {

    Drivetrain drivetrain;

    /**
     * A basic command that sets the motors to a specified power. Beware that it won't stop until said to.
     *
     * @Creator: Will (Finch)
     *
     * @param frontLeft
     * @param frontRight
     * @param backLeft
     * @param backRight
     */
    public void setMotors(double frontLeft, double frontRight, double backLeft, double backRight) {
        drivetrain.frontLeft.setPower(frontLeft);
        drivetrain.frontRight.setPower(frontRight);
        drivetrain.backLeft.setPower(backLeft);
        drivetrain.backRight.setPower(backRight);
    }

    /**
     * Moves at an angle without changing orientation. See <a href="https://www.desmos.com/calculator/5ojthrrdf7">Controller angles</a>
     * @param power Power of motors
     * @param degrees Direction in degrees
     * @param time For how long
     * @Author: Will (Finch)
     */
    public void moveAtAngle(double power, double degrees, long time) throws InterruptedException {
        double rad = Math.toRadians(degrees); // convert to rad cause math likes them

        double x = Math.cos(rad);
        double y = Math.sin(rad);
        // see https://www.desmos.com/calculator/5ojthrrdf7

        setMotors(
            (y + x) * power,
            (y - x) * power,
            (y - x) * power,
            (y + x) * power
        );

        sleep(time);

        setMotors(0, 0, 0, 0);
    }
}
