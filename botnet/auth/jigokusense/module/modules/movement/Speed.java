//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingMode;
import java.util.ArrayList;
import net.minecraft.client.settings.KeyBinding;

public class Speed
extends Module {
    ArrayList<String> modes = new ArrayList();
    SettingMode mode = this.register("Mode", this.modes, "AutoSpeed");

    public Speed() {
        super("Speed", "Automatic sprints.", 0, Module.Category.MOVEMENT);
        this.modes.add("AutoSpeed");
    }

    @Override
    public void onDisable() {
        if (Speed.mc.world != null) {
            Speed.mc.player.setSprinting(false);
        }
        if (this.mode.getValue().equals("AutoSpeed") && (Speed.mc.gameSettings.keyBindForward.isKeyDown() || Speed.mc.gameSettings.keyBindBack.isKeyDown() || Speed.mc.gameSettings.keyBindLeft.isKeyDown() || Speed.mc.gameSettings.keyBindRight.isKeyDown()) && !Speed.mc.player.isSneaking() && !Speed.mc.player.collidedHorizontally && !((float)Speed.mc.player.getFoodStats().getFoodLevel() <= 6.0f)) {
            Speed.mc.player.setSprinting(true);
        }
        KeyBinding.setKeyBindState((int)Speed.mc.gameSettings.keyBindSprint.getKeyCode(), (boolean)true);
    }
}

