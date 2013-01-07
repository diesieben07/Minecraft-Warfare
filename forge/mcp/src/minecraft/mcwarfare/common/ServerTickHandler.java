package mcwarfare.common;

import java.util.EnumSet;

import mcwarfare.common.items.ItemWarfare;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		EntityPlayer player = (EntityPlayer)tickData[0];
		NBTTagCompound modData = MinecraftWarfare.getModEntityData(player);
		if (modData.getBoolean("isShooting")) {
			ItemStack currentItem = player.getCurrentEquippedItem();
			if (currentItem != null && currentItem.getItem() instanceof ItemWarfare) {
				int shootingTicks = modData.getShort("shootingTicks");
				((ItemWarfare)currentItem.getItem()).onItemLeftClickTick(player, player.worldObj, shootingTicks);
				modData.setShort("shootingTicks", (short) ++shootingTicks);
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