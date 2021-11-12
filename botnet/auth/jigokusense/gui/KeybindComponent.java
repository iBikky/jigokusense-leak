/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.gui.AbstractComponent;
import botnet.auth.jigokusense.gui.IComponent;
import botnet.auth.jigokusense.gui.Screen;
import botnet.auth.jigokusense.module.Module;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import org.lwjgl.input.Keyboard;

public class KeybindComponent
extends AbstractComponent {
    private final Module module;
    private boolean listening = false;

    public KeybindComponent(Module module) {
        super(new Rectangle());
        this.module = module;
    }

    @Override
    public void draw() {
        IComponent.fillRect(this.rect, this.listening ? new Color(110, 110, 191, 170) : new Color(78, 65, 119, 120));
        IComponent.drawString("Bind: " + (this.listening ? "..." : Keyboard.getKeyName((int)this.module.getKey())), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
    }

    @Override
    public void handleButton(int btn) {
        if (this.rect.contains(Screen.MOUSE) && btn != -1) {
            this.listening = !this.listening;
        }
    }

    @Override
    public void keyTyped(int key, char ch) {
        if (this.listening) {
            if (key == 14 || key == 211) {
                this.module.setKey(0);
                return;
            }
            this.module.setKey(key);
            this.listening = false;
        }
    }
}

