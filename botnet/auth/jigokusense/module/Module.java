//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.common.MinecraftForge
 */
package botnet.auth.jigokusense.module;

import botnet.auth.jigokusense.JigokuSense;
import botnet.auth.jigokusense.command.Messages;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.setting.settings.SettingDouble;
import botnet.auth.jigokusense.setting.settings.SettingInteger;
import botnet.auth.jigokusense.setting.settings.SettingMode;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public String name;
    public String description;
    public int key;
    public Category category;
    public boolean toggled;

    public Module(String name, String description, int key, Category category) {
        this.name = name;
        this.description = description;
        this.key = key;
        this.category = category;
    }

    public void enable() {
        JigokuSense.EVENT_BUS.subscribe((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.onEnable();
        Messages.sendClientMessage(ChatFormatting.BOLD + this.getName() + ChatFormatting.GREEN + " enabled.");
    }

    public void disable() {
        JigokuSense.EVENT_BUS.unsubscribe((Object)this);
        MinecraftForge.EVENT_BUS.unregister((Object)this);
        this.onDisable();
        Messages.sendClientMessage(ChatFormatting.BOLD + this.getName() + ChatFormatting.RED + " disabled.");
    }

    public void toggle() {
        boolean bl = this.toggled = !this.toggled;
        if (this.toggled) {
            this.enable();
        } else {
            this.disable();
        }
    }

    public void update() {
    }

    public void render() {
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onToggle() {
    }

    public void onLogin() {
    }

    public void onLogout() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public SettingBoolean register(String name, boolean value) {
        SettingBoolean set = new SettingBoolean(name, this, value);
        JigokuSense.settingsManager.settings.add(set);
        return set;
    }

    public SettingMode register(String name, ArrayList<String> values, String value) {
        SettingMode set = new SettingMode(name, this, values, value);
        JigokuSense.settingsManager.settings.add(set);
        return set;
    }

    public SettingInteger register(String name, int value, int min, int max) {
        SettingInteger set = new SettingInteger(name, this, value, min, max);
        JigokuSense.settingsManager.settings.add(set);
        return set;
    }

    public SettingDouble register(String name, double value, double min, double max) {
        SettingDouble set = new SettingDouble(name, this, (int)value, (int)min, (int)max);
        JigokuSense.settingsManager.settings.add(set);
        return set;
    }

    public boolean nullCheck() {
        return Module.mc.player == null || Module.mc.world == null;
    }

    public static enum Category {
        MAIN,
        COMBAT,
        MOVEMENT,
        RENDER,
        MISC,
        PLAYER;

    }
}

