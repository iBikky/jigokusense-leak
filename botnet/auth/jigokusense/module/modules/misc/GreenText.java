/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.ClientChatEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package botnet.auth.jigokusense.module.modules.misc;

import botnet.auth.jigokusense.module.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GreenText
extends Module {
    String GREATERTHAN = ">";

    public GreenText() {
        super("GreenText", "Makes Ur Text Green By Putting a >", 0, Module.Category.MISC);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(".") || event.getMessage().startsWith(",") || event.getMessage().startsWith("-") || event.getMessage().startsWith("$") || event.getMessage().startsWith("*")) {
            return;
        }
        event.setMessage(this.GREATERTHAN + event.getMessage());
    }
}

