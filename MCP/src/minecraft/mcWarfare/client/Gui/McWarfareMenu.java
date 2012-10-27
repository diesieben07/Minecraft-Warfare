package mcWarfare.client.Gui;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;

public class McWarfareMenu extends GuiScreen {
	
	private static final int BUTTON_BACK = 0;
	
	private GuiButton buttonBackToMenu;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		buttonBackToMenu = new GuiButton(BUTTON_BACK, 10, 10, "Back to Main Menu");
		controlList.add(buttonBackToMenu);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case BUTTON_BACK:
			mc.displayGuiScreen(new GuiMainMenu());
			break;
		}
	}
}
