/*
 * Decompiled with CFR 0.151.
 */
package com.lukflug.panelstudio;

public abstract class Animation {
    protected double value;
    protected double lastValue;
    protected long lastTime = System.currentTimeMillis();

    public void initValue(double value) {
        this.value = value;
        this.lastValue = value;
    }

    public double getValue() {
        if (this.getSpeed() == 0) {
            return this.value;
        }
        double weight = (double)(System.currentTimeMillis() - this.lastTime) / (double)this.getSpeed();
        if (weight >= 1.0) {
            return this.value;
        }
        if (weight <= 0.0) {
            return this.lastValue;
        }
        return this.value * weight + this.lastValue * (1.0 - weight);
    }

    public double getTarget() {
        return this.value;
    }

    public void setValue(double value) {
        this.lastValue = this.getValue();
        this.value = value;
        this.lastTime = System.currentTimeMillis();
    }

    protected abstract int getSpeed();
}

