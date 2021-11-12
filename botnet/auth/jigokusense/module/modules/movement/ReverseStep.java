/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingDouble;

public class ReverseStep
extends Module {
    SettingDouble speed = this.register("Speed", 5.0, 0.0, 20.0);

    public ReverseStep() {
        super("ReverseStep", "", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        if (ReverseStep.mc.field_71439_g.func_70090_H() || ReverseStep.mc.field_71439_g.func_180799_ab()) {
            return;
        }
        if (ReverseStep.mc.field_71439_g.field_70122_E) {
            ReverseStep.mc.field_71439_g.field_70181_x -= this.speed.getValue() / 10.0;
        }
    }
}

