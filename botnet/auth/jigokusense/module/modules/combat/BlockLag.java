/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.combat;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.util.Wrapper;

public class BlockLag
extends Module {
    public BlockLag() {
        super("Burrow", "Its just burrow in the name of blocklag.", 0, Module.Category.COMBAT);
    }

    @Override
    public void onEnable() {
        Wrapper.getPlayer().func_70664_aZ();
        Wrapper.getPlayer().field_70181_x -= 1.0;
    }
}

