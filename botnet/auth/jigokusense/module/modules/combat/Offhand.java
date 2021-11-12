//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
        if (Offhand.mc.currentScreen instanceof GuiContainer && !(Offhand.mc.currentScreen instanceof GuiInventory)) {
            return;
        }
        EntityPlayerSP player = Offhand.mc.player;
        if (player == null) {
            return;
        }
        if (!player.inventory.getItemStack().isEmpty() && !this.dragging) {
            for (int i = 0; i < 45; ++i) {
                if (!player.inventory.getStackInSlot(i).isEmpty() && player.inventory.getStackInSlot(i).getItem() != Items.AIR) continue;
                int slot = i < 9 ? i + 36 : i;
                Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)player);
                return;
            }
        }
        this.totems = 0;
        for (ItemStack stack : player.inventory.mainInventory) {
            if (stack.getItem() != Items.TOTEM_OF_UNDYING) continue;
            this.totems += stack.getCount();
        }
        if (player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
            this.totems += player.getHeldItemOffhand().getCount();
            return;
        }
        if (this.soft.getValue() && !player.getHeldItemOffhand().isEmpty()) {
            return;
        }
        if (this.dragging) {
            Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)player);
            this.dragging = false;
            return;
        }
        for (int i = 0; i < 45; ++i) {
            if (player.inventory.getStackInSlot(i).getItem() != Items.TOTEM_OF_UNDYING) continue;
            int slot = i < 9 ? i + 36 : i;
            Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)player);
            this.dragging = true;
            return;
        }
    }
}

