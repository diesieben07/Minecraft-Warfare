package mcWarfare.client;

import java.util.EnumSet;
import java.util.List;

import mcWarfare.client.Gui.ButtonMainMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;

import static mcWarfare.common.MinecraftWarfare.*;

public class ClientTickHandler implements ITickHandler {
	
	private final Minecraft mc;
	private GuiButton theButton;
	
	public ClientTickHandler(Minecraft mc) {
		this.mc = mc;
}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) { }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (mc.currentScreen != null && mc.currentScreen instanceof GuiMainMenu) {
			List<GuiButton> controlList = ObfuscationReflectionHelper.<List<GuiButton>,GuiScreen>getPrivateValue(GuiScreen.class, mc.currentScreen, 3);
			
			if (theButton == null || !controlList.contains(theButton)) {
				// (re-)create our button
				theButton = new ButtonMainMenu(1, mc.currentScreen.width / 2 - 100 , mc.currentScreen.height / 4 + 72, 200, 20, "Minecraft Warfare");
				// and add it to the list
				controlList.add(theButton);
				
				// adjust the yPosition of the singleplayer and Multiplayer button
				
				for (int i = 0; i < 2; i++) {
					controlList.get(i).yPosition -= 24;
				}
				
				// reduce the width of the button
				//ObfuscationReflectionHelper.<GuiButton,Integer>setPrivateValue(GuiButton.class, singlePlayerButton, Integer.valueOf(98), 0);
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "mcWarfareRender";
	}
}