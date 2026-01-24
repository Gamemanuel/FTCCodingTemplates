package org.firstinspires.ftc.teamcode;

/**
 * This is an important tool to only have to update 1 file per teleop/auto.<br>
 * To use this do the following:
 * <ul>
 * <li>Make a master teleop/auto file</li>
 * <li>put all your commands in there</li>
 * <li>when it comes to alliance dependent things, use the current alliance</li>
 * </ul>
 * How to pass in alliance into master file:
 * <pre><code>
 *public class TeleOpBlue extends TeleOp {
 *     public TeleOpBlue() {
 *         super(Alliance.BLUE);
 *     }
 * }
 * </code></pre>
 * This passes in the alliance to the master teleop file.<br>
 * And then in the master file:
 * <pre><code>
 * turretSubsystem = new TurretSubsystem(hardwareMap, alliance);
 * </code></pre>
 * I pass in my alliance to my subsytems<br><br>
 * Make sure to configure your master file so that it you can pass in alliance:
 * <pre><code>
 *     public TeleOp(Alliance alliance) {
 *         this.alliance = alliance;
 *     }
 * </code></pre>
 *
 */
public enum Alliance {
    RED, BLUE, ANY
}
