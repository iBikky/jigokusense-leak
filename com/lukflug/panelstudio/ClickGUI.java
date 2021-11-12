/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio;

import com.lukflug.panelstudio.ConfigList;
import com.lukflug.panelstudio.Context;
import com.lukflug.panelstudio.FixedComponent;
import com.lukflug.panelstudio.Interface;
import com.lukflug.panelstudio.PanelConfig;
import com.lukflug.panelstudio.PanelManager;
import com.lukflug.panelstudio.settings.Toggleable;
import com.lukflug.panelstudio.theme.DescriptionRenderer;
import java.util.ArrayList;
import java.util.List;

public class ClickGUI
implements PanelManager {
    protected List<FixedComponent> components = new ArrayList<FixedComponent>();
    protected List<FixedComponent> permanentComponents = new ArrayList<FixedComponent>();
    protected Interface inter;
    protected DescriptionRenderer descriptionRenderer;

    public ClickGUI(Interface inter, DescriptionRenderer descriptionRenderer) {
        this.inter = inter;
        this.descriptionRenderer = descriptionRenderer;
    }

    public List<FixedComponent> getComponents() {
        return this.permanentComponents;
    }

    public void addComponent(FixedComponent component) {
        this.components.add(component);
        this.permanentComponents.add(component);
    }

    @Override
    public void showComponent(FixedComponent component) {
        if (!this.components.contains(component)) {
            this.components.add(component);
            component.enter(this.getContext(component, false));
        }
    }

    @Override
    public void hideComponent(FixedComponent component) {
        if (!this.permanentComponents.contains(component) && this.components.remove(component)) {
            component.exit(this.getContext(component, false));
        }
    }

    public void render() {
        Context context;
        FixedComponent component;
        int i;
        ArrayList<FixedComponent> components = new ArrayList<FixedComponent>();
        for (FixedComponent component2 : this.components) {
            components.add(component2);
        }
        Context descriptionContext = null;
        int highest = 0;
        FixedComponent focusComponent = null;
        for (i = components.size() - 1; i >= 0; --i) {
            component = (FixedComponent)components.get(i);
            context = this.getContext(component, true);
            component.getHeight(context);
            if (!context.isHovered()) continue;
            highest = i;
            break;
        }
        for (i = 0; i < components.size(); ++i) {
            component = (FixedComponent)components.get(i);
            context = this.getContext(component, i >= highest);
            component.render(context);
            if (context.foucsRequested()) {
                focusComponent = component;
            }
            if (!context.isHovered() || context.getDescription() == null) continue;
            descriptionContext = context;
        }
        if (focusComponent != null && this.components.remove(focusComponent)) {
            this.components.add(focusComponent);
        }
        if (descriptionContext != null && this.descriptionRenderer != null) {
            this.descriptionRenderer.renderDescription(descriptionContext);
        }
    }

    public void handleButton(int button) {
        this.doComponentLoop((context, component) -> component.handleButton(context, button));
    }

    public void handleKey(int scancode) {
        this.doComponentLoop((context, component) -> component.handleKey(context, scancode));
    }

    public void handleScroll(int diff) {
        this.doComponentLoop((context, component) -> component.handleScroll(context, diff));
    }

    public void enter() {
        this.doComponentLoop((context, component) -> component.enter(context));
    }

    public void exit() {
        this.doComponentLoop((context, component) -> component.exit(context));
    }

    public void saveConfig(ConfigList config) {
        config.begin(false);
        for (FixedComponent component : this.getComponents()) {
            PanelConfig cf = config.addPanel(component.getTitle());
            if (cf == null) continue;
            component.saveConfig(this.inter, cf);
        }
        config.end(false);
    }

    public void loadConfig(ConfigList config) {
        config.begin(true);
        for (FixedComponent component : this.getComponents()) {
            PanelConfig cf = config.getPanel(component.getTitle());
            if (cf == null) continue;
            component.loadConfig(this.inter, cf);
        }
        config.end(true);
    }

    protected Context getContext(FixedComponent component, boolean highest) {
        return new Context(this.inter, component.getWidth(this.inter), component.getPosition(this.inter), true, highest);
    }

    @Override
    public Toggleable getComponentToggleable(final FixedComponent component) {
        return new Toggleable(){

            @Override
            public void toggle() {
                if (this.isOn()) {
                    ClickGUI.this.hideComponent(component);
                } else {
                    ClickGUI.this.showComponent(component);
                }
            }

            @Override
            public boolean isOn() {
                return ClickGUI.this.components.contains(component);
            }
        };
    }

    protected void doComponentLoop(LoopFunction function) {
        ArrayList<FixedComponent> components = new ArrayList<FixedComponent>();
        for (FixedComponent component : this.components) {
            components.add(component);
        }
        boolean highest = true;
        FixedComponent focusComponent = null;
        for (int i = components.size() - 1; i >= 0; --i) {
            FixedComponent component = (FixedComponent)components.get(i);
            Context context = this.getContext(component, highest);
            function.loop(context, component);
            if (context.isHovered()) {
                highest = false;
            }
            if (!context.foucsRequested()) continue;
            focusComponent = component;
        }
        if (focusComponent != null && this.components.remove(focusComponent)) {
            this.components.add(focusComponent);
        }
    }

    protected static interface LoopFunction {
        public void loop(Context var1, FixedComponent var2);
    }
}

