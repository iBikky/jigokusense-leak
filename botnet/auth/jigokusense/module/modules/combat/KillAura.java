//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.util.EnumHand
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.JigokuSense;
import botnet.auth.jigokusense.event.events.PacketEvent;
import botnet.auth.jigokusense.manager.FriendsManager;
import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.setting.settings.SettingDouble;
import java.util.ArrayList;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;

public class KillAura
extends Module {
    private SettingBoolean onlySword = this.register("OnlySword", true);
    private SettingDouble range = this.register("Range", 5.5, 0.0, 7.0);
    private SettingBoolean rotate = this.register("Rotate", false);
    private SettingBoolean crits = this.register("Criticals", true);
    private SettingBoolean delay = this.register("Delay", true);
    private boolean isAttacking = false;
    @EventHandler
    private final Listener<PacketEvent.Send> receiveListener = new Listener<PacketEvent.Send>(event -> {
        if (event.getPacket() instanceof CPacketUseEntity) {
            CPacketUseEntity packet = (CPacketUseEntity)event.getPacket();
            if (this.crits.getValue() && packet.getAction().equals((Object)CPacketUseEntity.Action.ATTACK) && KillAura.mc.player != null && KillAura.mc.player.onGround && this.isAttacking) {
                KillAura.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(KillAura.mc.player.posX, KillAura.mc.player.posY + (double)0.1f, KillAura.mc.player.posZ, false));
                KillAura.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(KillAura.mc.player.posX, KillAura.mc.player.posY, KillAura.mc.player.posZ, false));
            }
        }
    }, new Predicate[0]);

    public KillAura() {
        super("KillAura", "", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (KillAura.mc.world.playerEntities.isEmpty()) {
            return;
        }
        if (this.onlySword.getValue() && !(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
            return;
        }
        ArrayList<EntityPlayer> list = new ArrayList<EntityPlayer>();
        for (EntityPlayer player : KillAura.mc.world.playerEntities) {
            if (player == KillAura.mc.player || (double)KillAura.mc.player.getDistance((Entity)player) > this.range.getValue() || player.getHealth() <= 0.0f || player.isDead || !FriendsManager.isFriend(player.getName())) continue;
            list.add(player);
        }
        if (list.isEmpty()) {
            return;
        }
        this.attack((EntityPlayer)list.get(0));
    }

    private void attack(EntityPlayer target) {
        if (KillAura.mc.player.getCooledAttackStrength(0.0f) >= 1.0f || !this.delay.getValue()) {
            this.isAttacking = true;
            if (this.rotate.getValue()) {
                JigokuSense.rotationManager.rotate(target.posX, target.posY, target.posZ);
            }
            KillAura.mc.playerController.attackEntity((EntityPlayer)KillAura.mc.player, (Entity)target);
            KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
            if (this.rotate.getValue()) {
                JigokuSense.rotationManager.reset();
            }
            this.isAttacking = false;
        }
    }
}

