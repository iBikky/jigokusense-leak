//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

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
        if (MCF.mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && MCF.mc.objectMouseOver.entityHit instanceof EntityPlayer && Mouse.isButtonDown((int)2)) {
            if (FriendsManager.isFriend(MCF.mc.objectMouseOver.entityHit.getName())) {
                FriendsManager.removeFriend(MCF.mc.objectMouseOver.entityHit.getName());
                Messages.sendClientMessage("removed friend: " + MCF.mc.objectMouseOver.entityHit.getName());
            } else {
                FriendsManager.addFriend(MCF.mc.objectMouseOver.entityHit.getName());
                Messages.sendSilentMessage("added friend: " + MCF.mc.objectMouseOver.entityHit.getName());
            }
        }
    }, new Predicate[0]);

    public MCF() {
        super("MCF", "Middle click friend.", 0, Module.Category.PLAYER);
    }
}

