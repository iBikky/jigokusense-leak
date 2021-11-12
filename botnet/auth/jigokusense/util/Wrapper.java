//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static volatile Wrapper INSTANCE = new Wrapper();

    @Nullable
    public static EntityPlayerSP getPlayer() {
        return Wrapper.mc.player;
    }

    @Nullable
    public static WorldClient getWorld() {
        return Wrapper.mc.world;
    }

    public static FontRenderer getFontRenderer() {
        return Wrapper.mc.fontRenderer;
    }

    public void sendPacket(Packet packet) {
        this.getPlayer().connection.sendPacket(packet);
    }
}

