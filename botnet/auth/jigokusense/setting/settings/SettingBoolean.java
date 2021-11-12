/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.setting.settings;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.Setting;

public class SettingBoolean
extends Setting {
    public boolean value;

    public SettingBoolean(String name, Module mod, Boolean value) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.type = Setting.Type.BOOLEAN;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

