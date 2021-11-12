//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.util.BlockUtil;
import botnet.auth.jigokusense.util.InventoryUtil;
import botnet.auth.jigokusense.util.PlayerUtil;
import java.util.ArrayList;
import net.minecraft.block.BlockObsidian;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Surround
extends Module {
    SettingBoolean smart = this.register("Smart", false);
    SettingBoolean center = this.register("Center", true);
    SettingBoolean rotate = this.register("Rotate", false);
    private BlockPos startPos;
    private ArrayList<BlockPos> retryPos;
    double posY;
    private static final BlockPos[] surroundPos = new BlockPos[]{new BlockPos(0, -1, 0), new BlockPos(1, -1, 0), new BlockPos(-1, -1, 0), new BlockPos(0, -1, 1), new BlockPos(0, -1, -1), new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(0, 0, -1)};

    public Surround() {
        super("Surround", "", 0, Module.Category.COMBAT);
    }

    @Override
    public void onEnable() {
        if (this.nullCheck()) {
            return;
        }
        this.startPos = PlayerUtil.getPlayerPos();
        this.retryPos = new ArrayList();
        if (this.center.getValue()) {
            double y = Surround.mc.player.getPosition().getY();
            double x = Surround.mc.player.getPosition().getX();
            double z = Surround.mc.player.getPosition().getZ();
            Vec3d plusPlus = new Vec3d(x + 0.5, y, z + 0.5);
            Vec3d plusMinus = new Vec3d(x + 0.5, y, z - 0.5);
            Vec3d minusMinus = new Vec3d(x - 0.5, y, z - 0.5);
            Vec3d minusPlus = new Vec3d(x - 0.5, y, z + 0.5);
            if (this.getDst(plusPlus) < this.getDst(plusMinus) && this.getDst(plusPlus) < this.getDst(minusMinus) && this.getDst(plusPlus) < this.getDst(minusPlus)) {
                x = (double)Surround.mc.player.getPosition().getX() + 0.5;
                z = (double)Surround.mc.player.getPosition().getZ() + 0.5;
                this.centerPlayer(x, y, z);
            }
            if (this.getDst(plusMinus) < this.getDst(plusPlus) && this.getDst(plusMinus) < this.getDst(minusMinus) && this.getDst(plusMinus) < this.getDst(minusPlus)) {
                x = (double)Surround.mc.player.getPosition().getX() + 0.5;
                z = (double)Surround.mc.player.getPosition().getZ() - 0.5;
                this.centerPlayer(x, y, z);
            }
            if (this.getDst(minusMinus) < this.getDst(plusPlus) && this.getDst(minusMinus) < this.getDst(plusMinus) && this.getDst(minusMinus) < this.getDst(minusPlus)) {
                x = (double)Surround.mc.player.getPosition().getX() - 0.5;
                z = (double)Surround.mc.player.getPosition().getZ() - 0.5;
                this.centerPlayer(x, y, z);
            }
            if (this.getDst(minusPlus) < this.getDst(plusPlus) && this.getDst(minusPlus) < this.getDst(plusMinus) && this.getDst(minusPlus) < this.getDst(minusMinus)) {
                x = (double)Surround.mc.player.getPosition().getX() - 0.5;
                z = (double)Surround.mc.player.getPosition().getZ() + 0.5;
                this.centerPlayer(x, y, z);
            }
        }
        this.posY = Surround.mc.player.posY;
    }

    @Override
    public void update() {
        if (this.nullCheck()) {
            this.toggle();
            return;
        }
        if (this.posY < Surround.mc.player.posY) {
            this.toggle();
            return;
        }
        if (this.startPos != null && !this.startPos.equals((Object)PlayerUtil.getPlayerPos())) {
            this.toggle();
            return;
        }
        if (!this.retryPos.isEmpty() && this.retryPos.size() < surroundPos.length && this.smart.getValue()) {
            for (BlockPos pos : this.retryPos) {
                BlockPos newPos = this.addPos(pos);
                if (BlockUtil.isPositionPlaceable(newPos, false) < 2) continue;
                int slot = InventoryUtil.findHotbarBlock(BlockObsidian.class);
                if (slot == -1) {
                    this.toggle();
                }
                if (!BlockUtil.placeBlock(newPos, slot, this.rotate.getValue(), this.rotate.getValue())) continue;
                this.retryPos.remove(newPos);
            }
            return;
        }
        for (BlockPos pos : surroundPos) {
            BlockPos newPos = this.addPos(pos);
            if (BlockUtil.isPositionPlaceable(newPos, false) < 2) continue;
            int slot = InventoryUtil.findHotbarBlock(BlockObsidian.class);
            if (slot == -1) {
                this.toggle();
            }
            if (BlockUtil.placeBlock(newPos, slot, this.rotate.getValue(), this.rotate.getValue())) continue;
            this.retryPos.add(newPos);
        }
    }

    private BlockPos addPos(BlockPos pos) {
        BlockPos pPos = PlayerUtil.getPlayerPos(0.2);
        return new BlockPos(pPos.getX() + pos.getX(), pPos.getY() + pos.getY(), pPos.getZ() + pos.getZ());
    }

    private double getDst(Vec3d vec) {
        return Surround.mc.player.getPositionVector().distanceTo(vec);
    }

    private void centerPlayer(double x, double y, double z) {
        Surround.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(x, y, z, true));
        Surround.mc.player.setPosition(x, y, z);
    }
}

