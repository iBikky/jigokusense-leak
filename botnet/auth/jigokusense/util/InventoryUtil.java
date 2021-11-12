/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 */
package botnet.auth.jigokusense.util;

import botnet.auth.jigokusense.util.Global;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class InventoryUtil
implements Global {
    public static int findHotbarBlock(Class c) {
        for (int i = 0; i < 9; ++i) {
            ItemStack stack = InventoryUtil.mc.field_71439_g.field_71071_by.func_70301_a(i);
            if (stack == ItemStack.field_190927_a) continue;
            if (c.isInstance(stack.func_77973_b())) {
                return i;
            }
            if (!(stack.func_77973_b() instanceof ItemBlock) || !c.isInstance(((ItemBlock)stack.func_77973_b()).func_179223_d())) continue;
            return i;
        }
        return -1;
    }

    public static boolean holdingItem(Class clazz) {
        boolean result = false;
        ItemStack stack = InventoryUtil.mc.field_71439_g.func_184614_ca();
        result = InventoryUtil.isInstanceOf(stack, clazz);
        if (!result) {
            ItemStack offhand = InventoryUtil.mc.field_71439_g.func_184592_cb();
            result = InventoryUtil.isInstanceOf(stack, clazz);
        }
        return result;
    }

    public static boolean isInstanceOf(ItemStack stack, Class clazz) {
        if (stack == null) {
            return false;
        }
        Item item = stack.func_77973_b();
        if (clazz.isInstance(item)) {
            return true;
        }
        if (item instanceof ItemBlock) {
            Block block = Block.func_149634_a((Item)item);
            return clazz.isInstance(block);
        }
        return false;
    }

    public static Map<Integer, ItemStack> getInventoryAndHotbarSlots() {
        return InventoryUtil.getInventorySlots(9, 44);
    }

    private static Map<Integer, ItemStack> getInventorySlots(int currentI, int last) {
        HashMap<Integer, ItemStack> fullInventorySlots = new HashMap<Integer, ItemStack>();
        for (int current = currentI; current <= last; ++current) {
            fullInventorySlots.put(current, (ItemStack)InventoryUtil.mc.field_71439_g.field_71069_bz.func_75138_a().get(current));
        }
        return fullInventorySlots;
    }

    public static List<Integer> findEmptySlots(boolean withXCarry) {
        ArrayList<Integer> outPut = new ArrayList<Integer>();
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil.getInventoryAndHotbarSlots().entrySet()) {
            if (!entry.getValue().field_190928_g && entry.getValue().func_77973_b() != Items.field_190931_a) continue;
            outPut.add(entry.getKey());
        }
        if (withXCarry) {
            for (int i = 1; i < 5; ++i) {
                Slot craftingSlot = (Slot)InventoryUtil.mc.field_71439_g.field_71069_bz.field_75151_b.get(i);
                ItemStack craftingStack = craftingSlot.func_75211_c();
                if (!craftingStack.func_190926_b() && craftingStack.func_77973_b() != Items.field_190931_a) continue;
                outPut.add(i);
            }
        }
        return outPut;
    }

    public static int findArmorSlot(EntityEquipmentSlot type, boolean binding) {
        int slot = -1;
        float damage = 0.0f;
        for (int i = 9; i < 45; ++i) {
            ItemArmor armor;
            ItemStack s = Minecraft.func_71410_x().field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
            if (s.func_77973_b() == Items.field_190931_a || !(s.func_77973_b() instanceof ItemArmor) || (armor = (ItemArmor)s.func_77973_b()).func_185083_B_() != type) continue;
            float currentDamage = armor.field_77879_b + EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_180310_c, (ItemStack)s);
            boolean cursed = binding && EnchantmentHelper.func_190938_b((ItemStack)s);
            boolean bl = cursed;
            if (!(currentDamage > damage) || cursed) continue;
            damage = currentDamage;
            slot = i;
        }
        return slot;
    }

    public static int findArmorSlot(EntityEquipmentSlot type, boolean binding, boolean withXCarry) {
        int slot = InventoryUtil.findArmorSlot(type, binding);
        if (slot == -1 && withXCarry) {
            float damage = 0.0f;
            for (int i = 1; i < 5; ++i) {
                ItemArmor armor;
                Slot craftingSlot = (Slot)InventoryUtil.mc.field_71439_g.field_71069_bz.field_75151_b.get(i);
                ItemStack craftingStack = craftingSlot.func_75211_c();
                if (craftingStack.func_77973_b() == Items.field_190931_a || !(craftingStack.func_77973_b() instanceof ItemArmor) || (armor = (ItemArmor)craftingStack.func_77973_b()).func_185083_B_() != type) continue;
                float currentDamage = armor.field_77879_b + EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_180310_c, (ItemStack)craftingStack);
                boolean cursed = binding && EnchantmentHelper.func_190938_b((ItemStack)craftingStack);
                boolean bl = cursed;
                if (!(currentDamage > damage) || cursed) continue;
                damage = currentDamage;
                slot = i;
            }
        }
        return slot;
    }

    public static class Task {
        private final int slot;
        private final boolean update;
        private final boolean quickClick;

        public Task() {
            this.update = true;
            this.slot = -1;
            this.quickClick = false;
        }

        public Task(int slot) {
            this.slot = slot;
            this.quickClick = false;
            this.update = false;
        }

        public Task(int slot, boolean quickClick) {
            this.slot = slot;
            this.quickClick = quickClick;
            this.update = false;
        }

        public void run() {
            if (this.update) {
                Global.mc.field_71442_b.func_78765_e();
            }
            if (this.slot != -1) {
                Global.mc.field_71442_b.func_187098_a(0, this.slot, 0, this.quickClick ? ClickType.QUICK_MOVE : ClickType.PICKUP, (EntityPlayer)Global.mc.field_71439_g);
            }
        }

        public boolean isSwitching() {
            return !this.update;
        }
    }
}

