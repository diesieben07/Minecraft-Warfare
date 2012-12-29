package mcwarfare.common.items;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcwarfare.common.EntityGrenade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends ItemWarfare {

	public ItemGrenade(int defaultId) {
		super("grenade", defaultId);
		setHasSubtypes(true);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityGrenade(world, player));
		}

		return stack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int damage) {
		return GrenadeType.fromItemDamage(damage).getTextureIndex();
	}

	@Override
	public String getItemNameIS(ItemStack stack) {
		return "item.mcwarfare.grenade." + GrenadeType.fromItemDamage(stack).getName();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemId, CreativeTabs creativeTab, List stackList) {
		for (GrenadeType type : GrenadeType.values()) {
			stackList.add(new ItemStack(this, 1, type.toItemDamage()));
		}
	}
}