/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.gui.AbstractComponent;
import botnet.auth.jigokusense.gui.IComponent;
import botnet.auth.jigokusense.gui.Screen;
import botnet.auth.jigokusense.setting.settings.SettingMode;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class ModeComponent
extends AbstractComponent {
    private final SettingMode setting;

    public ModeComponent(SettingMode setting) {
        super(new Rectangle());
        this.setting = setting;
    }

    @Override
    public void draw() {
        IComponent.fillRect(this.rect, new Color(20, 20, 20, 120));
        IComponent.fillRect(new Rectangle(this.rect.x, this.rect.y, 12, this.rect.height), new Color(42, 28, 50, 200));
        IComponent.fillRect(new Rectangle(this.rect.x + this.rect.width - 12, this.rect.y, 12, this.rect.height), new Color(42, 28, 50, 200));
        IComponent.drawString(this.setting.getName() + ": " + this.setting.getValue(), new Point(this.rect.x + 20, this.rect.y + 2), Color.WHITE);
    }

    @Override
    public void handleButton(int btn) {
        if (this.rect.contains(Screen.MOUSE)) {
            if (btn == 0) {
                this.setting.increment();
            } else if (btn == 1) {
                this.setting.decrement();
            }
        }
    }
}

