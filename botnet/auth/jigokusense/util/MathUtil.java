/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 */
package botnet.auth.jigokusense.util;

import botnet.auth.jigokusense.util.Global;
import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.util.math.Vec3d;

public class MathUtil
implements Global {
    public static Vec3d roundVec(Vec3d vec3d, int places) {
        return new Vec3d(MathUtil.round(vec3d.field_72450_a, places), MathUtil.round(vec3d.field_72448_b, places), MathUtil.round(vec3d.field_72449_c, places));
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.FLOOR);
        return bd.doubleValue();
    }
}

