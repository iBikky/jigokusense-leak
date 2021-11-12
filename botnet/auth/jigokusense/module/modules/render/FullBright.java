//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.render;

import botnet.auth.jigokusense.module.Module;

public class FullBright
extends Module {
    public FullBright() {
        super("FullBright", "Turns up brightness to see in the dark.", 0, Module.Category.RENDER);
    }

    @Override
    public void update() {
        FullBright.mc.gameSettings.gammaSetting = 100.0f;
    }

    @Override
    public void onDisable() {
        FullBright.mc.gameSettings.gammaSetting = 1.0f;
    }
}

