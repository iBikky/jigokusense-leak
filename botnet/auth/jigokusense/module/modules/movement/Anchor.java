/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingDouble;

public class Anchor
extends Module {
    SettingDouble speed = this.register("Speed", 3.0, 0.0, 20.0);

    public Anchor() {
        super("Anchor", "", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        if (Anchor.mc.field_71439_g.func_70090_H() || Anchor.mc.field_71439_g.func_180799_ab()) {
            return;
        }
        if (Anchor.mc.field_71439_g.field_70122_E) {
            Anchor.mc.field_71439_g.field_70181_x -= this.speed.getValue() / 7.0;
        }
    }
}

