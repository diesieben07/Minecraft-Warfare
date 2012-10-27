package mcWarfare.client.Gui;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.StringTranslate;

public class McWarfareMenu extends GuiScreen {
	
	private static final int BUTTON_BACK = 0;
	private static final int BUTTON_START = 1;
	
	private final GuiScreen parentScreen;
	
	public McWarfareMenu(GuiScreen parentScreen) {
		this.parentScreen = parentScreen;
	}	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		controlList.add(new GuiButton(BUTTON_START, this.width / 2 - 100, height / 4 + 48, StringTranslate.getInstance().translateKey("mcwarfare.gui.startcampaign")));
		controlList.add(new GuiButton(BUTTON_BACK, this.width / 2 - 100, height / 4 + 120, StringTranslate.getInstance().translateKey("mcwarfare.gui.backtomenu")));
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case BUTTON_BACK:
			mc.displayGuiScreen(parentScreen);
			break;
		}
	}
}