/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.setting;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.Setting;
import java.util.ArrayList;

public class SettingsManager {
    public ArrayList<Setting> settings = new ArrayList();

    public ArrayList<Setting> getSettingsInMod(Module mod) {
        ArrayList<Setting> sets = new ArrayList<Setting>();
        for (Setting s : this.settings) {
            if (s.getMod() != mod) continue;
            sets.add(s);
        }
        return sets;
    }

    public void setSettings(ArrayList<Setting> settings) {
        this.settings = settings;
    }
}

