package mcwarfare.client;

import mcwarfare.client.render.RenderBullet;
import mcwarfare.client.render.RenderGrenade;
import mcwarfare.common.CommonProxy;
import mcwarfare.common.MinecraftWarfare;
import mcwarfare.common.entities.EntityBullet;
import mcwarfare.common.entities.EntityGrenade;
import mcwarfare.common.items.ItemWarfare;
import mcwarfare.common.network.PacketLeftClick;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private ClientTickHandler tickHandler;
	
	@Override
	public void preInit() {
		MinecraftForgeClient.preloadTexture(MinecraftWarfare.TEXTURE_FILE);
		ClientEventHandler.init();
	}
	
	@Override
	public void init() {
		tickHandler = new ClientTickHandler(mc);
		TickRegistry.registerTickHandler(tickHandler, Side.CLIENT);
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderGrenade());
	}
	
	@Override
	public void setClientHealth(int health) {
		tickHandler.clientHealth = health;
	}
}
