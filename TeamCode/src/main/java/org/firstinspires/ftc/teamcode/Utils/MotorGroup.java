package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.DcMotorEx;
public class MotorGroup {

    // defines the motors that we use locally and are instated when we call the class.
    private final DcMotorEx Leader;
    private final DcMotorEx Follower;

    /**
     * Creates a motor group with the leader and follower motors that preform the same action as the leader<br>
     * <b>NOTE:</b> only use motor groups with a six-wheel drivetrain. Using it with mecanum would get rid of the whole point of mecanum: strafing
     *
     * @author Will (v1) with edits by Gavin (v2)
     * @version 2
     * @param leader The 1st motor in the motor group we set this one
     * @param follower This is the 2nd motor in the group and it follows the actions of the leader
     *
     */
    public MotorGroup(DcMotorEx leader, DcMotorEx follower, DcMotorEx.Direction direction) {
        this.Leader = leader;
        this.Follower = follower;
        leader.setDirection(direction);
        follower.setDirection(direction);
    }

    /**
     * Sets the power of the MotorGroup.
     *
     * @author Will (v1) with edits by Gavin (v2)
     * @version 1
     * @param power This is the power that you want the motor to go. can be -1 to 1 and this will set the power of both motors
     *
     */
    public void setPower(double power) {
        Leader.setPower(power);
        Follower.setPower(power);
    }

    /**
     * gets the power of the MotorGroup through the Leader power.
     *
     * @author Will (v1) with edits by Gavin (v2)
     * @version 1
     *
     */
    public double getPower() {
        return Leader.getPower();
    }

}
