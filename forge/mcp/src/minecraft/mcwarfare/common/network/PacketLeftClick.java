package mcwarfare.common.network;

import mcwarfare.common.MinecraftWarfare;
import mcwarfare.common.items.ItemWarfare;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public class PacketLeftClick extends WFPacket {

	private boolean isPressed;
	
	public PacketLeftClick() { }
	
	public PacketLeftClick(boolean isPressed) {
		this.isPressed = isPressed; 
	}
	
	@Override
	void writeData(ByteArrayDataOutput out) {
		out.writeBoolean(isPressed);
	}

	@Override
	void readData(ByteArrayDataInput in) {
		isPressed = in.readBoolean();
	}

	@Override
	void execute(EntityPlayer player) {
		ItemStack stack = player.getCurrentEquippedItem();
		if (stack != null && stack.getItem() != null && stack.getItem() instanceof ItemWarfare) {
			MinecraftWarfare.getModEntityData(player).setBoolean("isShooting", isPressed);
		}
	}

}
