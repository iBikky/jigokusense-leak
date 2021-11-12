/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.util;

import botnet.auth.jigokusense.util.Colour;
import botnet.auth.jigokusense.util.Global;
import java.awt.Color;

public class ColourUtil
implements Global {
    public static int shadeColour(int color, int precent) {
        int r = ((color & 0xFF0000) >> 16) * (100 + precent) / 100;
        int g = ((color & 0xFF00) >> 8) * (100 + precent) / 100;
        int b = (color & 0xFF) * (100 + precent) / 100;
        return new Color(r, g, b).hashCode();
    }

    public static Color getColour() {
        return Colour.fromHSB((float)(System.currentTimeMillis() % 11520L) / 11520.0f, 1.0f, 1.0f);
    }

    public static Color getFurtherColour(int offset) {
        return Colour.fromHSB((float)((System.currentTimeMillis() + (long)offset) % 11520L) / 11520.0f, 1.0f, 1.0f);
    }
}

