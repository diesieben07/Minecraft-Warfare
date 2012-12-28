package mcwarfare.client;

import mcwarfare.common.CommonProxy;
import mcwarfare.common.MinecraftWarfare;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void preInit() {
		MinecraftForgeClient.preloadTexture(MinecraftWarfare.TEXTURE_FILE);
	}
	
	@Override
	public void init() {
		TickRegistry.registerTickHandler(new ClientTickHandler(mc), Side.CLIENT);
	}
}
