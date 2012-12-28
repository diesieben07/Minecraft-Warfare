package mcwarfare.client.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;

public class GuiWarfareMenu extends GuiScreen {
	
	private static final int BACK_BUTTON = 0; 
	
	private static boolean hasBeenOpenend = false;
	
	private int tickCount = 0;
	
	private final GuiScreen parentScreen;
	
	public GuiWarfareMenu(GuiScreen parentScreen) {
		this.parentScreen = parentScreen;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		if (tickCount < 100 && !hasBeenOpenend) {
			ScaledResolution scaled = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			Tessellator tesselator = Tessellator.instance;
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/mcwarfare/resource/lighthouse.png"));
	        GL11.glColor3f(1, 1, 1);
	        tesselator.startDrawingQuads();
	        tesselator.setColorOpaque_I(16777215);
	        tesselator.addVertexWithUV(0.0D, (double)mc.displayHeight, 0.0D, 0.0D, 0.0D);
	        tesselator.addVertexWithUV((double)mc.displayWidth, (double)mc.displayHeight, 0.0D, 0.0D, 0.0D);
	        tesselator.addVertexWithUV((double)mc.displayWidth, 0.0D, 0.0D, 0.0D, 0.0D);
	        tesselator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	        tesselator.draw();
	        mc.scaledTessellator((scaled.getScaledWidth() - 256) / 2, (scaled.getScaledHeight() - 256) / 2, 0, 0, 256, 256);
			tickCount++;
		} else {
			hasBeenOpenend = true;
			drawDefaultBackground();
			super.drawScreen(par1, par2, par3);
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (!hasBeenOpenend) {
			return;
		}
		switch (button.id) {
		case BACK_BUTTON:
			mc.displayGuiScreen(parentScreen);
		}
	}

	@Override
	protected void keyTyped(char chararcter, int id) {
		if (id == Keyboard.KEY_ESCAPE) {
			mc.displayGuiScreen(parentScreen);
		}
	}

	@Override
	public void initGui() {
		controlList.add(new GuiButton(BACK_BUTTON, 10, 10, "Back"));
	}
}