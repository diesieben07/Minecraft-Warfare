package mcwarfare.client;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import mcwarfare.common.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void init() {
		TickRegistry.registerTickHandler(new ClientTickHandler(mc), Side.CLIENT);
	}
}
