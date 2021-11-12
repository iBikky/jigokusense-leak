/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio;

import com.lukflug.panelstudio.FixedComponent;
import com.lukflug.panelstudio.settings.Toggleable;

public interface PanelManager {
    public void showComponent(FixedComponent var1);

    public void hideComponent(FixedComponent var1);

    public Toggleable getComponentToggleable(FixedComponent var1);
}

