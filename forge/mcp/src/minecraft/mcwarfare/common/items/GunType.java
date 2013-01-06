package mcwarfare.common.items;

import net.minecraft.item.ItemStack;

public enum GunType {
	
	NORMAL("normal", 0, 10, 0, 0);
	
	private final int bulletDamage;
	private final String name;
	private final int textureIndex;
	private final int vrecoil;
	private final int hrecoil;
	
	private GunType(String name, int textureIndex, int bulletDamage, int vrecoil, int hrecoil) {
		this.bulletDamage = bulletDamage;
		this.name = name;
		this.textureIndex = textureIndex;
		this.vrecoil = vrecoil;
		this.hrecoil = hrecoil;
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

	public int getTextureIndex() {
		return textureIndex;
	}

	public int getVrecoil() {
		return vrecoil;
	}

	public int getHrecoil() {
		return hrecoil;
	}
}