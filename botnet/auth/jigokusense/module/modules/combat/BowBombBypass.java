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

public class BowBombBypass
extends Module {
    public BowBombBypass() {
        super("BowBombBypass", "BOW BOMB FROM BENNYYY'S VIDEO!!!", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (BowBombBypass.mc.field_71439_g.field_71071_by.func_70448_g().func_77973_b() instanceof ItemBow && BowBombBypass.mc.field_71439_g.func_184587_cr() && BowBombBypass.mc.field_71439_g.func_184612_cw() >= 3) {
            BowBombBypass.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, BowBombBypass.mc.field_71439_g.func_174811_aO()));
            BowBombBypass.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayerTryUseItem(BowBombBypass.mc.field_71439_g.func_184600_cs()));
            BowBombBypass.mc.field_71439_g.func_184597_cx();
        }
    }
}

