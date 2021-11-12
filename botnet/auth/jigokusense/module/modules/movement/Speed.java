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

public class Speed
extends Module {
    ArrayList<String> modes = new ArrayList();
    SettingMode mode = this.register("Mode", this.modes, "AutoSpeed");

    public Speed() {
        super("Speed", "Automatic sprints.", 0, Module.Category.MOVEMENT);
        this.modes.add("AutoSpeed");
    }

    @Override
    public void onDisable() {
        if (Speed.mc.field_71441_e != null) {
            Speed.mc.field_71439_g.func_70031_b(false);
        }
        if (this.mode.getValue().equals("AutoSpeed") && (Speed.mc.field_71474_y.field_74351_w.func_151470_d() || Speed.mc.field_71474_y.field_74368_y.func_151470_d() || Speed.mc.field_71474_y.field_74370_x.func_151470_d() || Speed.mc.field_71474_y.field_74366_z.func_151470_d()) && !Speed.mc.field_71439_g.func_70093_af() && !Speed.mc.field_71439_g.field_70123_F && !((float)Speed.mc.field_71439_g.func_71024_bL().func_75116_a() <= 6.0f)) {
            Speed.mc.field_71439_g.func_70031_b(true);
        }
        KeyBinding.func_74510_a((int)Speed.mc.field_71474_y.field_151444_V.func_151463_i(), (boolean)true);
    }
}

