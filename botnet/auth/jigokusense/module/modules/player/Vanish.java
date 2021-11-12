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
        if (Vanish.mc.field_71439_g.func_184187_bx() != null) {
            this.entity = Vanish.mc.field_71439_g.func_184187_bx();
            Vanish.mc.field_71439_g.func_184210_p();
            Vanish.mc.field_71441_e.func_72900_e(this.entity);
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
                this.entity.field_70165_t = Vanish.mc.field_71439_g.field_70165_t;
                this.entity.field_70163_u = Vanish.mc.field_71439_g.field_70163_u;
                this.entity.field_70161_v = Vanish.mc.field_71439_g.field_70161_v;
                Objects.requireNonNull(mc.func_147114_u()).func_147297_a((Packet)new CPacketVehicleMove(this.entity));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

