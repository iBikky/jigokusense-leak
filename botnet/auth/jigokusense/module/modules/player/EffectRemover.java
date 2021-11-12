//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.Potion
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import java.util.Objects;
import net.minecraft.potion.Potion;

public class EffectRemover
extends Module {
    SettingBoolean levitation = this.register("Levitation", true);
    SettingBoolean jumpBoost = this.register("JumpBoost", true);

    public EffectRemover() {
        super("EffectRemover", "Removes the effects from you.", 0, Module.Category.PLAYER);
    }

    @Override
    public void update() {
        if (this.levitation.getValue() && EffectRemover.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionFromResourceLocation((String)"levitation")))) {
            EffectRemover.mc.player.removeActivePotionEffect(Potion.getPotionFromResourceLocation((String)"levitation"));
        }
        if (this.jumpBoost.getValue() && EffectRemover.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionFromResourceLocation((String)"jump_boost")))) {
            EffectRemover.mc.player.removeActivePotionEffect(Potion.getPotionFromResourceLocation((String)"jump_boost"));
        }
    }
}

