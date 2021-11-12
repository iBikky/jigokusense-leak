/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio;

import com.lukflug.panelstudio.Component;
import com.lukflug.panelstudio.Context;
import com.lukflug.panelstudio.FocusableComponent;
import com.lukflug.panelstudio.theme.Renderer;
import java.util.ArrayList;
import java.util.List;

public class Container
extends FocusableComponent {
    protected List<Component> components = new ArrayList<Component>();
    private String tempDescription;

    public Container(String title, String description, Renderer renderer) {
        super(title, description, renderer);
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    @Override
    public void render(Context context) {
        this.tempDescription = null;
        this.doComponentLoop(context, (subContext, component) -> {
            component.render(subContext);
            if (subContext.isHovered() && subContext.getDescription() != null) {
                this.tempDescription = subContext.getDescription();
            }
        });
        if (this.tempDescription == null) {
            this.tempDescription = this.description;
        }
        context.setDescription(this.tempDescription);
    }

    @Override
    public void handleButton(Context context, int button) {
        this.getHeight(context);
        this.updateFocus(context, button);
        this.doComponentLoop(context, (subContext, component) -> {
            component.handleButton(subContext, button);
            if (subContext.focusReleased()) {
                context.releaseFocus();
            }
        });
    }

    @Override
    public void handleKey(Context context, int scancode) {
        this.doComponentLoop(context, (subContext, component) -> component.handleKey(subContext, scancode));
    }

    @Override
    public void handleScroll(Context context, int diff) {
        this.doComponentLoop(context, (subContext, component) -> component.handleScroll(subContext, diff));
    }

    @Override
    public void getHeight(Context context) {
        this.doComponentLoop(context, (subContext, component) -> component.getHeight(subContext));
    }

    @Override
    public void enter(Context context) {
        this.doComponentLoop(context, (subContext, component) -> component.enter(subContext));
    }

    @Override
    public void exit(Context context) {
        this.doComponentLoop(context, (subContext, component) -> component.exit(subContext));
    }

    @Override
    public void releaseFocus() {
        super.releaseFocus();
        for (Component component : this.components) {
            component.releaseFocus();
        }
    }

    @Override
    protected void handleFocus(Context context, boolean focus) {
        if (!focus) {
            this.releaseFocus();
        }
    }

    protected Context getSubContext(Context context, int posy) {
        return new Context(context, this.renderer.getBorder(), this.renderer.getBorder(), posy, this.hasFocus(context), true);
    }

    protected void doComponentLoop(Context context, LoopFunction function) {
        int posy = this.renderer.getOffset();
        for (Component component : this.components) {
            Context subContext = this.getSubContext(context, posy);
            function.loop(subContext, component);
            posy += subContext.getSize().height + this.renderer.getOffset();
        }
        context.setHeight(posy);
    }

    protected static interface LoopFunction {
        public void loop(Context var1, Component var2);
    }
}

