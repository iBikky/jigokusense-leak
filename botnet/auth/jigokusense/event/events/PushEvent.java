//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 */
package botnet.auth.jigokusense.event.events;

import botnet.auth.jigokusense.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class PushEvent
extends Event {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public double x;
    public double y;
    public double z;
    public Entity entity;

    public PushEvent(Entity entity, double x, double y, double z) {
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

