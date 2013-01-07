package mcwarfare.common.network;

import mcwarfare.common.MinecraftWarfare;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public class PacketClientHealth extends WFPacket {

	private int health;
	
	public PacketClientHealth(int health) {
		this.health = health;
	}

	public PacketClientHealth() {	}

	@Override
	void writeData(ByteArrayDataOutput out) {
		out.writeByte(health);
	}

	@Override
	void readData(ByteArrayDataInput in) {
		health = in.readByte();
	}

	@Override
	void execute(EntityPlayer player) {
		MinecraftWarfare.proxy.setClientHealth(health);
	}

}
