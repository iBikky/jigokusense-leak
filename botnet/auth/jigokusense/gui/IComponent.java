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
        Gui.func_73734_a((int)rect.x, (int)rect.y, (int)(rect.x + rect.width), (int)(rect.y + rect.height), (int)color.getRGB());
    }

    public static void drawString(String text, Point pos, Color color) {
        GlStateManager.func_179098_w();
        JigokuSense.fontManager.drawStringWithShadow(text, pos.x, pos.y, color.getRGB());
        GlStateManager.func_179090_x();
    }
}

