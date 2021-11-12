/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.gui.AbstractComponent;
import botnet.auth.jigokusense.gui.ContainerComponent;
import botnet.auth.jigokusense.gui.IComponent;
import botnet.auth.jigokusense.gui.Screen;
import botnet.auth.jigokusense.module.Module;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class ModuleComponent
extends AbstractComponent {
    private final Module module;
    private final ContainerComponent container = new ContainerComponent(2, 2, 4);
    private boolean opened = false;

    public ModuleComponent(Module module) {
        super(new Rectangle());
        this.module = module;
    }

    @Override
    public void draw() {
        IComponent.fillRect(this.rect, this.module.isToggled() ? new Color(110, 110, 191, 170) : new Color(78, 65, 119, 120));
        IComponent.drawString(this.module.getName(), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
        if (this.opened) {
            this.container.setRect(this.rect);
            this.container.draw();
        }
    }

    @Override
    public void handleButton(int btn) {
        if (this.rect.contains(Screen.MOUSE)) {
            if (btn == 0) {
                this.module.toggle();
            } else if (btn == 1) {
                boolean bl = this.opened = !this.opened;
            }
        }
        if (this.opened) {
            this.container.handleButton(btn);
        }
    }

    @Override
    public void keyTyped(int key, char ch) {
        if (this.opened) {
            this.container.keyTyped(key, ch);
        }
    }

    @Override
    public int getAbsoluteHeight() {
        return this.rect.height + (this.opened ? this.container.getAbsoluteHeight() : 0);
    }

    @Override
    public void addChild(IComponent component) {
        this.container.addChild(component);
    }
}

