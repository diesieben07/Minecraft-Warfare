package mcwarfare.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcwarfare.common.items.ItemWarfare;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GunCreativeTab extends CreativeTabs {

	public GunCreativeTab() {
		super("");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel() {
		return "Gun";
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ItemWarfare.gun);
	}
}