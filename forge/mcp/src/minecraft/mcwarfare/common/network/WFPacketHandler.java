package mcwarfare.common.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.ITinyPacketHandler;
import cpw.mods.fml.common.network.Player;

public class WFPacketHandler implements IPacketHandler, ITinyPacketHandler {

	@Override
	public void handle(NetHandler handler, Packet131MapData mapData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		// TODO Auto-generated method stub

	}

}
