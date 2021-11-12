/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 */
package botnet.auth.jigokusense.util;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public class Colour
extends Color {
    public Colour(int r, int g, int b) {
        super(r, g, b);
    }

    public Colour(int rgb) {
        super(rgb);
    }

    public Colour(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Colour(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Colour(Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public Colour(Colour color, int a) {
        super(color.getRed(), color.getGreen(), color.getBlue(), a);
    }

    public static Colour fromHSB(float hue, float saturation, float brightness) {
        return new Colour(Color.getHSBColor(hue, saturation, brightness));
    }

    public float getHue() {
        return Colour.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[0];
    }

    public float getSaturation() {
        return Colour.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[1];
    }

    public float getBrightness() {
        return Colour.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[2];
    }

    public void glColor() {
        GlStateManager.func_179131_c((float)((float)this.getRed() / 255.0f), (float)((float)this.getGreen() / 255.0f), (float)((float)this.getBlue() / 255.0f), (float)((float)this.getAlpha() / 255.0f));
    }
}

