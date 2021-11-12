/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Stopwatch
 *  net.minecraft.client.Minecraft
 */
package botnet.auth.jigokusense.mixin.mixins;

import botnet.auth.jigokusense.manager.ConfigManager;
import com.google.common.base.Stopwatch;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class})
public class MixinMinecraft {
    @Inject(method={"shutdown"}, at={@At(value="HEAD")})
    public void onShutdown(CallbackInfo ci) {
        Stopwatch watch = Stopwatch.createStarted();
        ConfigManager.save();
        System.out.printf("jigokusense save config took %sms", watch.stop());
    }
}

