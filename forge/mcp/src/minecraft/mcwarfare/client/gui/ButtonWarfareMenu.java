package mcwarfare.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;

public class ButtonWarfareMenu extends GuiButton {

	public ButtonWarfareMenu() {
		super(0, 0, 0, "Minecraft Warfare");
	}
	
	@Override
	public boolean mousePressed(Minecraft mc, int par2, int par3) {
		if (super.mousePressed(mc, par2, par3)) {
			mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
			mc.displayGuiScreen(new GuiWarfareMenu(mc.currentScreen));
		}
		return false;
	}

}