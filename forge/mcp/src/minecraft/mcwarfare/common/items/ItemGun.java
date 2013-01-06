package mcwarfare.common.items;

import mcwarfare.common.entities.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemGun extends ItemWarfare {

	public int bdamage;
	
	public ItemGun(int defaultId, int par2) {
		super("gun", defaultId);
		this.bdamage = par2;
	}
	
	public int getBulletDamage(EntityBullet par2EntityBullet){
		return this.bdamage;
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