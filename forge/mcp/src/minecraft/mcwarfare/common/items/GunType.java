package mcwarfare.common.items;

import net.minecraft.item.ItemStack;

public enum GunType {
	
	NORMAL("normal", 10);
	
	private final int bulletDamage;
	private final String name;
	
	private GunType(String name, int bulletDamage) {
		this.bulletDamage = bulletDamage;
		this.name = name;
	}
	
	public static GunType byId(int id) {
		return id < values().length && id > 0 ? values()[id] : NORMAL;
	}
	
	public static GunType fromItemDamage(ItemStack stack) {
		return stack == null ? NORMAL : byId(stack.getItemDamage());
	}
	
	public int getId() {
		return ordinal();
	}
	
	public int getBulletDamage() {
		return bulletDamage;
	}
	
	public String getName() {
		return name;
	}
}