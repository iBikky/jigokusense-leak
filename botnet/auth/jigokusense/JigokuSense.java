/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Stopwatch
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.Mod$Instance
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  org.lwjgl.opengl.Display
 */
package botnet.auth.jigokusense;

import botnet.auth.jigokusense.event.EventProcessor;
import botnet.auth.jigokusense.gui.Screen;
import botnet.auth.jigokusense.manager.ConfigManager;
import botnet.auth.jigokusense.manager.FontManager;
import botnet.auth.jigokusense.manager.PositionManager;
import botnet.auth.jigokusense.manager.RotationManager;
import botnet.auth.jigokusense.manager.ServerManager;
import botnet.auth.jigokusense.module.ModuleManager;
import botnet.auth.jigokusense.setting.SettingsManager;
import com.google.common.base.Stopwatch;
import me.zero.alpine.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;

@Mod(modid="jigokusense", name="JigokuSense", version="1.0.0")
public class JigokuSense {
    public static final String MODID = "jigokusense";
    public static final String NAME = "JigokuSense";
    public static final String VERSION = "1.0.0";
    public static final String NAME_VERSION = "Jigoku Sense - 1.0.0";
    @Mod.Instance
    public static JigokuSense instance = new JigokuSense();
    public static final EventManager EVENT_BUS = new EventManager();
    public static ModuleManager moduleManager;
    public static SettingsManager settingsManager;
    public static FontManager fontManager;
    public static ServerManager serverManager;
    public static RotationManager rotationManager;
    public static PositionManager positionManager;
    public Screen clickGui;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register((Object)instance);
        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        fontManager = new FontManager();
        serverManager = new ServerManager();
        rotationManager = new RotationManager();
        positionManager = new PositionManager();
        new EventProcessor();
        this.clickGui = new Screen();
        Stopwatch watch = Stopwatch.createStarted();
        ConfigManager.load();
        System.out.printf("JigokuSense load config took %sms", watch.stop());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle((String)"JigokuSense | 1.0.0 | Added You To The Botnet :troll:");
    }
}

