//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.JigokuSense;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

public interface IComponent {
    public void draw();

    public void handleButton(int var1);

    public void keyTyped(int var1, char var2);

    public int getAbsoluteHeight();

    public void addChild(IComponent var1);

    public Rectangle getRect();

    public void setRect(Rectangle var1);

    public static void fillRect(Rectangle rect, Color color) {
        Gui.drawRect((int)rect.x, (int)rect.y, (int)(rect.x + rect.width), (int)(rect.y + rect.height), (int)color.getRGB());
    }

    public static void drawString(String text, Point pos, Color color) {
        GlStateManager.enableTexture2D();
        JigokuSense.fontManager.drawStringWithShadow(text, pos.x, pos.y, color.getRGB());
        GlStateManager.disableTexture2D();
    }
}

