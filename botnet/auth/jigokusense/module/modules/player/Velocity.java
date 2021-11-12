/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.event.events.PacketEvent;
import botnet.auth.jigokusense.module.Module;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;

public class Velocity
extends Module {
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener = new Listener<PacketEvent.Receive>(event -> {
        if (event.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)event.getPacket()).func_149412_c() == Velocity.mc.field_71439_g.func_145782_y()) {
            event.cancel();
        }
        if (event.getPacket() instanceof SPacketExplosion) {
            event.cancel();
        }
    }, new Predicate[0]);

    public Velocity() {
        super("Velocity", "Removes knockback.", 0, Module.Category.PLAYER);
    }
}

