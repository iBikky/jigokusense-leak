/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.setting.settings.SettingDouble;

public class Step
extends Module {
    SettingDouble height = this.register("Height", 2.5, 0.5, 2.0);
    SettingBoolean entity = this.register("EntityStep", false);

    public Step() {
        super("Step", "Step up blocks.", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        if (this.entity.getValue() && Step.mc.field_71439_g.func_184187_bx() != null) {
            Step.mc.field_71439_g.func_184187_bx().field_70138_W = (float)this.height.getValue();
        }
        Step.mc.field_71439_g.field_70138_W = (float)this.height.getValue();
    }

    @Override
    public void onDisable() {
        Step.mc.field_71439_g.field_70138_W = 0.5f;
    }
}

