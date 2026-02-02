package org.firstinspires.ftc.teamcode.Utils.Motor;

/**
 * How you get the position of the MotorGroup. Defaults to <code>LEADER</code>. In other words,
 * the behavior of how the MotorGroup gets its encoder position.
 *
 * @Types: <code>AVERAGE</code>: Gets the average between both motors. Remember to plug in the
 * encoder wires into both the motors.<br>
 * <code>LEADER</code>: Gets the position of the Leader.<br>
 * <code>FOLLOWER</code>: Gets the position of the Follower
 */
public enum PositionType {
        AVERAGE, LEADER, FOLLOWER
}
