//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.JigokuSense;
import botnet.auth.jigokusense.gui.BooleanComponent;
import botnet.auth.jigokusense.gui.IComponent;
import botnet.auth.jigokusense.gui.KeybindComponent;
import botnet.auth.jigokusense.gui.ModeComponent;
import botnet.auth.jigokusense.gui.ModuleComponent;
import botnet.auth.jigokusense.gui.PanelComponent;
import botnet.auth.jigokusense.gui.SliderDouble;
import botnet.auth.jigokusense.gui.SliderInteger;
import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.setting.settings.SettingDouble;
import botnet.auth.jigokusense.setting.settings.SettingInteger;
import botnet.auth.jigokusense.setting.settings.SettingMode;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;

public class Screen
extends GuiScreen {
    public static final Point MOUSE = new Point();
    private final List<IComponent> PANELS = new ArrayList<IComponent>();

    public Screen() {
        Point offset = new Point(10, 10);
        for (Module.Category cat : Module.Category.values()) {
            PanelComponent panel = new PanelComponent(new Rectangle(new Point(offset), new Dimension(100, 10)), cat.name());
            JigokuSense.moduleManager.getModsInCategory(cat).forEach(m -> {
                ModuleComponent module = new ModuleComponent((Module)m);
                JigokuSense.settingsManager.getSettingsInMod((Module)m).forEach(s -> {
                    switch (s.getType()) {
                        case INTEGER: {
                            module.addChild(new SliderInteger((SettingInteger)s));
                            break;
                        }
                        case BOOLEAN: {
                            module.addChild(new BooleanComponent((SettingBoolean)s));
                            break;
                        }
                        case DOUBLE: {
                            module.addChild(new SliderDouble((SettingDouble)s));
                            break;
                        }
                        case MODE: {
                            module.addChild(new ModeComponent((SettingMode)s));
                        }
                    }
                });
                module.addChild(new KeybindComponent((Module)m));
                panel.addChild(module);
            });
            this.PANELS.add(panel);
            offset.translate(120, 0);
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(IComponent::draw);
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(p -> p.handleButton(mouseButton));
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(p -> p.handleButton(-1));
    }

    protected void keyTyped(char typedChar, int keyCode) {
        if (keyCode == 1) {
            this.mc.displayGuiScreen(null);
        }
        this.PANELS.forEach(p -> p.keyTyped(keyCode, typedChar));
    }
}

