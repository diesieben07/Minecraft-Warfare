package mcwarfare.common;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class ItemGun extends Item{

	public ItemGun(int itemID, int textureIndex)
    {
            super(itemID);
            this.setIconIndex(0);
            this.maxStackSize = 1;
            this.setItemName("Gun");
            LanguageRegistry.instance().addStringLocalization(this.getItemName() + ".name", "en_US", "Gun");
            
    }
	
	
}
