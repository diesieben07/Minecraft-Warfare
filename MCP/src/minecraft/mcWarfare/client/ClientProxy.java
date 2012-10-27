package mcWarfare.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.registry.TickRegistry;
import mcWarfare.common.CommonProxy;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		TickRegistry.registerTickHandler(new ClientTickHandler(FMLClientHandler.instance().getClient()), Side.CLIENT);
	}
}
