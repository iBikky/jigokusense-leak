//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package botnet.auth.jigokusense.module.modules.main;

import botnet.auth.jigokusense.JigokuSense;
import botnet.auth.jigokusense.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class GUI
extends Module {
    public GUI() {
        super("GUI", "Displays Gui screen.", 54, Module.Category.MAIN);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen((GuiScreen)JigokuSense.instance.clickGui);
        this.toggle();
    }
}

