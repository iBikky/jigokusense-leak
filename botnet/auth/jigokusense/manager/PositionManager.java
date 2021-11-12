//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
        double x = PositionManager.mc.player.posX;
        double y = PositionManager.mc.player.posY;
        double z = PositionManager.mc.player.posZ;
        boolean onground = PositionManager.mc.player.onGround;
    }

    public void setPositionPacket(double x, double y, double z, boolean onGround, boolean setPos, boolean noLagBack) {
        PositionManager.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(x, y, z, onGround));
        if (setPos) {
            PositionManager.mc.player.setPosition(x, y, z);
            if (noLagBack) {
                this.updatePosition();
            }
        }
    }
}

