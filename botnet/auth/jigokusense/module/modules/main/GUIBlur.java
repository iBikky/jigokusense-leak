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
        if (GUIBlur.mc.field_71441_e != null) {
            GUIBlur.mc.field_71460_t.func_147706_e().func_148021_a();
        }
    }

    @Override
    public void update() {
        if (GUIBlur.mc.field_71441_e != null) {
            if (GUIBlur.mc.field_71462_r == JigokuSense.instance.clickGui) {
                if (OpenGlHelper.field_148824_g && mc.func_175606_aa() instanceof EntityPlayer) {
                    if (GUIBlur.mc.field_71460_t.func_147706_e() != null) {
                        GUIBlur.mc.field_71460_t.func_147706_e().func_148021_a();
                    }
                    try {
                        GUIBlur.mc.field_71460_t.func_175069_a(new ResourceLocation("shaders/post/blur.json"));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (GUIBlur.mc.field_71460_t.func_147706_e() != null && GUIBlur.mc.field_71462_r == null) {
                    GUIBlur.mc.field_71460_t.func_147706_e().func_148021_a();
                }
            } else if (GUIBlur.mc.field_71460_t.func_147706_e() != null) {
                GUIBlur.mc.field_71460_t.func_147706_e().func_148021_a();
            }
        }
    }
}

