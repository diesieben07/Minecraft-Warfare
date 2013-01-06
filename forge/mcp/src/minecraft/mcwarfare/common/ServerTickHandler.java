package mcwarfare.common;

import java.util.EnumSet;

import mcwarfare.common.items.ItemWarfare;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		EntityPlayer player = (EntityPlayer)tickData[0];
		if (MinecraftWarfare.getModEntityData((player)).getBoolean("isShooting")) {
			ItemStack currentItem = player.getCurrentEquippedItem();
			if (currentItem != null && currentItem.getItem() instanceof ItemWarfare) {
				((ItemWarfare)currentItem.getItem()).onItemLeftClickTick(player, player.worldObj);
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "MCWarfare";
	}
}