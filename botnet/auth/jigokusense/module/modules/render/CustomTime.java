//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 */
package botnet.auth.jigokusense.module.modules.render;

import botnet.auth.jigokusense.event.events.PacketEvent;
import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingDouble;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketTimeUpdate;

public class CustomTime
extends Module {
    long time = 0L;
    SettingDouble clientTime = this.register("Time", 18000.0, 0.0, 23992.0);
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener = new Listener<PacketEvent.Receive>(event -> {
        if (event.getPacket() instanceof SPacketTimeUpdate) {
            event.cancel();
        }
    }, new Predicate[0]);

    public CustomTime() {
        super("CustomTime", "Allows you to change game time.", 0, Module.Category.RENDER);
    }

    @Override
    public void onEnable() {
        this.time = CustomTime.mc.world.getWorldTime();
    }

    @Override
    public void update() {
        CustomTime.mc.world.setWorldTime((long)this.clientTime.getValue());
    }

    @Override
    public void onDisable() {
        CustomTime.mc.world.setWorldTime(this.time);
    }
}

