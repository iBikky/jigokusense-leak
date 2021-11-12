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
            double differenceY = AntiHunger.mc.field_71439_g.field_70163_u - AntiHunger.mc.field_71439_g.field_70137_T;
            boolean bl = groundCheck = differenceY == 0.0;
            if (groundCheck && !AntiHunger.mc.field_71442_b.field_78778_j) {
                AntiHunger.mc.field_71439_g.field_70122_E = true;
            }
        }
    }, new Predicate[0]);

    public AntiHunger() {
        super("AntiHunger", "Causes you to not lose hunger even while jumping.", 0, Module.Category.PLAYER);
    }
}

