package mcwarfare.common.items;

import java.util.List;

import mcwarfare.common.entities.EntityBullet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGun extends ItemWarfare {

	public ItemGun(int defaultId) {
		super("gun", defaultId);
	}
	
	@Override
	public void onItemLeftClick(EntityPlayer player, World world) {
		if (!world.isRemote) {
			EntityBullet bullet = new EntityBullet(world, player, GunType.fromItemDamage(player.getCurrentEquippedItem()));
						
			bullet.setPosition(player.posX, player.posY + player.getEyeHeight(), player.posZ);
			world.spawnEntityInWorld(bullet);
		}
	}

	@Override
	public String getItemNameIS(ItemStack stack) {
		return "item.mcwarfare.gun." + GunType.fromItemDamage(stack).getName();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int damage) {
		return GunType.byId(damage).getTextureIndex();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemId, CreativeTabs creativeTab, List stackList) {
		for (GunType type : GunType.values()) {
			stackList.add(new ItemStack(this, 1, type.getId()));
		}
	}
}