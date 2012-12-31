package mcwarfare.common.items;

public class GunType {
	public static GunType[] gunTypes = new GunType[16];
	
	public GunType(int id) {
		gunTypes[id] = this;
	}
	
	
}
