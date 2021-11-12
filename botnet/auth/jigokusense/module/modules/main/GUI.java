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
        mc.func_147108_a((GuiScreen)JigokuSense.instance.clickGui);
        this.toggle();
    }
}

