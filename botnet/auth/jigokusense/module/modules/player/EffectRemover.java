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
        if (this.levitation.getValue() && EffectRemover.mc.field_71439_g.func_70644_a(Objects.requireNonNull(Potion.func_180142_b((String)"levitation")))) {
            EffectRemover.mc.field_71439_g.func_184596_c(Potion.func_180142_b((String)"levitation"));
        }
        if (this.jumpBoost.getValue() && EffectRemover.mc.field_71439_g.func_70644_a(Objects.requireNonNull(Potion.func_180142_b((String)"jump_boost")))) {
            EffectRemover.mc.field_71439_g.func_184596_c(Potion.func_180142_b((String)"jump_boost"));
        }
    }
}

