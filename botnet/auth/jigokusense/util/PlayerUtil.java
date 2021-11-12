/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package botnet.auth.jigokusense.util;

import botnet.auth.jigokusense.util.Global;
import net.minecraft.util.math.BlockPos;

public class PlayerUtil
implements Global {
    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(PlayerUtil.mc.field_71439_g.field_70165_t), Math.floor(PlayerUtil.mc.field_71439_g.field_70163_u), Math.floor(PlayerUtil.mc.field_71439_g.field_70161_v));
    }

    public static BlockPos getPlayerPos(double pY) {
        return new BlockPos(Math.floor(PlayerUtil.mc.field_71439_g.field_70165_t), Math.floor(PlayerUtil.mc.field_71439_g.field_70163_u + pY), Math.floor(PlayerUtil.mc.field_71439_g.field_70161_v));
    }
}

