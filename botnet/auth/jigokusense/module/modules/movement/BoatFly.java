//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.util.Wrapper;

public class BoatFly
extends Module {
    public BoatFly() {
        super("BoatFly", "Make u fly high in the sky with a boat.", 0, Module.Category.MOVEMENT);
    }

    public void onUpdate() {
        if (Wrapper.mc.player.getRidingEntity() != null && Wrapper.mc.gameSettings.keyBindJump.isKeyDown()) {
            Wrapper.mc.player.getRidingEntity().motionY = 0.1;
        }
    }
}

