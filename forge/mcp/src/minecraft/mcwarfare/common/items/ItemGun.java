package mcwarfare.common.items;

import mcwarfare.common.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemGun extends ItemWarfare {

	public ItemGun(int defaultId) {
		super("gun", defaultId);
	}
	
	@Override
	public void onItemLeftClick(EntityPlayer player, World world) {
		if (!world.isRemote) {
			EntityBullet bullet = new EntityBullet(world, player);
			
			
			bullet.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
			world.spawnEntityInWorld(bullet);
		}
	}	
}