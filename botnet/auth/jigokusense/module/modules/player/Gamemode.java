//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.GameType
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.module.Module;
import net.minecraft.world.GameType;

public class Gamemode
extends Module {
    public Gamemode() {
        super("Gamemode", "Fake gamemode 1.", 0, Module.Category.PLAYER);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Gamemode.mc.playerController.setGameType(GameType.CREATIVE);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Gamemode.mc.playerController.setGameType(GameType.SURVIVAL);
    }
}

