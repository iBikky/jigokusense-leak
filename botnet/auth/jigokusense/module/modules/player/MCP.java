/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.lwjgl.input.Mouse
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.module.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

public class MCP
extends Module {
    private boolean clicked = false;

    public MCP() {
        super("MCP", "Middle click pearl.", 0, Module.Category.PLAYER);
    }

    @Override
    public void update() {
        if (Mouse.isButtonDown((int)2)) {
            if (!this.clicked) {
                this.throwPearl();
            }
            this.clicked = true;
        } else {
            this.clicked = false;
        }
    }

    private void throwPearl() {
        int oldslot = MCP.mc.field_71439_g.field_71071_by.field_70461_c;
        for (int i = 0; i < 9; ++i) {
            ItemStack Stack = MCP.mc.field_71439_g.field_71071_by.func_70301_a(i);
            if (MCP.mc.field_71439_g.field_71071_by.func_70301_a(i).func_190926_b() || !(Stack.func_77973_b() instanceof ItemEnderPearl)) continue;
            MCP.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketHeldItemChange(i));
            MCP.mc.field_71442_b.func_78765_e();
            break;
        }
        MCP.mc.field_71442_b.func_187101_a((EntityPlayer)MCP.mc.field_71439_g, (World)MCP.mc.field_71441_e, EnumHand.MAIN_HAND);
        MCP.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketHeldItemChange(oldslot));
        MCP.mc.field_71442_b.func_78765_e();
    }
}

