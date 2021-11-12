/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import net.minecraft.client.settings.KeyBinding;

public class AutoWalk
extends Module {
    public AutoWalk() {
        super("AutoWalk", "Presses the move forward key.", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        KeyBinding.func_74510_a((int)AutoWalk.mc.field_71474_y.field_74351_w.func_151463_i(), (boolean)true);
    }
}

