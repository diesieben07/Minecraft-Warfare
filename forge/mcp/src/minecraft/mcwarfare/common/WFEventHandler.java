package mcwarfare.common;

import mcwarfare.common.items.ItemWarfare;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class WFEventHandler {
	public static void onLivingSwing(EntityLiving living) {
		if (living instanceof EntityPlayer && !(living instanceof EntityOtherPlayerMP)) {
			EntityPlayer player = (EntityPlayer)living;
			ItemStack stack = player.getCurrentEquippedItem();
			if (stack != null && stack.getItem() != null && stack.getItem() instanceof ItemWarfare) {
				((ItemWarfare)stack.getItem()).onItemLeftClick(player, player.worldObj);
			}
		}
	}
}
