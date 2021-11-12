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
import botnet.auth.jigokusense.setting.settings.SettingDouble;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import net.minecraft.util.math.MathHelper;

public class SliderDouble
extends AbstractComponent {
    private final SettingDouble setting;
    private boolean sliding = false;

    public SliderDouble(SettingDouble setting) {
        super(new Rectangle());
        this.setting = setting;
    }

    @Override
    public void draw() {
        double Multiplier = (this.setting.getValue() - this.setting.getMin()) / (this.setting.getMax() - this.setting.getMin());
        IComponent.fillRect(this.rect, new Color(70, 70, 70, 140));
        IComponent.fillRect(new Rectangle(this.rect.x, this.rect.y, (int)((double)this.rect.width * Multiplier), this.rect.height), new Color(42, 28, 50, 200));
        IComponent.drawString(this.setting.getName() + ": " + this.setting.getValue(), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
        if (this.sliding) {
            double diff = MathHelper.func_151237_a((double)((Screen.MOUSE.getX() - this.rect.getX()) / (this.rect.getWidth() - 1.0)), (double)0.0, (double)1.0);
            this.setting.setValue((int)((this.setting.getMax() - this.setting.getMin()) * diff + this.setting.getMin()));
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

