package mcwarfare.common;

import mcwarfare.common.items.ItemWarfare;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class WFEventHandler {
	public static void onLivingSwing(EntityLiving living) {
		MinecraftWarfare.proxy.onEntitySwing(living);
	}
}
