/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.module.Module;

public class AntiVoid
extends Module {
    public AntiVoid() {
        super("AntiVoid", "", 0, Module.Category.PLAYER);
    }

    @Override
    public void update() {
        if (AntiVoid.mc.field_71439_g.field_70163_u <= 0.5) {
            AntiVoid.mc.field_71439_g.field_70701_bs = 10.0f;
            AntiVoid.mc.field_71439_g.func_70664_aZ();
        } else {
            AntiVoid.mc.field_71439_g.field_70701_bs = 0.0f;
        }
    }

    @Override
    public void onDisable() {
        AntiVoid.mc.field_71439_g.field_70701_bs = 0.0f;
    }
}

