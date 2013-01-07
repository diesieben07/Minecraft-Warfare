package mcwarfare.client;

import mcwarfare.common.Sound;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientEventHandler {
	
	private ClientEventHandler() { }
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
	}
	
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent evt) {
		for (Sound sound : Sound.values()) {
			sound.register(evt.manager);
		}
	}
}