//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package botnet.auth.jigokusense.event;

import me.zero.alpine.type.Cancellable;
import net.minecraft.client.Minecraft;

public class Event
extends Cancellable {
    private Era era;
    private float partialTicks;

    public Event() {
        this.partialTicks = Minecraft.getMinecraft().getRenderPartialTicks();
    }

    public Event(Era era) {
        this.era = era;
        this.partialTicks = Minecraft.getMinecraft().getRenderPartialTicks();
    }

    public Era getEra() {
        return this.era;
    }

    public void setEra(Era era) {
        this.era = era;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }

    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public static enum Era {
        PRE,
        POST,
        PERI;

    }
}

