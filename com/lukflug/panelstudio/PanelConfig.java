/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio;

import java.awt.Point;

public interface PanelConfig {
    public void savePositon(Point var1);

    public Point loadPosition();

    public void saveState(boolean var1);

    public boolean loadState();
}

