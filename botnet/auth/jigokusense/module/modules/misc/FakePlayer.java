//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 */
package botnet.auth.jigokusense.module.modules.misc;

import botnet.auth.jigokusense.module.Module;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class FakePlayer
extends Module {
    private EntityOtherPlayerMP bot;

    public FakePlayer() {
        super("FakePlayer", "Spawns a bot", 0, Module.Category.MISC);
    }

    @Override
    public void onEnable() {
        if (FakePlayer.mc.player.isDead) {
            this.disable();
            return;
        }
        this.bot = new EntityOtherPlayerMP((World)FakePlayer.mc.world, new GameProfile(UUID.fromString("5a49ea7d-c511-46e2-a9d4-03fa8793978c"), "AK6969"));
        this.bot.copyLocationAndAnglesFrom((Entity)FakePlayer.mc.player);
        this.bot.rotationYawHead = FakePlayer.mc.player.rotationYawHead;
        this.bot.rotationYaw = FakePlayer.mc.player.rotationYaw;
        this.bot.rotationPitch = FakePlayer.mc.player.rotationPitch;
        this.bot.setGameType(GameType.SURVIVAL);
        this.bot.setHealth(20.0f);
        FakePlayer.mc.world.addEntityToWorld(-1337, (Entity)this.bot);
        this.bot.onLivingUpdate();
    }

    @Override
    public void onDisable() {
        if (FakePlayer.mc.world != null) {
            FakePlayer.mc.world.removeEntityFromWorld(-1337);
        }
    }
}

