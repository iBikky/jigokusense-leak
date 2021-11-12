/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.util.Wrapper;

public class BoatFly
extends Module {
    public BoatFly() {
        super("BoatFly", "Make u fly high in the sky with a boat.", 0, Module.Category.MOVEMENT);
    }

    public void onUpdate() {
        if (Wrapper.mc.field_71439_g.func_184187_bx() != null && Wrapper.mc.field_71474_y.field_74314_A.func_151470_d()) {
            Wrapper.mc.field_71439_g.func_184187_bx().field_70181_x = 0.1;
        }
    }
}

