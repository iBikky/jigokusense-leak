/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemExpBottle
 */
package botnet.auth.jigokusense.module.modules.misc;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;

public class FastPlace
extends Module {
    SettingBoolean everything = this.register("Everything", false);
    SettingBoolean blocks = this.register("Blocks", false);
    SettingBoolean crystals = this.register("Crystals", false);
    SettingBoolean exp = this.register("Exp", false);

    public FastPlace() {
        super("FastPlace", "", 0, Module.Category.MISC);
    }

    @Override
    public void update() {
        if (this.everything.getValue()) {
            FastPlace.mc.field_71467_ac = 0;
        }
        if (this.exp.getValue() && FastPlace.mc.field_71439_g.func_184614_ca().func_77973_b() instanceof ItemExpBottle || FastPlace.mc.field_71439_g.func_184592_cb().func_77973_b() instanceof ItemExpBottle) {
            FastPlace.mc.field_71467_ac = 0;
        }
        if (this.blocks.getValue() && FastPlace.mc.field_71439_g.func_184614_ca().func_77973_b() instanceof ItemBlock || FastPlace.mc.field_71439_g.func_184592_cb().func_77973_b() instanceof ItemBlock) {
            FastPlace.mc.field_71467_ac = 0;
        }
        if (this.crystals.getValue() && FastPlace.mc.field_71439_g.func_184614_ca().func_77973_b() instanceof ItemEndCrystal || FastPlace.mc.field_71439_g.func_184592_cb().func_77973_b() instanceof ItemEndCrystal) {
            FastPlace.mc.field_71467_ac = 0;
        }
    }
}

