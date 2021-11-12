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

public class Sprint
extends Module {
    ArrayList<String> modes = new ArrayList();
    SettingMode mode = this.register("Mode", this.modes, "Rage");

    public Sprint() {
        super("Sprint", "Automatic sprints.", 0, Module.Category.MOVEMENT);
        this.modes.add("Legit");
        this.modes.add("Rage");
    }

    @Override
    public void onDisable() {
        if (Sprint.mc.world != null) {
            Sprint.mc.player.setSprinting(false);
        }
    }

    @Override
    public void update() {
        if (this.mode.getValue().equals("Legit") && Sprint.mc.gameSettings.keyBindForward.isKeyDown() && !Sprint.mc.player.isSneaking() && !Sprint.mc.player.isHandActive() && !Sprint.mc.player.collidedHorizontally && Sprint.mc.currentScreen == null && !((float)Sprint.mc.player.getFoodStats().getFoodLevel() <= 6.0f)) {
            Sprint.mc.player.setSprinting(true);
        }
        if (this.mode.getValue().equals("Rage") && (Sprint.mc.gameSettings.keyBindForward.isKeyDown() || Sprint.mc.gameSettings.keyBindBack.isKeyDown() || Sprint.mc.gameSettings.keyBindLeft.isKeyDown() || Sprint.mc.gameSettings.keyBindRight.isKeyDown()) && !Sprint.mc.player.isSneaking() && !Sprint.mc.player.collidedHorizontally && !((float)Sprint.mc.player.getFoodStats().getFoodLevel() <= 6.0f)) {
            Sprint.mc.player.setSprinting(true);
        }
        KeyBinding.setKeyBindState((int)Sprint.mc.gameSettings.keyBindSprint.getKeyCode(), (boolean)true);
    }
}

