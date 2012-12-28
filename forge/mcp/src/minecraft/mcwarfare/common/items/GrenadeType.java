package mcwarfare.common.items;

import net.minecraft.item.ItemStack;

public enum GrenadeType {
	NORMAL("normal", 1), SMOKE("smoke", 2);
	
	private final String name;
	private final int textureIndex;
	
	private GrenadeType(String name, int textureIndex) {
		this.name = name;
		this.textureIndex = textureIndex;
	}
	
	public final int toItemDamage() {
		return ordinal();
	}
	
	public static GrenadeType fromItemDamage(ItemStack stack) {
		return fromItemDamage(stack.getItemDamage());
	}
	
	public static GrenadeType fromItemDamage(int damage) {
		return damage < 0 || damage >= values().length ? NORMAL : values()[damage];
	}

	public String getName() {
		return name;
	}

	public int getTextureIndex() {
		return textureIndex;
	}
}
