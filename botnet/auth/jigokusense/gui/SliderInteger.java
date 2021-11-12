//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.gui.AbstractComponent;
import botnet.auth.jigokusense.gui.IComponent;
import botnet.auth.jigokusense.gui.Screen;
import botnet.auth.jigokusense.setting.settings.SettingInteger;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import net.minecraft.util.math.MathHelper;

public class SliderInteger
extends AbstractComponent {
    private final SettingInteger setting;
    private boolean sliding = false;

    public SliderInteger(SettingInteger setting) {
        super(new Rectangle());
        this.setting = setting;
    }

    @Override
    public void draw() {
        double Multiplier = (double)(this.setting.getValue() - this.setting.getMin()) / (double)(this.setting.getMax() - this.setting.getMin());
        IComponent.fillRect(this.rect, new Color(70, 70, 70, 140));
        IComponent.fillRect(new Rectangle(this.rect.x, this.rect.y, (int)((double)this.rect.width * Multiplier), this.rect.height), new Color(42, 28, 50, 200));
        IComponent.drawString(this.setting.getName() + ": " + this.setting.getValue(), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
        if (this.sliding) {
            double diff = MathHelper.clamp((double)((Screen.MOUSE.getX() - this.rect.getX()) / (this.rect.getWidth() - 1.0)), (double)0.0, (double)1.0);
            this.setting.setValue((int)((double)(this.setting.getMax() - this.setting.getMin()) * diff + (double)this.setting.getMin()));
        }
    }

    @Override
    public void handleButton(int btn) {
        if (btn != -1 && this.rect.contains(Screen.MOUSE)) {
            this.sliding = true;
        } else if (this.sliding) {
            this.sliding = false;
        }
    }
}

