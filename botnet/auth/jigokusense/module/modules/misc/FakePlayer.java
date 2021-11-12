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
        if (FakePlayer.mc.field_71439_g.field_70128_L) {
            this.disable();
            return;
        }
        this.bot = new EntityOtherPlayerMP((World)FakePlayer.mc.field_71441_e, new GameProfile(UUID.fromString("5a49ea7d-c511-46e2-a9d4-03fa8793978c"), "AK6969"));
        this.bot.func_82149_j((Entity)FakePlayer.mc.field_71439_g);
        this.bot.field_70759_as = FakePlayer.mc.field_71439_g.field_70759_as;
        this.bot.field_70177_z = FakePlayer.mc.field_71439_g.field_70177_z;
        this.bot.field_70125_A = FakePlayer.mc.field_71439_g.field_70125_A;
        this.bot.func_71033_a(GameType.SURVIVAL);
        this.bot.func_70606_j(20.0f);
        FakePlayer.mc.field_71441_e.func_73027_a(-1337, (Entity)this.bot);
        this.bot.func_70636_d();
    }

    @Override
    public void onDisable() {
        if (FakePlayer.mc.field_71441_e != null) {
            FakePlayer.mc.field_71441_e.func_73028_b(-1337);
        }
    }
}

