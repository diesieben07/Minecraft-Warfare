package mcwarfare.client;

import java.util.EnumSet;
import java.util.List;

import org.lwjgl.input.Mouse;

import mcwarfare.client.gui.ButtonWarfareMenu;
import mcwarfare.common.MinecraftWarfare;
import mcwarfare.common.network.PacketLeftClick;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class ClientTickHandler implements ITickHandler {

	private final Minecraft mc;
	private final ButtonWarfareMenu button = new ButtonWarfareMenu();
	
	private boolean pressedPrevious = true;
	
	public ClientTickHandler(Minecraft mc) {
		this.mc = mc;
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		GuiScreen currentScreen = mc.currentScreen;
		if (currentScreen != null && currentScreen instanceof GuiMainMenu) {
			
			List<GuiButton> controlList = ReflectionHelper.getPrivateValue(GuiScreen.class, currentScreen, 4);
			if (!controlList.contains(button)) {
				button.xPosition = currentScreen.width / 2 - 100;
				button.yPosition = currentScreen.height / 4 + 48 + 24;
				controlList.add(button);
				
				for (GuiButton button : controlList) {
					if (button.id == 1 || button.id == 2) { // Singleplayer
						ReflectionHelper.setPrivateValue(GuiButton.class, button, 98, 0);
					}
					if (button.id == 2) {
						button.yPosition = currentScreen.height / 4 + 48;
						button.xPosition += 102;
					}
				}
			}
		}
		
		if (mc.theWorld != null && mc.thePlayer != null && mc.gameSettings.keyBindAttack.pressed != pressedPrevious) {
			pressedPrevious = mc.gameSettings.keyBindAttack.pressed;
			new PacketLeftClick(pressedPrevious).sendToServer();
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "mcWarfare";
	}
}