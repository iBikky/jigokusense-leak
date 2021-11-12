//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayer
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.event.events.PacketEvent;
import botnet.auth.jigokusense.module.Module;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketPlayer;

public class AntiHunger
extends Module {
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener = new Listener<PacketEvent.Receive>(event -> {
        if (event.getPacket() instanceof CPacketPlayer) {
            boolean groundCheck;
            CPacketPlayer player = (CPacketPlayer)event.getPacket();
            double differenceY = AntiHunger.mc.player.posY - AntiHunger.mc.player.lastTickPosY;
            boolean bl = groundCheck = differenceY == 0.0;
            if (groundCheck && !AntiHunger.mc.playerController.isHittingBlock) {
                AntiHunger.mc.player.onGround = true;
            }
        }
    }, new Predicate[0]);

    public AntiHunger() {
        super("AntiHunger", "Causes you to not lose hunger even while jumping.", 0, Module.Category.PLAYER);
    }
}

