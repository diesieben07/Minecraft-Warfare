package mcwarfare.common.network;

import mcwarfare.common.items.ItemWarfare;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public class PacketLeftClickAir extends WFPacket {

	@Override
	void writeData(ByteArrayDataOutput out) {
		
	}

	@Override
	void readData(ByteArrayDataInput in) {
		
	}

	@Override
	void execute(EntityPlayer player) {
		ItemStack stack = player.getCurrentEquippedItem();
		if (stack != null && stack.getItem() != null && stack.getItem() instanceof ItemWarfare) {
			((ItemWarfare)stack.getItem()).onItemLeftClick(player, player.worldObj);
			
		}
	}

}
