//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketVehicleMove
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.module.Module;
import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketVehicleMove;

public class Vanish
extends Module {
    Entity entity;

    public Vanish() {
        super("Vanish", "", 0, Module.Category.PLAYER);
    }

    @Override
    public void onEnable() {
        if (Vanish.mc.player.getRidingEntity() != null) {
            this.entity = Vanish.mc.player.getRidingEntity();
            Vanish.mc.player.dismountRidingEntity();
            Vanish.mc.world.removeEntity(this.entity);
        }
    }

    @Override
    public void update() {
        if (this.nullCheck()) {
            this.disable();
            return;
        }
        if (this.entity != null) {
            try {
                this.entity.posX = Vanish.mc.player.posX;
                this.entity.posY = Vanish.mc.player.posY;
                this.entity.posZ = Vanish.mc.player.posZ;
                Objects.requireNonNull(mc.getConnection()).sendPacket((Packet)new CPacketVehicleMove(this.entity));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

