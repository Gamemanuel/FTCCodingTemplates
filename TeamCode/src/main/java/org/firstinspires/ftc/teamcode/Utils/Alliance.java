package org.firstinspires.ftc.teamcode.Utils;

/**
 * This is an important tool to only have to update 1 file per teleop/auto.<br>
 * To use this do the following:
 * <ul>
 * <li>Make a master teleop/auto file</li>
 * <li>put all your commands in there</li>
 * <li>when it comes to alliance dependent things, use the current alliance</li>
 * </ul>
 * How to pass in alliance into master file:<br><br>
 * <small>TeleOpBlue.java</small>
 * <pre><code>
 *public class TeleOpBlue extends TeleOp {
 *     public TeleOpBlue() {
 *         super(Alliance.BLUE);
 *     }
 * }
 * </code></pre>
 * <small>TeleOp.java</small>
 * <pre><code>
 *     public TeleOp(Alliance alliance) {
 *         this.alliance = alliance;
 *     }
 * </code></pre>
 * This passes alliance into TeleOp.java (my master file)<br>
 * And then in the master file:<br><br>
 * <small>TeleOp.java</small>
 * <pre><code>
 * turretSubsystem = new TurretSubsystem(hardwareMap, alliance);
 * </code></pre>
 * I pass in my alliance to my subsystems<br><br>
 */
public enum Alliance {
    RED, BLUE, ANY
}
