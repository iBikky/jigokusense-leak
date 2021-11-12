/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.gui.AbstractComponent;
import botnet.auth.jigokusense.gui.IComponent;
import botnet.auth.jigokusense.gui.Screen;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class BooleanComponent
extends AbstractComponent {
    private final SettingBoolean setting;

    public BooleanComponent(SettingBoolean setting) {
        super(new Rectangle());
        this.setting = setting;
    }

    @Override
    public void draw() {
        IComponent.fillRect(this.rect, this.setting.getValue() ? new Color(110, 110, 191, 170) : new Color(78, 65, 119, 120));
        IComponent.drawString(this.setting.getName(), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
    }

    @Override
    public void handleButton(int btn) {
        if (this.rect.contains(Screen.MOUSE) && btn != -1) {
            this.setting.setValue(!this.setting.getValue());
        }
    }
}

