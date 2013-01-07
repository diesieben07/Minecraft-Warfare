package mcwarfare.common.network;

import static mcwarfare.common.MinecraftWarfare.logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import mcwarfare.common.MinecraftWarfare;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public abstract class WFPacket {
	
	public static final String CHANNEL = "MinecraftWarfare";
	
	private static Map<Integer, Class<? extends WFPacket>> idToClassMap = new HashMap<Integer, Class<? extends WFPacket>>();
	private static Map<Class<? extends WFPacket>, Integer> classToIdMap = new HashMap<Class<? extends WFPacket>, Integer>();
	
	private static void addMapping(int packetId, Class<? extends WFPacket> clazz) {
		idToClassMap.put(packetId, clazz);
		classToIdMap.put(clazz, packetId);
	}
	
	static {
		addMapping(0, PacketLeftClick.class);
		addMapping(1, PacketClientHealth.class);
	}
	
	public final Packet generatePacket() {
		ByteArrayDataOutput output = ByteStreams.newDataOutput();
		output.writeByte(classToIdMap.get(getClass()));
		writeData(output);
		byte[] bytes = output.toByteArray();
		if (bytes.length <= Short.MAX_VALUE + 1) {
			return PacketDispatcher.getTinyPacket(MinecraftWarfare.instance, bytes[0], Arrays.copyOfRange(bytes, 1, bytes.length));
		} else {
			return new Packet250CustomPayload(CHANNEL, bytes);
		}
	}
	
	public final void sendToServer() {
		PacketDispatcher.sendPacketToServer(generatePacket());
	}
	
	public final void sendToPlayer(EntityPlayer player) {
		PacketDispatcher.sendPacketToPlayer(generatePacket(), (Player)player);
	}
	
	public final void sendToAllNear(Entity entity, double radius) {
		sendToAllNear(entity.posX, entity.posY, entity.posZ, entity.dimension, radius);
	}
	
	public final void sendToAllNear(TileEntity tileEntity, double radius) {
		sendToAllNear(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, tileEntity.worldObj.provider.dimensionId, radius);
	}
	
	public final void sendToAllNear(double x, double y, double z, int dimension, double radius) {
		MinecraftServer.getServer().getConfigurationManager().sendToAllNear(x, y, z, radius, dimension, generatePacket());
	}
	
	abstract void writeData(ByteArrayDataOutput out);
	
	abstract void readData(ByteArrayDataInput in);
	
	abstract void execute(EntityPlayer player);
	
	public static void execute(ByteArrayDataInput input, int packetId, EntityPlayer player) {
		Class<? extends WFPacket> packetClass = idToClassMap.get(packetId);
		if (packetClass == null) {
			logger.warning("Recieved unknown Packet-Id " + packetId);
		} else {
			try {
				WFPacket parsedPacket = packetClass.newInstance();
				parsedPacket.readData(input);
				parsedPacket.execute((EntityPlayer)player);
			} catch (Exception e) {
				logger.warning("Exception during packet handling: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
				e.printStackTrace();
			}
		}
	}
}
