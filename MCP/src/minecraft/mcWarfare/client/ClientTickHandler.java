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
	private GuiScreen theMainMenu;
	private int prevWidth;
	private int prevHeight;
	
	public ClientTickHandler(Minecraft mc) {
		this.mc = mc;
}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) { }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (mc.currentScreen != null && mc.currentScreen instanceof GuiMainMenu && (theMainMenu != mc.currentScreen || prevWidth != mc.currentScreen.width || prevHeight != mc.currentScreen.height)) {
			try {
				// store the info, so we don't add the button twice
				theMainMenu = mc.currentScreen;
				prevWidth = theMainMenu.width;
				prevHeight = theMainMenu.height;
				
				// create the button
				GuiButton theButton = new ButtonMainMenu(1, theMainMenu.width / 2 + 2, theMainMenu.height / 4 + 48, 98, 20, "Minecraft Warfare");
				// get the controlList from the screen
				List<GuiButton> controlList = ObfuscationReflectionHelper.<List<GuiButton>,GuiScreen>getPrivateValue(GuiScreen.class, theMainMenu, 3);
				// add our button so it will be drawn
				controlList.add(theButton);
				// get the "Singleplayer" button from the controlList
				GuiButton singlePlayerButton = controlList.get(0);
				// reduce the width of the button
				ObfuscationReflectionHelper.<GuiButton,Integer>setPrivateValue(GuiButton.class, singlePlayerButton, Integer.valueOf(98), 0);
			} catch (Exception e) {
				logger.warning("Unable to access GuiMainMenu and add Button!");	
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