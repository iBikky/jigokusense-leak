/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.setting.settings;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.Setting;

public class SettingDouble
extends Setting {
    public double value;
    public double min;
    public double max;

    public SettingDouble(String name, Module mod, int value, int min, int max) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.min = min;
        this.max = max;
        this.type = Setting.Type.DOUBLE;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}

