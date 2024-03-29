package mcwarfare.common.items;

import net.minecraft.item.ItemStack;

public enum GunType {
	
	NORMAL("normal", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	//AssaultRifles
	AK47("AK47", 0, 80, 0, 0, 0, 10, 0, 0, 0, 3),
	ARX160("ARX160", 0, 55, 0, 0, 0, 0, 0, 0, 0, 2),
	ACR("ACR", 0, 60, 0, 0, 0, 0, 0, 0, 0, 2),
	CM901("CM901", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	TAR21("TAR21", 0, 60, 0, 0, 0, 0, 0, 0, 0, 2),
	FAMAS("FAMAS", 0, 82, 0, 0, 0, 0, 0, 0, 0),
	F2000("F2000", 0, 61, 0, 0, 0, 0, 0, 0, 0, 2),
	G36("G36", 0, 58, 0, 0, 0, 0, 0, 0, 0, 2),
	M16A3("M16A3", 0, 63, 0, 0, 0, 0, 0, 0, 0, 2),
	M16A4("M16A4", 0, 68, 0, 0, 0, 0, 0, 0, 0),
	SCARl("SCARL", 0, 65, 0, 0, 0, 0, 0, 0, 0, 2),
	AUG("AUG", 0, 62, 0, 0, 0, 0, 0, 0, 0, 2),
	AR15("AR15", 0, 62, 0, 0, 0, 0, 0, 0, 0, 2),
	//ShotGuns
	AA12("AA12", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	KSG("KSG", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	USAS("USAS", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	SPAS12("SPAS12", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	//Snipers
	SKS("SKS", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	SVD("SVD", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	L118A("L118A", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	M95("M95", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	AS50("AS50", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	//Carabines
	M4A1("M4A1", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    SCARH("SCARH", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    G36C("G36C", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    SIG552("SIG552", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    A91("A91", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	//Pistols
    MAGNUM("MAGNUM", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    DESERTEAGLE("DESERTEAGLE", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    G18("G18", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    G17("G17", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    MP412("MP412", 0, 10, 0, 0, 0, 0, 0, 0, 0),
    USP("USP", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	//SMG
	AK74("AK74", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	MP5("MP5", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	MP7("MP7", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	MP9("MP9", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	P90("P90", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	UMP45("UMP45", 0, 10, 0, 0, 0, 0, 0, 0, 0),
	//LMG
	MG36("MG36", 0, 10, 0, 0, 0, 0, 0, 0, 1, 1),
	M60("M60", 0, 10, 0, 0, 0, 0, 0, 0, 1, 1),
	RPK("RPK", 0, 10, 0, 0, 0, 0, 0, 0, 2, 2),
	M249("M249", 0, 10, 0, 0, 0, 0, 0, 0, 1, 1),
	PKP("PKP", 0, 10, 0, 0, 0, 0, 0, 0, 2, 2);
	
	private final int bulletDamage;
	private final String name;
	private final int textureIndex;
	private final int vrecoil;
	private final int hrecoil;
	
	private final int fmode; //0=SEMI 1=AUTO 2=BURST
	private final int bspeed;
	private final int magsize;
	private final int cooldown;
	private final int boltaction; //0=NO 1=YES
	
	private int shootSpeed;
	
	private GunType(String name, int textureIndex, int bulletDamage, int vrecoil, int hrecoil, int fmode, int bspeed, int magsize, int cooldown, int boltaction) {
		this(name, textureIndex, bulletDamage, vrecoil, hrecoil, fmode, bspeed, magsize, cooldown, boltaction, -1);
	}
	
	private GunType(String name, int textureIndex, int bulletDamage, int vrecoil, int hrecoil, int fmode, int bspeed, int magsize, int cooldown, int boltaction, int shootSpeed) {
		this.bulletDamage = bulletDamage;
		this.name = name;
		this.textureIndex = textureIndex;
		this.vrecoil = vrecoil;
		this.hrecoil = hrecoil;
		this.fmode = fmode;
		this.bspeed = bspeed;
		this.shootSpeed = shootSpeed;
		this.magsize = magsize;
		this.cooldown = cooldown;
		this.boltaction = boltaction;
		
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
	public int getMagsize() {
		return magsize;
	}
	public int getCooldown() {
		return cooldown;
	}
	public int getBoltaction() {
		return boltaction;
	}
	public boolean shouldShootAtTick(int tickCount) {
		System.out.println(shootSpeed);
		return shootSpeed == -1 ? tickCount == 0 : tickCount % shootSpeed == 0;
	}
}