//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.setting.settings.SettingDouble;

public class Step
extends Module {
    SettingDouble height = this.register("Height", 2.5, 0.5, 2.0);
    SettingBoolean entity = this.register("EntityStep", false);

    public Step() {
        super("Step", "Step up blocks.", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        if (this.entity.getValue() && Step.mc.player.getRidingEntity() != null) {
            Step.mc.player.getRidingEntity().stepHeight = (float)this.height.getValue();
        }
        Step.mc.player.stepHeight = (float)this.height.getValue();
    }

    @Override
    public void onDisable() {
        Step.mc.player.stepHeight = 0.5f;
    }
}

