//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.util.EnumHand
 */
package botnet.auth.jigokusense.module.modules.misc;

import botnet.auth.jigokusense.event.events.PacketEvent;
import botnet.auth.jigokusense.module.Module;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumHand;

public class AutoFish
extends Module {
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener = new Listener<PacketEvent.Receive>(event -> {
        SPacketSoundEffect packet;
        if (event.getPacket() instanceof SPacketSoundEffect && (packet = (SPacketSoundEffect)event.getPacket()).getSound().equals(SoundEvents.ENTITY_BOBBER_SPLASH)) {
            if (AutoFish.mc.player.getHeldItemMainhand().getItem() instanceof ItemFishingRod) {
                AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoFish.mc.player.swingArm(EnumHand.MAIN_HAND);
                AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoFish.mc.player.swingArm(EnumHand.MAIN_HAND);
            }
            if (AutoFish.mc.player.getHeldItemOffhand().getItem() instanceof ItemFishingRod) {
                AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                AutoFish.mc.player.swingArm(EnumHand.OFF_HAND);
                AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                AutoFish.mc.player.swingArm(EnumHand.OFF_HAND);
            }
        }
    }, new Predicate[0]);

    public AutoFish() {
        super("AutoFish", "Fishes automatically.", 0, Module.Category.MISC);
    }
}

