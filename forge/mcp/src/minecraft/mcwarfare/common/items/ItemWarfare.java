package mcwarfare.common.items;

import static mcwarfare.common.MinecraftWarfare.conf;
import mcwarfare.common.MinecraftWarfare;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ItemWarfare extends Item {

	public static Item grenade;
	public static Item gun;
	public static Item launcher;
	
	public ItemWarfare(String itemName, int defaultId) {
		super(conf.getItem(itemName + "ID", defaultId).getInt());
		initWarfareItem(this, itemName);
	}
	
	public void onItemLeftClick(EntityPlayer player, World world) { }
	
	public static void initWarfareItem(Item item, String itemName) {
		item.setItemName("mcwarfare." + itemName);
		item.setTextureFile(MinecraftWarfare.TEXTURE_FILE);
		item.setCreativeTab(MinecraftWarfare.creativeTab);
	}
	
	public static void createItems() {
		grenade = new ItemGrenade(4000);
		gun = new ItemGun(4001);
		launcher = new ItemLauncher(4002);
	}
}