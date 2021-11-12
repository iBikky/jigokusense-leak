/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.ClickGUI;
import com.lukflug.panelstudio.FixedComponent;
import com.lukflug.panelstudio.Interface;
import com.lukflug.panelstudio.settings.Toggleable;
import com.lukflug.panelstudio.theme.DescriptionRenderer;
import java.util.ArrayList;
import java.util.List;

public class HUDClickGUI
extends ClickGUI
implements Toggleable {
    protected List<FixedComponent> allComponents = new ArrayList<FixedComponent>();
    protected List<FixedComponent> hudComponents = new ArrayList<FixedComponent>();
    protected boolean guiOpen = false;

    public HUDClickGUI(Interface inter, DescriptionRenderer descriptionRenderer) {
        super(inter, descriptionRenderer);
        this.components = this.hudComponents;
    }

    @Override
    public void addComponent(FixedComponent component) {
        this.allComponents.add(component);
        this.permanentComponents.add(component);
    }

    @Override
    public void showComponent(FixedComponent component) {
        if (!this.allComponents.contains(component)) {
            this.allComponents.add(component);
            if (this.guiOpen) {
                component.enter(this.getContext(component, false));
            }
        }
    }

    @Override
    public void hideComponent(FixedComponent component) {
        if (!this.permanentComponents.contains(component) && this.allComponents.remove(component) && this.guiOpen) {
            component.exit(this.getContext(component, false));
        }
    }

    public void addHUDComponent(FixedComponent component) {
        this.hudComponents.add(component);
        this.allComponents.add(component);
        this.permanentComponents.add(component);
    }

    @Override
    public void enter() {
        this.components = this.allComponents;
        this.guiOpen = true;
        this.doComponentLoop((context, component) -> {
            if (!this.hudComponents.contains(component)) {
                component.enter(context);
            }
        });
    }

    @Override
    public void exit() {
        this.guiOpen = false;
        this.doComponentLoop((context, component) -> {
            if (!this.hudComponents.contains(component)) {
                component.exit(context);
            }
        });
        this.components = this.hudComponents;
    }

    @Override
    public void toggle() {
        if (!this.guiOpen) {
            this.enter();
        } else {
            this.exit();
        }
    }

    @Override
    public boolean isOn() {
        return this.guiOpen;
    }

    @Override
    public Toggleable getComponentToggleable(final FixedComponent component) {
        return new Toggleable(){

            @Override
            public void toggle() {
                if (this.isOn()) {
                    HUDClickGUI.this.hideComponent(component);
                } else {
                    HUDClickGUI.this.showComponent(component);
                }
            }

            @Override
            public boolean isOn() {
                return HUDClickGUI.this.allComponents.contains(component);
            }
        };
    }
}

