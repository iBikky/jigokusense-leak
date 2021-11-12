/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemBow
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.math.BlockPos
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import net.minecraft.item.ItemBow;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.math.BlockPos;

public class Quiver
extends Module {
    public Quiver() {
        super("Quiver", "Shoots Positive Arrow Effects At You!", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (Quiver.mc.field_71439_g.field_71071_by.func_70448_g().func_77973_b() instanceof ItemBow && Quiver.mc.field_71439_g.func_184587_cr() && Quiver.mc.field_71439_g.func_184612_cw() >= 3) {
            Quiver.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, Quiver.mc.field_71439_g.func_174811_aO()));
            Quiver.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayerTryUseItem(Quiver.mc.field_71439_g.func_184600_cs()));
            Quiver.mc.field_71439_g.func_184597_cx();
        }
    }
}

