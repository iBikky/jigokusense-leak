//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingDouble;

public class Anchor
extends Module {
    SettingDouble speed = this.register("Speed", 3.0, 0.0, 20.0);

    public Anchor() {
        super("Anchor", "", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        if (Anchor.mc.player.isInWater() || Anchor.mc.player.isInLava()) {
            return;
        }
        if (Anchor.mc.player.onGround) {
            Anchor.mc.player.motionY -= this.speed.getValue() / 7.0;
        }
    }
}

