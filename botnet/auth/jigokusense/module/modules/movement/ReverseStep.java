//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingDouble;

public class ReverseStep
extends Module {
    SettingDouble speed = this.register("Speed", 5.0, 0.0, 20.0);

    public ReverseStep() {
        super("ReverseStep", "", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        if (ReverseStep.mc.player.isInWater() || ReverseStep.mc.player.isInLava()) {
            return;
        }
        if (ReverseStep.mc.player.onGround) {
            ReverseStep.mc.player.motionY -= this.speed.getValue() / 10.0;
        }
    }
}

