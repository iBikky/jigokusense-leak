/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio.hud;

import java.awt.Color;

public interface HUDList {
    public int getSize();

    public String getItem(int var1);

    public Color getItemColor(int var1);

    public boolean sortUp();

    public boolean sortRight();
}

