/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.ContainerChest
 *  net.minecraft.item.ItemStack
 */
package botnet.auth.jigokusense.module.modules.misc;

import botnet.auth.jigokusense.module.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;

public class ChestStealer
extends Module {
    public ChestStealer() {
        super("ChestStealer", "", 0, Module.Category.MISC);
    }

    @Override
    public void update() {
        if (ChestStealer.mc.field_71439_g.field_71070_bA instanceof ContainerChest) {
            ContainerChest chest = (ContainerChest)ChestStealer.mc.field_71439_g.field_71070_bA;
            for (int items = 0; items < chest.func_85151_d().func_70302_i_(); ++items) {
                ItemStack stack = chest.func_85151_d().func_70301_a(items);
                ChestStealer.mc.field_71442_b.func_187098_a(chest.field_75152_c, items, 0, ClickType.QUICK_MOVE, (EntityPlayer)ChestStealer.mc.field_71439_g);
                if (!this.isChestEmpty(chest)) continue;
                ChestStealer.mc.field_71439_g.func_71053_j();
            }
        }
    }

    private boolean isChestEmpty(ContainerChest chest) {
        int items = 0;
        if (items < chest.func_85151_d().func_70302_i_()) {
            ItemStack slot = chest.func_85151_d().func_70301_a(items);
            return false;
        }
        return true;
    }
}

