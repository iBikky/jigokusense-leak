/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package botnet.auth.jigokusense.command;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class Messages {
    public static void sendPlayerMessage(String ... message) {
        for (String m : message) {
            Minecraft.func_71410_x().field_71439_g.func_71165_d(m);
        }
    }

    public static void sendSilentMessage(String ... message) {
        for (String m : message) {
            Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString(m));
        }
    }

    public static void sendClientMessage(String ... message) {
        for (String m : message) {
            String prefix = ChatFormatting.DARK_RED + "[" + "JigokuSense" + "] " + ChatFormatting.RESET;
            Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString(prefix + m));
        }
    }
}

