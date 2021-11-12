/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package botnet.auth.jigokusense.module.modules.main;

import botnet.auth.jigokusense.JigokuSense;
import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingBoolean;
import botnet.auth.jigokusense.util.RenderUtil;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud
extends Module {
    SettingBoolean csgowatermark = this.register("CoolWatermark", true);
    SettingBoolean watermark = this.register("Watermark", true);
    SettingBoolean greeter = this.register("Greeter", true);
    SettingBoolean ping = this.register("Ping", true);
    SettingBoolean fps = this.register("Fps", true);

    public Hud() {
        super("Hud", "Its Hud Does it Need A Explanation?", 0, Module.Category.MAIN);
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR && this.csgowatermark.getValue()) {
            String ping = JigokuSense.serverManager.getPing() + "ms ";
            String server = mc.func_71356_B() ? "singleplayer" : Objects.requireNonNull(Hud.mc.func_147104_D()).field_78845_b;
            String time = new SimpleDateFormat("k:mm").format(new Date());
            String name = Hud.mc.field_71439_g.func_70005_c_();
            String text = " JigokuSense | " + name + " | " + time + " | " + server + " | " + ping;
            float width = JigokuSense.fontManager.getStringWidth(text) + 6;
            int height = 20;
            int posX = 2;
            int posY = 2;
            RenderUtil.drawRect(posX, posY, (float)posX + width + 2.0f, posY + height, new Color(5, 5, 5, 255).getRGB());
            RenderUtil.drawBorderedRect((double)posX + 0.5, (double)posY + 0.5, (double)((float)posX + width) + 1.5, (double)(posY + height) - 0.5, 0.5, new Color(40, 40, 40, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
            RenderUtil.drawBorderedRect(posX + 2, posY + 2, (float)posX + width, posY + height - 2, 0.5, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
            RenderUtil.drawRect((double)posX + 2.5, (double)posY + 2.5, (double)((float)posX + width) - 0.5, (double)posY + 4.5, new Color(9, 9, 9, 255).getRGB());
            RenderUtil.drawGradientSideways(4.0, posY + 3, 4.0f + width / 3.0f, posY + 4, new Color(81, 149, 219, 255).getRGB(), new Color(180, 49, 218, 255).getRGB());
            RenderUtil.drawGradientSideways(4.0f + width / 3.0f, posY + 3, 4.0f + width / 3.0f * 2.0f, posY + 4, new Color(180, 49, 218, 255).getRGB(), new Color(236, 93, 128, 255).getRGB());
            RenderUtil.drawGradientSideways(4.0f + width / 3.0f * 2.0f, posY + 3, width / 3.0f * 3.0f + 1.0f, posY + 4, new Color(236, 93, 128, 255).getRGB(), new Color(235, 255, 0, 255).getRGB());
            JigokuSense.fontManager.drawStringWithShadow(text, 4 + posX, 8 + posY, -1);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (this.greeter.getValue()) {
                JigokuSense.fontManager.drawStringWithShadow("Welcome to JigokuSense, " + Hud.mc.field_71439_g.func_70005_c_(), 250.0f, 2.0f, -51);
            }
            int i = -8;
            if (this.watermark.getValue()) {
                JigokuSense.fontManager.drawStringWithShadow("Jigoku Sense - 1.0.0", 2.0f, i += 10, -51);
            }
            if (this.ping.getValue()) {
                String ping = "Ping " + JigokuSense.serverManager.getPing();
                JigokuSense.fontManager.drawStringWithShadow(ping, 2.0f, i += 10, -51);
            }
            if (this.fps.getValue()) {
                String fps = "FPS " + Minecraft.field_71470_ab;
                JigokuSense.fontManager.drawStringWithShadow(fps, 2.0f, i += 10, -51);
            }
        }
    }
}

