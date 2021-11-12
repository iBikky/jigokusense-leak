/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.InputEvent$MouseInputEvent
 *  org.lwjgl.input.Mouse
 */
package botnet.auth.jigokusense.module.modules.player;

import botnet.auth.jigokusense.command.Messages;
import botnet.auth.jigokusense.manager.FriendsManager;
import botnet.auth.jigokusense.module.Module;
import java.util.function.Predicate;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Mouse;

public class MCF
extends Module {
    @EventHandler
    private final Listener<InputEvent.MouseInputEvent> listener = new Listener<InputEvent.MouseInputEvent>(event -> {
        if (MCF.mc.field_71476_x.field_72313_a.equals((Object)RayTraceResult.Type.ENTITY) && MCF.mc.field_71476_x.field_72308_g instanceof EntityPlayer && Mouse.isButtonDown((int)2)) {
            if (FriendsManager.isFriend(MCF.mc.field_71476_x.field_72308_g.func_70005_c_())) {
                FriendsManager.removeFriend(MCF.mc.field_71476_x.field_72308_g.func_70005_c_());
                Messages.sendClientMessage("removed friend: " + MCF.mc.field_71476_x.field_72308_g.func_70005_c_());
            } else {
                FriendsManager.addFriend(MCF.mc.field_71476_x.field_72308_g.func_70005_c_());
                Messages.sendSilentMessage("added friend: " + MCF.mc.field_71476_x.field_72308_g.func_70005_c_());
            }
        }
    }, new Predicate[0]);

    public MCF() {
        super("MCF", "Middle click friend.", 0, Module.Category.PLAYER);
    }
}

