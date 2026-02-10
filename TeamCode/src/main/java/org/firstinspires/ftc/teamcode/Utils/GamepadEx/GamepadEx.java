package org.firstinspires.ftc.teamcode.Utils.GamepadEx;

import java.util.ArrayList;
import java.util.List;

public class GamepadEx {
    public List<ButtonEx> buttons = new ArrayList<>();

    public void update() {
        for (ButtonEx button : buttons) {
            button.periodic();
        }
    }
}
