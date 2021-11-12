//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\autty\Downloads\Minecraft-Deobfuscator3000-master\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.GLU
 */
package com.lukflug.panelstudio.mc12;

import com.lukflug.panelstudio.Interface;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Stack;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public abstract class GLInterface
implements Interface {
    private static final FloatBuffer MODELVIEW = GLAllocation.createDirectFloatBuffer((int)16);
    private static final FloatBuffer PROJECTION = GLAllocation.createDirectFloatBuffer((int)16);
    private static final IntBuffer VIEWPORT = GLAllocation.createDirectIntBuffer((int)16);
    private static final FloatBuffer COORDS = GLAllocation.createDirectFloatBuffer((int)3);
    private Stack<Rectangle> clipRect = new Stack();
    protected boolean clipX;

    public GLInterface(boolean clipX) {
        this.clipX = clipX;
    }

    @Override
    public void fillTriangle(Point pos1, Point pos2, Point pos3, Color c1, Color c2, Color c3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(4, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double)pos1.x, (double)pos1.y, (double)this.getZLevel()).color((float)c1.getRed() / 255.0f, (float)c1.getGreen() / 255.0f, (float)c1.getBlue() / 255.0f, (float)c1.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)pos2.x, (double)pos2.y, (double)this.getZLevel()).color((float)c2.getRed() / 255.0f, (float)c2.getGreen() / 255.0f, (float)c2.getBlue() / 255.0f, (float)c2.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)pos3.x, (double)pos3.y, (double)this.getZLevel()).color((float)c3.getRed() / 255.0f, (float)c3.getGreen() / 255.0f, (float)c3.getBlue() / 255.0f, (float)c3.getAlpha() / 255.0f).endVertex();
        tessellator.draw();
    }

    @Override
    public void drawLine(Point a, Point b, Color c1, Color c2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double)a.x, (double)a.y, (double)this.getZLevel()).color((float)c1.getRed() / 255.0f, (float)c1.getGreen() / 255.0f, (float)c1.getBlue() / 255.0f, (float)c1.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)b.x, (double)b.y, (double)this.getZLevel()).color((float)c2.getRed() / 255.0f, (float)c2.getGreen() / 255.0f, (float)c2.getBlue() / 255.0f, (float)c2.getAlpha() / 255.0f).endVertex();
        tessellator.draw();
    }

    @Override
    public void fillRect(Rectangle r, Color c1, Color c2, Color c3, Color c4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double)r.x, (double)(r.y + r.height), (double)this.getZLevel()).color((float)c4.getRed() / 255.0f, (float)c4.getGreen() / 255.0f, (float)c4.getBlue() / 255.0f, (float)c4.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)(r.x + r.width), (double)(r.y + r.height), (double)this.getZLevel()).color((float)c3.getRed() / 255.0f, (float)c3.getGreen() / 255.0f, (float)c3.getBlue() / 255.0f, (float)c3.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)(r.x + r.width), (double)r.y, (double)this.getZLevel()).color((float)c2.getRed() / 255.0f, (float)c2.getGreen() / 255.0f, (float)c2.getBlue() / 255.0f, (float)c2.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)r.x, (double)r.y, (double)this.getZLevel()).color((float)c1.getRed() / 255.0f, (float)c1.getGreen() / 255.0f, (float)c1.getBlue() / 255.0f, (float)c1.getAlpha() / 255.0f).endVertex();
        tessellator.draw();
    }

    @Override
    public void drawRect(Rectangle r, Color c1, Color c2, Color c3, Color c4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(2, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double)r.x, (double)(r.y + r.height), (double)this.getZLevel()).color((float)c4.getRed() / 255.0f, (float)c4.getGreen() / 255.0f, (float)c4.getBlue() / 255.0f, (float)c4.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)(r.x + r.width), (double)(r.y + r.height), (double)this.getZLevel()).color((float)c3.getRed() / 255.0f, (float)c3.getGreen() / 255.0f, (float)c3.getBlue() / 255.0f, (float)c3.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)(r.x + r.width), (double)r.y, (double)this.getZLevel()).color((float)c2.getRed() / 255.0f, (float)c2.getGreen() / 255.0f, (float)c2.getBlue() / 255.0f, (float)c2.getAlpha() / 255.0f).endVertex();
        bufferbuilder.pos((double)r.x, (double)r.y, (double)this.getZLevel()).color((float)c1.getRed() / 255.0f, (float)c1.getGreen() / 255.0f, (float)c1.getBlue() / 255.0f, (float)c1.getAlpha() / 255.0f).endVertex();
        tessellator.draw();
    }

    @Override
    public synchronized int loadImage(String name) {
        try {
            ResourceLocation rl = new ResourceLocation(this.getResourcePrefix() + name);
            InputStream stream = Minecraft.getMinecraft().getResourceManager().getResource(rl).getInputStream();
            BufferedImage image = ImageIO.read(stream);
            int texture = TextureUtil.glGenTextures();
            TextureUtil.uploadTextureImage((int)texture, (BufferedImage)image);
            return texture;
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void drawImage(Rectangle r, int rotation, boolean parity, int image) {
        if (image == 0) {
            return;
        }
        int[][] texCoords = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, 0}};
        for (int i = 0; i < rotation % 4; ++i) {
            int temp1 = texCoords[3][0];
            int temp2 = texCoords[3][1];
            texCoords[3][0] = texCoords[2][0];
            texCoords[3][1] = texCoords[2][1];
            texCoords[2][0] = texCoords[1][0];
            texCoords[2][1] = texCoords[1][1];
            texCoords[1][0] = texCoords[0][0];
            texCoords[1][1] = texCoords[0][1];
            texCoords[0][0] = temp1;
            texCoords[0][1] = temp2;
        }
        if (parity) {
            int temp1 = texCoords[3][0];
            int temp2 = texCoords[3][1];
            texCoords[3][0] = texCoords[0][0];
            texCoords[3][1] = texCoords[0][1];
            texCoords[0][0] = temp1;
            texCoords[0][1] = temp2;
            temp1 = texCoords[2][0];
            temp2 = texCoords[2][1];
            texCoords[2][0] = texCoords[1][0];
            texCoords[2][1] = texCoords[1][1];
            texCoords[1][0] = temp1;
            texCoords[1][1] = temp2;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        GlStateManager.bindTexture((int)image);
        GlStateManager.enableTexture2D();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((double)r.x, (double)(r.y + r.height), (double)this.getZLevel()).tex((double)texCoords[0][0], (double)texCoords[0][1]).endVertex();
        bufferbuilder.pos((double)(r.x + r.width), (double)(r.y + r.height), (double)this.getZLevel()).tex((double)texCoords[1][0], (double)texCoords[1][1]).endVertex();
        bufferbuilder.pos((double)(r.x + r.width), (double)r.y, (double)this.getZLevel()).tex((double)texCoords[2][0], (double)texCoords[2][1]).endVertex();
        bufferbuilder.pos((double)r.x, (double)r.y, (double)this.getZLevel()).tex((double)texCoords[3][0], (double)texCoords[3][1]).endVertex();
        tessellator.draw();
        GlStateManager.disableTexture2D();
    }

    protected void scissor(Rectangle r) {
        if (r == null) {
            GL11.glScissor((int)0, (int)0, (int)0, (int)0);
            GL11.glEnable((int)3089);
            return;
        }
        GLU.gluProject((float)r.x, (float)r.y, (float)this.getZLevel(), (FloatBuffer)MODELVIEW, (FloatBuffer)PROJECTION, (IntBuffer)VIEWPORT, (FloatBuffer)COORDS);
        float x1 = COORDS.get(0);
        float y1 = COORDS.get(1);
        GLU.gluProject((float)(r.x + r.width), (float)(r.y + r.height), (float)this.getZLevel(), (FloatBuffer)MODELVIEW, (FloatBuffer)PROJECTION, (IntBuffer)VIEWPORT, (FloatBuffer)COORDS);
        float x2 = COORDS.get(0);
        float y2 = COORDS.get(1);
        if (!this.clipX) {
            x1 = VIEWPORT.get(0);
            x2 = x1 + (float)VIEWPORT.get(2);
        }
        GL11.glScissor((int)Math.round(Math.min(x1, x2)), (int)Math.round(Math.min(y1, y2)), (int)Math.round(Math.abs(x2 - x1)), (int)Math.round(Math.abs(y2 - y1)));
        GL11.glEnable((int)3089);
    }

    @Override
    public void window(Rectangle r) {
        if (this.clipRect.isEmpty()) {
            this.scissor(r);
            this.clipRect.push(r);
        } else {
            Rectangle top = this.clipRect.peek();
            if (top == null) {
                this.scissor(null);
                this.clipRect.push(null);
            } else {
                int x1 = Math.max(r.x, top.x);
                int y1 = Math.max(r.y, top.y);
                int x2 = Math.min(r.x + r.width, top.x + top.width);
                int y2 = Math.min(r.y + r.height, top.y + top.height);
                if (x2 > x1 && y2 > y1) {
                    Rectangle rect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
                    this.scissor(rect);
                    this.clipRect.push(rect);
                } else {
                    this.scissor(null);
                    this.clipRect.push(null);
                }
            }
        }
    }

    @Override
    public void restore() {
        if (!this.clipRect.isEmpty()) {
            this.clipRect.pop();
            if (this.clipRect.isEmpty()) {
                GL11.glDisable((int)3089);
            } else {
                this.scissor(this.clipRect.peek());
            }
        }
    }

    public void getMatrices() {
        GlStateManager.getFloat((int)2982, (FloatBuffer)MODELVIEW);
        GlStateManager.getFloat((int)2983, (FloatBuffer)PROJECTION);
        GlStateManager.glGetInteger((int)2978, (IntBuffer)VIEWPORT);
    }

    public static void begin() {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.glLineWidth((float)2.0f);
    }

    public static void end() {
        GlStateManager.shadeModel((int)7424);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    protected abstract float getZLevel();

    protected abstract String getResourcePrefix();
}

