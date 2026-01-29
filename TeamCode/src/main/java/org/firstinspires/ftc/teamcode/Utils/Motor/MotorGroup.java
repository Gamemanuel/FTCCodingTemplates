package org.firstinspires.ftc.teamcode.Utils.Motor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MotorGroup {

    // defines the motors that we use locally and are instated when we call the class.
    private final DcMotorEx Leader;
    private final DcMotorEx Follower;
    private positionType positionType = org.firstinspires.ftc.teamcode.Utils.Motor.positionType.LEADER;

    /**
     * Creates a motor group with the leader and follower motors that preform the same action as the
     * leader<br>
     * <b>NOTE:</b> only use motor groups with a six-wheel drivetrain. Using it with mecanum would
     * get rid of the whole point of mecanum: strafing
     *
     * @author Will (v1 and v3) and Gavin (v2)
     * @version 3
     * @param leader The 1st motor in the motor group we set this one
     * @param follower This is the 2nd motor in the group and it follows the actions of the leader
     */
    public MotorGroup(
            DcMotorEx leader,
            DcMotorEx follower,
            DcMotorEx.Direction leaderDirection,
            DcMotorSimple.Direction followerDirection
    ) {
        this.Leader = leader;
        this.Follower = follower;
        leader.setDirection(leaderDirection);
        follower.setDirection(followerDirection);
    }

    /**
     * Sets the power of the MotorGroup.
     *
     * @author Will (v1) with edits by Gavin (v2)
     * @version 1
     * @param power On a range of -1 to 1 how much power you give it.
     *
     */
    public void setPower(double power) {
        Leader.setPower(power);
        Follower.setPower(power);
    }

    /**
     * Gets the power of the MotorGroup through the Leader.
     *
     * @author Will (v1) with edits by Gavin (v2)
     * @version 1
     *
     */
    public double getPower() { return Leader.getPower(); }

    /**
     * Sets the RunMode of the MotorGroup
     * @param mode The specific mode for the motors
     */
    public void setMode(DcMotor.RunMode mode) {
        Leader.setMode(mode);
        Follower.setMode(mode);
    }

    /**
     * Sets the behavior for how MotorGroup gets encoder position.
     * @see positionType
     */
    public void setPositionType(positionType type) {
        positionType = type;
    }

    /**
     * @return The position of the MotorGroup. Dependent on {@link positionType}.
     */
    public double getPosition() {
        if (positionType == org.firstinspires.ftc.teamcode.Utils.Motor.positionType.AVERAGE) {
            return (Leader.getCurrentPosition() + Follower.getCurrentPosition()) * 0.5;
        } else if (positionType == org.firstinspires.ftc.teamcode.Utils.Motor.positionType.LEADER) {
            return Leader.getCurrentPosition();
        } else if (positionType == org.firstinspires.ftc.teamcode.Utils.Motor.positionType.FOLLOWER) {
            return Follower.getCurrentPosition();
        } else {
            return 0;
        }
    }
}
