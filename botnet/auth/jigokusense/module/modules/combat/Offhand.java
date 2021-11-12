/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;

public class Offhand
extends Module {
    SettingBoolean swordGap = this.register("SwordGap", true);
    SettingBoolean soft = this.register("Soft", false);
    private boolean dragging = false;
    private int totems = 0;

    public Offhand() {
        super("OffHand", "", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (Offhand.mc.field_71462_r instanceof GuiContainer && !(Offhand.mc.field_71462_r instanceof GuiInventory)) {
            return;
        }
        EntityPlayerSP player = Offhand.mc.field_71439_g;
        if (player == null) {
            return;
        }
        if (!player.field_71071_by.func_70445_o().func_190926_b() && !this.dragging) {
            for (int i = 0; i < 45; ++i) {
                if (!player.field_71071_by.func_70301_a(i).func_190926_b() && player.field_71071_by.func_70301_a(i).func_77973_b() != Items.field_190931_a) continue;
                int slot = i < 9 ? i + 36 : i;
                Offhand.mc.field_71442_b.func_187098_a(0, slot, 0, ClickType.PICKUP, (EntityPlayer)player);
                return;
            }
        }
        this.totems = 0;
        for (ItemStack stack : player.field_71071_by.field_70462_a) {
            if (stack.func_77973_b() != Items.field_190929_cY) continue;
            this.totems += stack.func_190916_E();
        }
        if (player.func_184592_cb().func_77973_b() == Items.field_190929_cY) {
            this.totems += player.func_184592_cb().func_190916_E();
            return;
        }
        if (this.soft.getValue() && !player.func_184592_cb().func_190926_b()) {
            return;
        }
        if (this.dragging) {
            Offhand.mc.field_71442_b.func_187098_a(0, 45, 0, ClickType.PICKUP, (EntityPlayer)player);
            this.dragging = false;
            return;
        }
        for (int i = 0; i < 45; ++i) {
            if (player.field_71071_by.func_70301_a(i).func_77973_b() != Items.field_190929_cY) continue;
            int slot = i < 9 ? i + 36 : i;
            Offhand.mc.field_71442_b.func_187098_a(0, slot, 0, ClickType.PICKUP, (EntityPlayer)player);
            this.dragging = true;
            return;
        }
    }
}

