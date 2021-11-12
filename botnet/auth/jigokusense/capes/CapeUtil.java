//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.util.ResourceLocation
 */
package botnet.auth.jigokusense.capes;

import botnet.auth.jigokusense.util.Wrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

public class CapeUtil {
    public static ArrayList<String> lines;
    public static List<ResourceLocation> capeStuff;

    public static void getUsersCape() {
        try {
            String line;
            URL url = new URL("https://pastebin.com/raw/yRkcBzGV");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isCapeUser(String name) {
        return lines.contains(name);
    }

    static {
        capeStuff = new ArrayList<ResourceLocation>();
        try {
            capeStuff.add(Wrapper.mc.getTextureManager().getDynamicTextureLocation("assets/textures", new DynamicTexture(ImageIO.read(new URL("https://imgur.com/a/W84LYTB")))));
            capeStuff.add(Wrapper.mc.getTextureManager().getDynamicTextureLocation("assets/textures", new DynamicTexture(ImageIO.read(new URL("https://imgur.com/a/W84LYTB")))));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        lines = new ArrayList();
    }
}

