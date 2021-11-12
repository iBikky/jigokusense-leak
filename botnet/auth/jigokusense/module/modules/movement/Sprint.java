/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingMode;
import java.util.ArrayList;
import net.minecraft.client.settings.KeyBinding;

public class Sprint
extends Module {
    ArrayList<String> modes = new ArrayList();
    SettingMode mode = this.register("Mode", this.modes, "Rage");

    public Sprint() {
        super("Sprint", "Automatic sprints.", 0, Module.Category.MOVEMENT);
        this.modes.add("Legit");
        this.modes.add("Rage");
    }

    @Override
    public void onDisable() {
        if (Sprint.mc.field_71441_e != null) {
            Sprint.mc.field_71439_g.func_70031_b(false);
        }
    }

    @Override
    public void update() {
        if (this.mode.getValue().equals("Legit") && Sprint.mc.field_71474_y.field_74351_w.func_151470_d() && !Sprint.mc.field_71439_g.func_70093_af() && !Sprint.mc.field_71439_g.func_184587_cr() && !Sprint.mc.field_71439_g.field_70123_F && Sprint.mc.field_71462_r == null && !((float)Sprint.mc.field_71439_g.func_71024_bL().func_75116_a() <= 6.0f)) {
            Sprint.mc.field_71439_g.func_70031_b(true);
        }
        if (this.mode.getValue().equals("Rage") && (Sprint.mc.field_71474_y.field_74351_w.func_151470_d() || Sprint.mc.field_71474_y.field_74368_y.func_151470_d() || Sprint.mc.field_71474_y.field_74370_x.func_151470_d() || Sprint.mc.field_71474_y.field_74366_z.func_151470_d()) && !Sprint.mc.field_71439_g.func_70093_af() && !Sprint.mc.field_71439_g.field_70123_F && !((float)Sprint.mc.field_71439_g.func_71024_bL().func_75116_a() <= 6.0f)) {
            Sprint.mc.field_71439_g.func_70031_b(true);
        }
        KeyBinding.func_74510_a((int)Sprint.mc.field_71474_y.field_151444_V.func_151463_i(), (boolean)true);
    }
}

