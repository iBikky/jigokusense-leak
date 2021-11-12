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
        if (AutoRespawn.mc.field_71462_r instanceof GuiGameOver) {
            AutoRespawn.mc.field_71439_g.func_71004_bE();
            mc.func_147108_a(null);
        }
        if (this.coords.getValue() && AutoRespawn.mc.field_71462_r instanceof GuiGameOver) {
            Messages.sendClientMessage("You have died at x" + (int)AutoRespawn.mc.field_71439_g.field_70165_t + " y" + (int)AutoRespawn.mc.field_71439_g.field_70163_u + " z" + (int)AutoRespawn.mc.field_71439_g.field_70161_v);
        }
    }
}

