/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package botnet.auth.jigokusense.manager;

import botnet.auth.jigokusense.util.Global;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class PositionManager
implements Global {
    public void updatePosition() {
        double x = PositionManager.mc.field_71439_g.field_70165_t;
        double y = PositionManager.mc.field_71439_g.field_70163_u;
        double z = PositionManager.mc.field_71439_g.field_70161_v;
        boolean onground = PositionManager.mc.field_71439_g.field_70122_E;
    }

    public void setPositionPacket(double x, double y, double z, boolean onGround, boolean setPos, boolean noLagBack) {
        PositionManager.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(x, y, z, onGround));
        if (setPos) {
            PositionManager.mc.field_71439_g.func_70107_b(x, y, z);
            if (noLagBack) {
                this.updatePosition();
            }
        }
    }
}

