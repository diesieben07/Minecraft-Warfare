package mcwarfare.client.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiWarfareMenu extends GuiScreen {
	
	private static final int BACK_BUTTON = 0; 
	
	private final GuiScreen parentScreen;
	
	public GuiWarfareMenu(GuiScreen parentScreen) {
		this.parentScreen = parentScreen;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
		super.drawScreen(par1, par2, par3);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
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