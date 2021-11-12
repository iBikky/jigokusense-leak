/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.gui;

import botnet.auth.jigokusense.gui.IComponent;
import java.awt.Rectangle;

public abstract class AbstractComponent
implements IComponent {
    protected final Rectangle rect;

    public AbstractComponent(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void handleButton(int btn) {
    }

    @Override
    public void keyTyped(int key, char ch) {
    }

    @Override
    public int getAbsoluteHeight() {
        return this.rect.height;
    }

    @Override
    public void addChild(IComponent component) {
    }

    @Override
    public Rectangle getRect() {
        return this.rect;
    }

    @Override
    public void setRect(Rectangle rect1) {
        this.rect.setRect(rect1);
    }
}

