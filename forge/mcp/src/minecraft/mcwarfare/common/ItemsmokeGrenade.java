package mcwarfare.common;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class ItemsmokeGrenade extends Item{
	
	public ItemsmokeGrenade(int itemID, int textureIndex)
    {
            super(itemID);
            this.setIconIndex(0);
            this.maxStackSize = 1;
            this.setItemName("smokeGrenade");
            LanguageRegistry.instance().addStringLocalization(this.getItemName() + ".name", "en_US", "Smoke Grenade");
            
    }
	

}
