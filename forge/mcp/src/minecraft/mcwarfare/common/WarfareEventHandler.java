package mcwarfare.common;

import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class WarfareEventHandler implements IPlayerTracker {
	
	private WarfareEventHandler() { }
	
	public static void init() {
		GameRegistry.registerPlayerTracker(new WarfareEventHandler());
	}
	
	public static void onPlayerDamage(EntityPlayer player, DamageSource source, int damage) {
		NBTTagCompound modData = MinecraftWarfare.getModEntityData(player);
		byte health = (byte) (modData.getByte("health") - 5 * damage);
		if (health <= 0) {
			player.heal(-200);
		}
		modData.setByte("health", health);
	}

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		NBTTagCompound modData = MinecraftWarfare.getModEntityData(player);
		if (!modData.hasKey("health")) {
			resetHealth(player);
		}
		System.out.println("login");
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) { }

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) { }

	@Override
	public void onPlayerRespawn(EntityPlayer player) { 
		resetHealth(player);
		
	}
	
	private void resetHealth(EntityPlayer player) {
		NBTTagCompound modData = MinecraftWarfare.getModEntityData(player);
		modData.setByte("health", (byte) 100);
	}
}
