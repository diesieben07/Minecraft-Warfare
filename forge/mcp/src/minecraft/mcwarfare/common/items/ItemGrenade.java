package mcwarfare.common.items;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGrenade extends ItemWarfare {

	public ItemGrenade(int defaultId) {
		super("grenade", defaultId);
		setHasSubtypes(true);
		setMaxStackSize(1);
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