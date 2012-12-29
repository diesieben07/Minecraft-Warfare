package mcwarfare.client;

import mcwarfare.client.render.RenderBullet;
import mcwarfare.common.CommonProxy;
import mcwarfare.common.EntityBullet;
import mcwarfare.common.MinecraftWarfare;
import mcwarfare.common.items.ItemWarfare;
import mcwarfare.common.network.PacketLeftClickAir;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void onEntitySwing(EntityLiving living) {
		if (living == mc.thePlayer && mc.objectMouseOver == null) {
			ItemStack stack = mc.thePlayer.getCurrentEquippedItem();
			if (stack != null && stack.getItem() != null && stack.getItem() instanceof ItemWarfare) {
				((ItemWarfare)stack.getItem()).onItemLeftClick(mc.thePlayer, mc.thePlayer.worldObj);
			}
			new PacketLeftClickAir().sendToServer();
		}
	}
	
	@Override
	public void preInit() {
		MinecraftForgeClient.preloadTexture(MinecraftWarfare.TEXTURE_FILE);
	}
	
	@Override
	public void init() {
		TickRegistry.registerTickHandler(new ClientTickHandler(mc), Side.CLIENT);
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}
}
