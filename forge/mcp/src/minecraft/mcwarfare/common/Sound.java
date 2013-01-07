package mcwarfare.common;

import net.minecraft.entity.Entity;

public enum Sound {
	ACR_SHOOT("acrShoot");
	
	private final String soundName;
	
	private Sound(String soundName) {
		this.soundName = soundName;
	}
	
	public void playAtEntity(Entity entity) {
		entity.worldObj.playSoundAtEntity(entity, "mcwarfare." + soundName, 1, 1);
	}

	public final String getSoundName() {
		return soundName;
	}
}