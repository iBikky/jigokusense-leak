//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Keyboard
 */
package botnet.auth.jigokusense.module;

import botnet.auth.jigokusense.module.Module;
import botnet.auth.jigokusense.module.modules.combat.AutoArmor;
import botnet.auth.jigokusense.module.modules.combat.BowBombBypass;
import botnet.auth.jigokusense.module.modules.combat.KillAura;
import botnet.auth.jigokusense.module.modules.combat.Offhand;
import botnet.auth.jigokusense.module.modules.combat.Quiver;
import botnet.auth.jigokusense.module.modules.combat.Replenish;
import botnet.auth.jigokusense.module.modules.combat.SilentXP;
import botnet.auth.jigokusense.module.modules.combat.Surround;
import botnet.auth.jigokusense.module.modules.main.CAPES;
import botnet.auth.jigokusense.module.modules.main.GUI;
import botnet.auth.jigokusense.module.modules.main.GUIBlur;
import botnet.auth.jigokusense.module.modules.main.Hud;
import botnet.auth.jigokusense.module.modules.misc.AutoFish;
import botnet.auth.jigokusense.module.modules.misc.ChestStealer;
import botnet.auth.jigokusense.module.modules.misc.FakePlayer;
import botnet.auth.jigokusense.module.modules.misc.FastPlace;
import botnet.auth.jigokusense.module.modules.misc.GreenText;
import botnet.auth.jigokusense.module.modules.misc.JigokuPrefix;
import botnet.auth.jigokusense.module.modules.movement.Anchor;
import botnet.auth.jigokusense.module.modules.movement.AutoWalk;
import botnet.auth.jigokusense.module.modules.movement.BoatFly;
import botnet.auth.jigokusense.module.modules.movement.EntitySpeed;
import botnet.auth.jigokusense.module.modules.movement.ReverseStep;
import botnet.auth.jigokusense.module.modules.movement.Speed;
import botnet.auth.jigokusense.module.modules.movement.Sprint;
import botnet.auth.jigokusense.module.modules.movement.Step;
import botnet.auth.jigokusense.module.modules.player.AntiHunger;
import botnet.auth.jigokusense.module.modules.player.AntiVoid;
import botnet.auth.jigokusense.module.modules.player.AutoRespawn;
import botnet.auth.jigokusense.module.modules.player.Gamemode;
import botnet.auth.jigokusense.module.modules.player.MCF;
import botnet.auth.jigokusense.module.modules.player.MCP;
import botnet.auth.jigokusense.module.modules.player.Vanish;
import botnet.auth.jigokusense.module.modules.player.Velocity;
import botnet.auth.jigokusense.module.modules.render.CustomTime;
import botnet.auth.jigokusense.module.modules.render.FullBright;
import botnet.auth.jigokusense.module.modules.render.NoRender;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList();

    public ModuleManager() {
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.init();
    }

    public void init() {
        this.modules.add(new Offhand());
        this.modules.add(new AutoArmor());
        this.modules.add(new AutoRespawn());
        this.modules.add(new AntiHunger());
        this.modules.add(new AutoWalk());
        this.modules.add(new AntiVoid());
        this.modules.add(new AutoFish());
        this.modules.add(new GUI());
        this.modules.add(new Anchor());
        this.modules.add(new Speed());
        this.modules.add(new GreenText());
        this.modules.add(new JigokuPrefix());
        this.modules.add(new BowBombBypass());
        this.modules.add(new CAPES());
        this.modules.add(new FakePlayer());
        this.modules.add(new ReverseStep());
        this.modules.add(new Step());
        this.modules.add(new Sprint());
        this.modules.add(new BoatFly());
        this.modules.add(new Velocity());
        this.modules.add(new FullBright());
        this.modules.add(new Gamemode());
        this.modules.add(new CustomTime());
        this.modules.add(new Quiver());
        this.modules.add(new NoRender());
        this.modules.add(new FastPlace());
        this.modules.add(new ChestStealer());
        this.modules.add(new EntitySpeed());
        this.modules.add(new Vanish());
        this.modules.add(new MCP());
        this.modules.add(new KillAura());
        this.modules.add(new Hud());
        this.modules.add(new Replenish());
        this.modules.add(new SilentXP());
        this.modules.add(new MCF());
        this.modules.add(new Surround());
        this.modules.add(new GUIBlur());
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public Module getModule(String name) {
        for (Module m : this.modules) {
            if (!m.getName().equalsIgnoreCase(name)) continue;
            return m;
        }
        return null;
    }

    public ArrayList<Module> getModsInCategory(Module.Category cat) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : this.modules) {
            if (m.getCategory() != cat) continue;
            mods.add(m);
        }
        return mods;
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            for (Module m : this.modules) {
                if (m.getKey() != Keyboard.getEventKey()) continue;
                m.toggle();
            }
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null) {
            return;
        }
        for (Module m : this.modules) {
            if (!m.isToggled()) continue;
            m.update();
        }
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        for (Module m : this.modules) {
            if (!m.isToggled()) continue;
            m.render();
        }
    }
}

