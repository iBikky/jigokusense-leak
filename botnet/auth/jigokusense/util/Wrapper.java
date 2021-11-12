/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.network.Packet
 */
package botnet.auth.jigokusense.util;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.Packet;

public class Wrapper {
    public static final Minecraft mc = Minecraft.func_71410_x();
    public static volatile Wrapper INSTANCE = new Wrapper();

    @Nullable
    public static EntityPlayerSP getPlayer() {
        return Wrapper.mc.field_71439_g;
    }

    @Nullable
    public static WorldClient getWorld() {
        return Wrapper.mc.field_71441_e;
    }

    public static FontRenderer getFontRenderer() {
        return Wrapper.mc.field_71466_p;
    }

    public void sendPacket(Packet packet) {
        this.getPlayer().field_71174_a.func_147297_a(packet);
    }
}

