//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
        if (ChestStealer.mc.player.openContainer instanceof ContainerChest) {
            ContainerChest chest = (ContainerChest)ChestStealer.mc.player.openContainer;
            for (int items = 0; items < chest.getLowerChestInventory().getSizeInventory(); ++items) {
                ItemStack stack = chest.getLowerChestInventory().getStackInSlot(items);
                ChestStealer.mc.playerController.windowClick(chest.windowId, items, 0, ClickType.QUICK_MOVE, (EntityPlayer)ChestStealer.mc.player);
                if (!this.isChestEmpty(chest)) continue;
                ChestStealer.mc.player.closeScreen();
            }
        }
    }

    private boolean isChestEmpty(ContainerChest chest) {
        int items = 0;
        if (items < chest.getLowerChestInventory().getSizeInventory()) {
            ItemStack slot = chest.getLowerChestInventory().getStackInSlot(items);
            return false;
        }
        return true;
    }
}

