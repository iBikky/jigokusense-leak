//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 */
package botnet.auth.jigokusense.module.modules.main;

import botnet.auth.jigokusense.JigokuSense;
import botnet.auth.jigokusense.module.Module;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIBlur
extends Module {
    public GUIBlur() {
        super("GUIBlur", "", 0, Module.Category.MAIN);
    }

    @Override
    public void onDisable() {
        if (GUIBlur.mc.world != null) {
            GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
        }
    }

    @Override
    public void update() {
        if (GUIBlur.mc.world != null) {
            if (GUIBlur.mc.currentScreen == JigokuSense.instance.clickGui) {
                if (OpenGlHelper.shadersSupported && mc.getRenderViewEntity() instanceof EntityPlayer) {
                    if (GUIBlur.mc.entityRenderer.getShaderGroup() != null) {
                        GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
                    }
                    try {
                        GUIBlur.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (GUIBlur.mc.entityRenderer.getShaderGroup() != null && GUIBlur.mc.currentScreen == null) {
                    GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
                }
            } else if (GUIBlur.mc.entityRenderer.getShaderGroup() != null) {
                GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
            }
        }
    }
}

