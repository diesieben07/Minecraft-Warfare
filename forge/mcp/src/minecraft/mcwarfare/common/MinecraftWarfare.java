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
	
	@Init
	public void init(FMLInitializationEvent evt) {
		logger = Logger.getLogger("Minecraft Warfare");
		logger.setParent(FMLLog.getLogger());
		logger.setUseParentHandlers(true);
		
		logger.info("Initializing...");
	}
}