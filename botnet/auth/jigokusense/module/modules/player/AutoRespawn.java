//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.command.Messages;
import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import net.minecraft.client.gui.GuiGameOver;

public class AutoRespawn
extends Module {
    SettingBoolean coords = this.register("DeathCoords", true);

    public AutoRespawn() {
        super("AutoRespawn", "Removes the death screen.", 0, Module.Category.PLAYER);
    }

    @Override
    public void update() {
        super.update();
        if (AutoRespawn.mc.currentScreen instanceof GuiGameOver) {
            AutoRespawn.mc.player.respawnPlayer();
            mc.displayGuiScreen(null);
        }
        if (this.coords.getValue() && AutoRespawn.mc.currentScreen instanceof GuiGameOver) {
            Messages.sendClientMessage("You have died at x" + (int)AutoRespawn.mc.player.posX + " y" + (int)AutoRespawn.mc.player.posY + " z" + (int)AutoRespawn.mc.player.posZ);
        }
    }
}

