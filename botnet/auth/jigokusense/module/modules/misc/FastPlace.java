//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
            FastPlace.mc.rightClickDelayTimer = 0;
        }
        if (this.exp.getValue() && FastPlace.mc.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle || FastPlace.mc.player.getHeldItemOffhand().getItem() instanceof ItemExpBottle) {
            FastPlace.mc.rightClickDelayTimer = 0;
        }
        if (this.blocks.getValue() && FastPlace.mc.player.getHeldItemMainhand().getItem() instanceof ItemBlock || FastPlace.mc.player.getHeldItemOffhand().getItem() instanceof ItemBlock) {
            FastPlace.mc.rightClickDelayTimer = 0;
        }
        if (this.crystals.getValue() && FastPlace.mc.player.getHeldItemMainhand().getItem() instanceof ItemEndCrystal || FastPlace.mc.player.getHeldItemOffhand().getItem() instanceof ItemEndCrystal) {
            FastPlace.mc.rightClickDelayTimer = 0;
        }
    }
}

