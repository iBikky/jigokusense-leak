//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.util.MovementInput
 */
package botnet.auth.jigokusense.module.modules.movement;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.setting.settings.SettingDouble;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.MovementInput;

public class EntitySpeed
extends Module {
    SettingDouble speed = this.register("Speed", 1.0, 0.1, 5.0);

    public EntitySpeed() {
        super("EntitySpeed", "", 0, Module.Category.MOVEMENT);
    }

    @Override
    public void update() {
        try {
            if (EntitySpeed.mc.player.getRidingEntity() != null) {
                Entity theEntity = EntitySpeed.mc.player.getRidingEntity();
                EntitySpeed.speedEntity(theEntity, this.speed.getValue());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void speedEntity(Entity entity, Double speed) {
        if (entity instanceof EntityLlama) {
            entity.rotationYaw = EntitySpeed.mc.player.rotationYaw;
            ((EntityLlama)entity).rotationYawHead = EntitySpeed.mc.player.rotationYawHead;
        }
        MovementInput movementInput = EntitySpeed.mc.player.movementInput;
        double forward = movementInput.moveForward;
        double strafe = movementInput.moveStrafe;
        float yaw = EntitySpeed.mc.player.rotationYaw;
        if (forward == 0.0 && strafe == 0.0) {
            entity.motionX = 0.0;
            entity.motionZ = 0.0;
        } else {
            if (forward != 0.0) {
                if (strafe > 0.0) {
                    yaw += (float)(forward > 0.0 ? -45 : 45);
                } else if (strafe < 0.0) {
                    yaw += (float)(forward > 0.0 ? 45 : -45);
                }
                strafe = 0.0;
                if (forward > 0.0) {
                    forward = 1.0;
                } else if (forward < 0.0) {
                    forward = -1.0;
                }
            }
            entity.motionX = forward * speed * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0f));
            entity.motionZ = forward * speed * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0f));
            if (entity instanceof EntityMinecart) {
                EntityMinecart em = (EntityMinecart)entity;
                em.setVelocity(forward * speed * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0f)), em.motionY, forward * speed * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0f)));
            }
        }
    }
}

