package mcWarfare.client.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;

public class ButtonMainMenu extends GuiButton {

	public ButtonMainMenu(int buttonId, int xCoord, int yCoord, int width, int height, String label) {
		super(buttonId, xCoord, yCoord, width, height, label);
	}
	
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        if (super.mousePressed(mc, mouseX, mouseY)) {
        	mc.displayGuiScreen(new McWarfareMenu());
        }
        return false;
    }

}
