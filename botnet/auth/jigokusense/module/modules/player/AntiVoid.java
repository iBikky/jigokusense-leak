//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.module.Module;

public class AntiVoid
extends Module {
    public AntiVoid() {
        super("AntiVoid", "", 0, Module.Category.PLAYER);
    }

    @Override
    public void update() {
        if (AntiVoid.mc.player.posY <= 0.5) {
            AntiVoid.mc.player.moveVertical = 10.0f;
            AntiVoid.mc.player.jump();
        } else {
            AntiVoid.mc.player.moveVertical = 0.0f;
        }
    }

    @Override
    public void onDisable() {
        AntiVoid.mc.player.moveVertical = 0.0f;
    }
}

