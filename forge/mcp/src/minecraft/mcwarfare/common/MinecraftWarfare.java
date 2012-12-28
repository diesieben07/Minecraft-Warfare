package mcwarfare.common;

import java.util.logging.Logger;

import mcwarfare.common.items.ItemWarfare;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "mcWarfare", name = "Minecraft Warfare", version = "0.1")
@NetworkMod(versionBounds = "0.1")
public class MinecraftWarfare {
	
	public static final String TEXTURE_FILE = "/mcwarfare/resource/tex/textures.png";
	
	@SidedProxy(clientSide = "mcwarfare.client.ClientProxy", serverSide = "mcwarfare.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static Configuration conf;
	
	public static Logger logger;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent evt) {
		conf = new Configuration(evt.getSuggestedConfigurationFile());
		conf.load();
		proxy.preInit();
		LanguageLoader.loadLanguages();
	}
	
	@Init
	public void init(FMLInitializationEvent evt) {
		logger = Logger.getLogger("Minecraft Warfare");
		logger.setParent(FMLLog.getLogger());
		logger.setUseParentHandlers(true);
		
		logger.info("Initializing...");
		
		proxy.init();
		
		ItemWarfare.createItems();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		conf.save();
	}
}