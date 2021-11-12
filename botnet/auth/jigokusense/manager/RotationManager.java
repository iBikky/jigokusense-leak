/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraftforge.common.MinecraftForge
 */
package botnet.auth.jigokusense.manager;

import botnet.auth.jigokusense.event.events.PacketEvent;
import botnet.auth.jigokusense.util.Global;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.common.MinecraftForge;

public class RotationManager
implements Global {
    private float yaw = 0.0f;
    private float pitch = 0.0f;
    private boolean shouldRotate = false;
    @EventHandler
    private final Listener<PacketEvent.Send> receiveListener = new Listener<PacketEvent.Send>(event -> {
        if (event.getPacket() instanceof CPacketPlayer) {
            CPacketPlayer packet = (CPacketPlayer)event.getPacket();
            if (this.shouldRotate) {
                packet.field_149476_e = this.yaw;
                packet.field_149473_f = this.pitch;
            }
        }
    }, new Predicate[0]);

    public RotationManager() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    public void reset() {
        this.shouldRotate = false;
        if (RotationManager.mc.field_71439_g == null) {
            return;
        }
        this.yaw = RotationManager.mc.field_71439_g.field_70177_z;
        this.pitch = RotationManager.mc.field_71439_g.field_70125_A;
    }

    public void rotate(double x, double y, double z) {
        if (RotationManager.mc.field_71439_g == null) {
            return;
        }
        Double[] v = this.calculateLookAt(x, y, z, (EntityPlayer)RotationManager.mc.field_71439_g);
        this.shouldRotate = true;
        this.yaw = v[0].floatValue();
        this.pitch = v[1].floatValue();
    }

    private Double[] calculateLookAt(double px, double py, double pz, EntityPlayer me) {
        double dirx = me.field_70165_t - px;
        double diry = me.field_70163_u - py;
        double dirz = me.field_70161_v - pz;
        double len = Math.sqrt(dirx * dirx + diry * diry + dirz * dirz);
        double pitch = Math.asin(diry /= len);
        double yaw = Math.atan2(dirz /= len, dirx /= len);
        pitch = pitch * 180.0 / Math.PI;
        yaw = yaw * 180.0 / Math.PI;
        return new Double[]{yaw += 90.0, pitch};
    }
}

