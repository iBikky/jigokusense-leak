//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
        if (BowBombBypass.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && BowBombBypass.mc.player.isHandActive() && BowBombBypass.mc.player.getItemInUseMaxCount() >= 3) {
            BowBombBypass.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, BowBombBypass.mc.player.getHorizontalFacing()));
            BowBombBypass.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(BowBombBypass.mc.player.getActiveHand()));
            BowBombBypass.mc.player.stopActiveHand();
        }
    }
}

