/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 */
package botnet.auth.jigokusense.event.events;

import botnet.auth.jigokusense.event.Event;
import net.minecraft.client.gui.ScaledResolution;

public class Render2DEvent
extends Event {
    public float partialTicks;
    public ScaledResolution scaledResolution;

    public Render2DEvent(float partialTicks, ScaledResolution scaledResolution) {
        this.partialTicks = partialTicks;
        this.scaledResolution = scaledResolution;
    }

    @Override
    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public void setScaledResolution(ScaledResolution scaledResolution) {
        this.scaledResolution = scaledResolution;
    }

    public double getScreenWidth() {
        return this.scaledResolution.func_78327_c();
    }

    public double getScreenHeight() {
        return this.scaledResolution.func_78324_d();
    }
}

