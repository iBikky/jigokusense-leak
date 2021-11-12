//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package botnet.auth.jigokusense.manager;

import botnet.auth.jigokusense.util.CFontRenderer;
import java.awt.Font;
import net.minecraft.client.Minecraft;

public class FontManager {
    private final CFontRenderer cFontRenderer = new CFontRenderer(new Font("Lato", 0, 18), true, true);
    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean customFont = true;

    public void setCustomFont(boolean customFont) {
        this.customFont = customFont;
    }

    public void drawStringWithShadow(String text, float x, float y, int color) {
        if (this.customFont) {
            this.cFontRenderer.drawStringWithShadow(text, x, y, color);
            return;
        }
        this.mc.fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    public int getStringWidth(String text) {
        if (this.customFont) {
            return this.cFontRenderer.getStringWidth(text);
        }
        return this.mc.fontRenderer.getStringWidth(text);
    }
}

