package mcwarfare.common.items;

import net.minecraft.item.ItemStack;

public enum GunType {
	
	NORMAL("normal", 0, 10, 0, 0, 0, 0),
	//AssaultRifles
	AK47("AK47", 0, 10, 0, 0, 0, 0),
	ARX160("ARX160", 0, 10, 0, 0, 0, 0),
	ACR("ACR", 0, 10, 0, 0, 0, 0),
	CM901("CM901", 0, 10, 0, 0, 0, 0),
	TAR21("TAR21", 0, 10, 0, 0, 0, 0),
	FAMAS("FAMAS", 0, 10, 0, 0, 0, 0),
	F2000("F2000", 0, 10, 0, 0, 0, 0),
	G36("G36", 0, 10, 0, 0, 0, 0),
	M16A3("M16A3", 0, 10, 0, 0, 0, 0),
	M16A4("M16A4", 0, 10, 0, 0, 0, 0),
	SCARH("SCARH", 0, 10, 0, 0, 0, 0),
	SCARl("SCARL", 0, 10, 0, 0, 0, 0),
	AUG("AUG", 0, 10, 0, 0, 0, 0),
	SIG552("SIG552", 0, 10, 0, 0, 0, 0),
	M4A1("M4A1", 0, 10, 0, 0, 0, 0),
	AR15("AR15", 0, 10, 0, 0, 0, 0),
	//ShotGuns
	
	//Snipers
	//Carabines
	//Pistols
	//SMG
	AK74("AK74", 0, 10, 0, 0, 0, 0),
	MP5("MP5", 0, 10, 0, 0, 0, 0),
	MP7("MP7", 0, 10, 0, 0, 0, 0),
	MP9("MP9", 0, 10, 0, 0, 0, 0),
	P90("P90", 0, 10, 0, 0, 0, 0),
	UMP45("UMP45", 0, 10, 0, 0, 0, 0),
	//LMG
	MG36("MG36", 0, 10, 0, 0, 0, 0);
	private final int bulletDamage;
	private final String name;
	private final int textureIndex;
	private final int vrecoil;
	private final int hrecoil;
	private final int fmode; //0=SEMI 1=AUTO 2=BURST
	private final int bspeed;
	
	private GunType(String name, int textureIndex, int bulletDamage, int vrecoil, int hrecoil, int fmode, int bspeed) {
		this.bulletDamage = bulletDamage;
		this.name = name;
		this.textureIndex = textureIndex;
		this.vrecoil = vrecoil;
		this.hrecoil = hrecoil;
		this.fmode = fmode;
		this.bspeed = bspeed;
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
	public int getFmode() {
		return fmode;
	}
	public int getBspeed() {
		return bspeed;
	}
}