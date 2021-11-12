/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;

public class SilentXP
extends Module {
    int prvSlot;

    public SilentXP() {
        super("SilentXP", "", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (SilentXP.mc.field_71462_r == null) {
            this.prvSlot = SilentXP.mc.field_71439_g.field_71071_by.field_70461_c;
            SilentXP.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketHeldItemChange(this.findExpInHotbar()));
            SilentXP.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            SilentXP.mc.field_71439_g.field_71071_by.field_70461_c = this.prvSlot;
            SilentXP.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketHeldItemChange(this.prvSlot));
        }
    }

    private int findExpInHotbar() {
        int slot = 0;
        for (int i = 0; i < 9; ++i) {
            if (SilentXP.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() != Items.field_151062_by) continue;
            slot = i;
            break;
        }
        return slot;
    }
}

