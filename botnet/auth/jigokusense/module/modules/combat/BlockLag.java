//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.util.Wrapper;

public class BlockLag
extends Module {
    public BlockLag() {
        super("Burrow", "Its just burrow in the name of blocklag.", 0, Module.Category.COMBAT);
    }

    @Override
    public void onEnable() {
        Wrapper.getPlayer().jump();
        Wrapper.getPlayer().motionY -= 1.0;
    }
}

