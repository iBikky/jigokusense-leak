/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingInteger;
import botnet.auth.jigokusense.util.Pair;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Replenish
extends Module {
    SettingInteger tickDelay = this.register("TickDelay", 1, 0, 10);
    SettingInteger threshold = this.register("Threshold", 32, 1, 64);
    private int delayStep = 0;

    public Replenish() {
        super("Replenish", "", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (Replenish.mc.field_71462_r instanceof GuiContainer) {
            return;
        }
        if (this.delayStep < this.tickDelay.getValue()) {
            ++this.delayStep;
            return;
        }
        this.delayStep = 0;
        Pair<Integer, Integer> slots = this.findReplenishableHotbarSlot();
        if (slots == null) {
            return;
        }
        int inventorySlot = slots.getKey();
        int hotbarSlot = slots.getValue();
        Replenish.mc.field_71442_b.func_187098_a(0, inventorySlot, 0, ClickType.PICKUP, (EntityPlayer)Replenish.mc.field_71439_g);
        Replenish.mc.field_71442_b.func_187098_a(0, hotbarSlot, 0, ClickType.PICKUP, (EntityPlayer)Replenish.mc.field_71439_g);
        Replenish.mc.field_71442_b.func_187098_a(0, inventorySlot, 0, ClickType.PICKUP, (EntityPlayer)Replenish.mc.field_71439_g);
        Replenish.mc.field_71442_b.func_78765_e();
    }

    private Pair<Integer, Integer> findReplenishableHotbarSlot() {
        Pair<Integer, Integer> returnPair = null;
        for (Map.Entry<Integer, ItemStack> hotbarSlot : this.getHotbar().entrySet()) {
            int inventorySlot;
            ItemStack stack = hotbarSlot.getValue();
            if (stack.field_190928_g || stack.func_77973_b() == Items.field_190931_a || !stack.func_77985_e() || stack.field_77994_a >= stack.func_77976_d() || stack.field_77994_a > this.threshold.getValue() || (inventorySlot = this.findCompatibleInventorySlot(stack)) == -1) continue;
            returnPair = new Pair<Integer, Integer>(inventorySlot, hotbarSlot.getKey());
        }
        return returnPair;
    }

    private int findCompatibleInventorySlot(ItemStack hotbarStack) {
        int inventorySlot = -1;
        int smallestStackSize = 999;
        for (Map.Entry<Integer, ItemStack> entry : this.getInventory().entrySet()) {
            int currentStackSize;
            ItemStack inventoryStack = entry.getValue();
            if (inventoryStack.field_190928_g || inventoryStack.func_77973_b() == Items.field_190931_a || !this.isCompatibleStacks(hotbarStack, inventoryStack) || smallestStackSize <= (currentStackSize = ((ItemStack)Replenish.mc.field_71439_g.field_71069_bz.func_75138_a().get((int)entry.getKey().intValue())).field_77994_a)) continue;
            smallestStackSize = currentStackSize;
            inventorySlot = entry.getKey();
        }
        return inventorySlot;
    }

    private boolean isCompatibleStacks(ItemStack stack1, ItemStack stack2) {
        if (!stack1.func_77973_b().equals(stack2.func_77973_b())) {
            return false;
        }
        if (stack1.func_77973_b() instanceof ItemBlock && stack2.func_77973_b() instanceof ItemBlock) {
            Block block1 = ((ItemBlock)stack1.func_77973_b()).func_179223_d();
            Block block2 = ((ItemBlock)stack2.func_77973_b()).func_179223_d();
            if (!block1.field_149764_J.equals(block2.field_149764_J)) {
                return false;
            }
        }
        return stack1.func_82833_r().equals(stack2.func_82833_r()) && stack1.func_77952_i() == stack2.func_77952_i();
    }

    private Map<Integer, ItemStack> getInventory() {
        return this.getInvSlots(9, 35);
    }

    private Map<Integer, ItemStack> getHotbar() {
        return this.getInvSlots(36, 44);
    }

    private Map<Integer, ItemStack> getInvSlots(int current, int last) {
        HashMap<Integer, ItemStack> fullInventorySlots = new HashMap<Integer, ItemStack>();
        while (current <= last) {
            fullInventorySlots.put(current, (ItemStack)Replenish.mc.field_71439_g.field_71069_bz.func_75138_a().get(current));
            ++current;
        }
        return fullInventorySlots;
    }
}

