/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio.settings;

public interface NumberSetting {
    public double getNumber();

    public void setNumber(double var1);

    public double getMaximumValue();

    public double getMinimumValue();

    public int getPrecision();
}

