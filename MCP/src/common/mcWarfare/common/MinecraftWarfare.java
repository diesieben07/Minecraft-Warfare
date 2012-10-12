package mcWarfare.common;

import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "MinecraftWarfare", name = "Minecraft Warfare", version = "0.1")
public class MinecraftWarfare {
	
	@SidedProxy(clientSide = "mcWarfare.client.ClientProxy", serverSide = "mcWarfare.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@Instance
	public static MinecraftWarfare instance;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent evt) {
		logger = Logger.getLogger("MCWarfare");
		logger.setParent(FMLLog.getLogger());
		logger.setUseParentHandlers(true);
		
		logger.info("MCWarfare PreInitializing...");
	}
	
	@Init
	public void init(FMLInitializationEvent evt) {
		logger.info("MCWarfare Initializing...");
	}
}
