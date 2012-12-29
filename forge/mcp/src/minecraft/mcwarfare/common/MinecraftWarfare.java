package mcwarfare.common;

import java.util.logging.Logger;

import mcwarfare.common.items.ItemWarfare;
import mcwarfare.common.network.WFPacket;
import mcwarfare.common.network.WFPacketHandler;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = "mcWarfare", name = "Minecraft Warfare", version = "0.1")
@NetworkMod(versionBounds = "0.1", channels = { WFPacket.CHANNEL }, packetHandler = WFPacketHandler.class, tinyPacketHandler = WFPacketHandler.class)
public class MinecraftWarfare {
	
	public static final String TEXTURE_FILE = "/mcwarfare/resource/tex/textures.png";
	
	@SidedProxy(clientSide = "mcwarfare.client.ClientProxy", serverSide = "mcwarfare.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static MinecraftWarfare instance;
	
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
		
		registerEntity(EntityBullet.class, "bullet", 64, 20, false);
	}
	
	private void registerEntity(Class<? extends Entity> clazz, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(clazz, "mcwarfare_" + name, id);
		EntityRegistry.registerModEntity(clazz, "mcwarfare_" + name, id, this, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		conf.save();
	}
}