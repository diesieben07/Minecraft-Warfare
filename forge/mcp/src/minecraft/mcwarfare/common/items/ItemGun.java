package mcwarfare.common.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import mcwarfare.common.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ItemGun extends ItemWarfare {

	public ItemGun(int defaultId) {
		super("gun", defaultId);
	}
	
	@Override
	public void onItemLeftClick(EntityPlayer player, World world) {
		if (!world.isRemote) {
			EntityBullet bullet = new EntityBullet(world, player, 2);
			
			
			bullet.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
			world.spawnEntityInWorld(bullet);
		}
	}	
}