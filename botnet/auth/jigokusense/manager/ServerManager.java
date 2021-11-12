/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package botnet.auth.jigokusense.manager;

import botnet.auth.jigokusense.util.Timer;
import java.text.DecimalFormat;
import java.util.Objects;
import net.minecraft.client.Minecraft;

public class ServerManager {
    public static final Minecraft mc = Minecraft.func_71410_x();
    private final float[] tpsCounts = new float[10];
    private final DecimalFormat format = new DecimalFormat("##.00#");
    private final Timer timer = new Timer();
    private float TPS = 20.0f;
    private long lastUpdate = -1L;
    private String serverBrand = "";

    public void onPacketReceived() {
        this.timer.reset();
    }

    public long serverRespondingTime() {
        return this.timer.getPassedTimeMs();
    }

    public void update() {
        double d;
        float f;
        long currentTime = System.currentTimeMillis();
        if (this.lastUpdate == -1L) {
            this.lastUpdate = currentTime;
            return;
        }
        long timeDiff = currentTime - this.lastUpdate;
        float tickTime = (float)timeDiff / 20.0f;
        if (tickTime == 0.0f) {
            tickTime = 50.0f;
        }
        float tps = 1000.0f / tickTime;
        if (f > 20.0f) {
            tps = 20.0f;
        }
        System.arraycopy(this.tpsCounts, 0, this.tpsCounts, 1, this.tpsCounts.length - 1);
        this.tpsCounts[0] = tps;
        double total = 0.0;
        for (float f2 : this.tpsCounts) {
            total += (double)f2;
        }
        total /= (double)this.tpsCounts.length;
        if (d > 20.0) {
            total = 20.0;
        }
        this.TPS = Float.parseFloat(this.format.format(total));
        this.lastUpdate = currentTime;
    }

    public float getTpsFactor() {
        return 20.0f / this.TPS;
    }

    public float getTPS() {
        return this.TPS;
    }

    public String getServerBrand() {
        return this.serverBrand;
    }

    public void setServerBrand(String brand) {
        this.serverBrand = brand;
    }

    public int getPing() {
        if (ServerManager.mc.field_71439_g == null || ServerManager.mc.field_71441_e == null) {
            return 0;
        }
        try {
            return Objects.requireNonNull(mc.func_147114_u()).func_175102_a(mc.func_147114_u().func_175105_e().getId()).func_178853_c();
        }
        catch (Exception e) {
            return 0;
        }
    }
}

