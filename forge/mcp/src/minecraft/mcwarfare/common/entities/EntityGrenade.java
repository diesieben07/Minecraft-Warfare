package mcwarfare.common.entities;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import mcwarfare.common.items.GrenadeType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable implements IEntityAdditionalSpawnData {

	private boolean impacted = false;
	private int impactTicks = 0;
	private GrenadeType type = GrenadeType.NORMAL;
	
	public EntityGrenade(World world) {
		super(world);
	}
	
	public EntityGrenade(World world, EntityLiving thrower, GrenadeType type) {
		super(world, thrower);
		this.type = type;
	}

	@Override
	protected void onImpact(MovingObjectPosition target) {
		impacted = true;
		motionX = 0;
		motionY = 0;
		motionZ = 0;
	}

	@Override
	public void onUpdate() {
		worldObj.spawnParticle("largesmoke", posX, posY, posZ, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
		
		super.onUpdate();
		if (impacted) {
			impactTicks++;
			
			if (impactTicks >= 40) {
				detonate();
				setDead();
			}
		}
	}
	
	private void detonate() {
		switch (type) {
		case NORMAL:
			if (!worldObj.isRemote) {
				worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 2, true);
			}
			break;
		case SMOKE:
			break;
		}
	}

	@Override
	public void writeSpawnData(ByteArrayDataOutput data) {
		data.writeByte(type.toId());
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setByte("grenadeType", (byte)type.toId());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		type = GrenadeType.byId(nbt.getByte("grenadeType"));
	}

	@Override
	public void readSpawnData(ByteArrayDataInput data) {
		type = GrenadeType.byId(data.readByte());
	}	
}