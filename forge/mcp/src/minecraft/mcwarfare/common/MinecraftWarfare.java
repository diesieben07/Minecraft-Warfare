package mcwarfare.common;

import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "mcWarfare", name = "Minecraft Warfare", version = "0.1")
@NetworkMod(versionBounds = "0.1")
public class MinecraftWarfare {
	
	@SidedProxy(clientSide = "mcwarfare.client.ClientProxy", serverSide = "mcwarfare.common.CommonProxy")
	public static CommonProxy proxy;
	public static Logger logger;
	
	public static ItemGrenade grenade;
	public static ItemsmokeGrenade smokegrenade;
	public static ItemGun gun;
	public static ItemLauncher launcher;
	
	@Init
	public void init(FMLInitializationEvent evt) {
		logger = Logger.getLogger("Minecraft Warfare");
		logger.setParent(FMLLog.getLogger());
		logger.setUseParentHandlers(true);
		
		logger.info("Initializing...");
		
		proxy.init();
		
		grenade = new ItemGrenade(4000, 0);
		smokegrenade = new ItemsmokeGrenade(4001, 0);
		gun = new ItemGun(4002, 0);
		launcher = new ItemLauncher(4003, 0);
		
	}
}