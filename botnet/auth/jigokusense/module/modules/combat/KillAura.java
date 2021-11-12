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
            if (this.crits.getValue() && packet.func_149565_c().equals((Object)CPacketUseEntity.Action.ATTACK) && KillAura.mc.field_71439_g != null && KillAura.mc.field_71439_g.field_70122_E && this.isAttacking) {
                KillAura.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u + (double)0.1f, KillAura.mc.field_71439_g.field_70161_v, false));
                KillAura.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u, KillAura.mc.field_71439_g.field_70161_v, false));
            }
        }
    }, new Predicate[0]);

    public KillAura() {
        super("KillAura", "", 0, Module.Category.COMBAT);
    }

    @Override
    public void update() {
        if (KillAura.mc.field_71441_e.field_73010_i.isEmpty()) {
            return;
        }
        if (this.onlySword.getValue() && !(KillAura.mc.field_71439_g.func_184614_ca().func_77973_b() instanceof ItemSword)) {
            return;
        }
        ArrayList<EntityPlayer> list = new ArrayList<EntityPlayer>();
        for (EntityPlayer player : KillAura.mc.field_71441_e.field_73010_i) {
            if (player == KillAura.mc.field_71439_g || (double)KillAura.mc.field_71439_g.func_70032_d((Entity)player) > this.range.getValue() || player.func_110143_aJ() <= 0.0f || player.field_70128_L || !FriendsManager.isFriend(player.func_70005_c_())) continue;
            list.add(player);
        }
        if (list.isEmpty()) {
            return;
        }
        this.attack((EntityPlayer)list.get(0));
    }

    private void attack(EntityPlayer target) {
        if (KillAura.mc.field_71439_g.func_184825_o(0.0f) >= 1.0f || !this.delay.getValue()) {
            this.isAttacking = true;
            if (this.rotate.getValue()) {
                JigokuSense.rotationManager.rotate(target.field_70165_t, target.field_70163_u, target.field_70161_v);
            }
            KillAura.mc.field_71442_b.func_78764_a((EntityPlayer)KillAura.mc.field_71439_g, (Entity)target);
            KillAura.mc.field_71439_g.func_184609_a(EnumHand.MAIN_HAND);
            if (this.rotate.getValue()) {
                JigokuSense.rotationManager.reset();
            }
            this.isAttacking = false;
        }
    }
}

