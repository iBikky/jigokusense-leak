//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  org.lwjgl.input.Mouse
 */
package com.lukflug.panelstudio.mc12;

import com.lukflug.panelstudio.ClickGUI;
import com.lukflug.panelstudio.mc12.GLInterface;
import java.awt.Point;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;

public abstract class MinecraftGUI
extends GuiScreen {
    private Point mouse = new Point();
    private boolean lButton = false;
    private boolean rButton = false;

    public void enterGUI() {
        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)this);
        this.getGUI().enter();
    }

    public void exitGUI() {
        this.getGUI().exit();
        Minecraft.getMinecraft().displayGuiScreen(null);
    }

    protected void renderGUI() {
        this.getInterface().getMatrices();
        GLInterface.begin();
        this.getGUI().render();
        GLInterface.end();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mouse = new Point(mouseX, mouseY);
        this.renderGUI();
        int scroll = Mouse.getDWheel();
        if (scroll != 0) {
            if (scroll > 0) {
                this.getGUI().handleScroll(-this.getScrollSpeed());
            } else {
                this.getGUI().handleScroll(this.getScrollSpeed());
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int clickedButton) {
        this.mouse = new Point(mouseX, mouseY);
        switch (clickedButton) {
            case 0: {
                this.lButton = true;
                break;
            }
            case 1: {
                this.rButton = true;
            }
        }
        this.getGUI().handleButton(clickedButton);
    }

    public void mouseReleased(int mouseX, int mouseY, int releaseButton) {
        this.mouse = new Point(mouseX, mouseY);
        switch (releaseButton) {
            case 0: {
                this.lButton = false;
                break;
            }
            case 1: {
                this.rButton = false;
            }
        }
        this.getGUI().handleButton(releaseButton);
    }

    protected void keyTyped(char typedChar, int keyCode) {
        if (keyCode == 1) {
            this.exitGUI();
        } else {
            this.getGUI().handleKey(keyCode);
        }
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    protected abstract ClickGUI getGUI();

    protected abstract GUIInterface getInterface();

    protected abstract int getScrollSpeed();

    public abstract class GUIInterface
    extends GLInterface {
        public GUIInterface(boolean clipX) {
            super(clipX);
        }

        @Override
        public boolean getButton(int button) {
            switch (button) {
                case 0: {
                    return MinecraftGUI.this.lButton;
                }
                case 1: {
                    return MinecraftGUI.this.rButton;
                }
            }
            return false;
        }

        @Override
        public Point getMouse() {
            return new Point(MinecraftGUI.this.mouse);
        }

        @Override
        protected float getZLevel() {
            return MinecraftGUI.this.zLevel;
        }
    }
}

