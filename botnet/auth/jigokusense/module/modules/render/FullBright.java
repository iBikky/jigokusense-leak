/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.render;

import botnet.auth.jigokusense.module.Module;

public class FullBright
extends Module {
    public FullBright() {
        super("FullBright", "Turns up brightness to see in the dark.", 0, Module.Category.RENDER);
    }

    @Override
    public void update() {
        FullBright.mc.field_71474_y.field_74333_Y = 100.0f;
    }

    @Override
    public void onDisable() {
        FullBright.mc.field_71474_y.field_74333_Y = 1.0f;
    }
}

