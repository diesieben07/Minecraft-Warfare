package mcwarfare.common.entities;

import java.util.Random;

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
		if (target.entityHit != null) {
			target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, func_85052_h()), 2);
		}
	}

	@Override
	public void onUpdate() {
		//worldObj.spawnParticle("largesmoke", posX, posY, posZ, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
		
		super.onUpdate();
		if (impacted) {
			impactTicks++;
			
			if (impactTicks >= 40) {
				detonate();
			}
		}
	}
	
	
	private void detonate() {
		switch (type) {
		case NORMAL:
			if (!worldObj.isRemote) {
				worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 2, true);
				setDead();
			}
			break;
		case SMOKE:
			
			for(int i=0; i<200; i++){
				worldObj.spawnParticle("largesmoke", posX, posY, posZ, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.25 : .25), posY + (rand.nextBoolean() ? -.25 : .25), posZ + (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.5 : .5), posY + (rand.nextBoolean() ? -.5 : .5), posZ + (rand.nextBoolean() ? -.5 : .5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.75 : .75), posY + (rand.nextBoolean() ? -.75 : .75), posZ + (rand.nextBoolean() ? -.75 : .75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1 : 1), posY + (rand.nextBoolean() ? -1 : 1), posZ + (rand.nextBoolean() ? -1 : 1), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.25 : .25), posY + (rand.nextBoolean() ? -.25 : .25), posZ + (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.5 : .5), posY + (rand.nextBoolean() ? -.5 : .5), posZ + (rand.nextBoolean() ? -.5 : .5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.75 : .75), posY + (rand.nextBoolean() ? -.75 : .75), posZ + (rand.nextBoolean() ? -.75 : .75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1 : 1), posY + (rand.nextBoolean() ? -1 : 1), posZ + (rand.nextBoolean() ? -1 : 1), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.25 : .25), posY + (rand.nextBoolean() ? -.25 : .25), posZ + (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.5 : .5), posY + (rand.nextBoolean() ? -.5 : .5), posZ + (rand.nextBoolean() ? -.5 : .5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.75 : .75), posY + (rand.nextBoolean() ? -.75 : .75), posZ + (rand.nextBoolean() ? -.75 : .75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1 : 1), posY + (rand.nextBoolean() ? -1 : 1), posZ + (rand.nextBoolean() ? -1 : 1), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1.25 : 1.25), posY + (rand.nextBoolean() ? -1.25 : 1.25), posZ + (rand.nextBoolean() ? -1.25 : 1.25), rand.nextDouble() * (rand.nextBoolean() ? -1.25 : 1.25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1.5 : 1.5), posY + (rand.nextBoolean() ? -1.5 : 1.5), posZ + (rand.nextBoolean() ? -1.5 : 1.5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1.75 : 1.75), posY + (rand.nextBoolean() ? -1.75 : 1.75), posZ + (rand.nextBoolean() ? -1.75 : 1.75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2 : 2), posY + (rand.nextBoolean() ? -2 : 2), posZ + (rand.nextBoolean() ? -2 : 2), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2.25 : 2.25), posY + (rand.nextBoolean() ? -2.25 : 2.25), posZ + (rand.nextBoolean() ? -2.25 : 2.25), rand.nextDouble() * (rand.nextBoolean() ? -2.25 : 2.25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2.5 : 2.5), posY + (rand.nextBoolean() ? -2.5 : 2.5), posZ + (rand.nextBoolean() ? -2.5 : 2.5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2.75 : 2.75), posY + (rand.nextBoolean() ? -2.75 : 2.75), posZ + (rand.nextBoolean() ? -2.75 : 2.75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3 : 3), posY + (rand.nextBoolean() ? -3 : 3), posZ + (rand.nextBoolean() ? -3 : 3), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
			
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3.25 : 3.25), posY + (rand.nextBoolean() ? -3.25 : 3.25), posZ + (rand.nextBoolean() ? -3.25 : 3.25), rand.nextDouble() * (rand.nextBoolean() ? -3.25 : 3.25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3.5 : 2.5), posY + (rand.nextBoolean() ? -3.5 : 3.5), posZ + (rand.nextBoolean() ? -3.5 : 3.5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3.75 : 2.75), posY + (rand.nextBoolean() ? -3.75 : 3.75), posZ + (rand.nextBoolean() ? -3.75 : 3.75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -4 : 4), posY + (rand.nextBoolean() ? -4 : 4), posZ + (rand.nextBoolean() ? -4 : 4), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.25 : .25), posY + (rand.nextBoolean() ? -.25 : .25), posZ + (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.5 : .5), posY + (rand.nextBoolean() ? -.5 : .5), posZ + (rand.nextBoolean() ? -.5 : .5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -.75 : .75), posY + (rand.nextBoolean() ? -.75 : .75), posZ + (rand.nextBoolean() ? -.75 : .75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1 : 1), posY + (rand.nextBoolean() ? -1 : 1), posZ + (rand.nextBoolean() ? -1 : 1), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1.25 : 1.25), posY + (rand.nextBoolean() ? -1.25 : 1.25), posZ + (rand.nextBoolean() ? -1.25 : 1.25), rand.nextDouble() * (rand.nextBoolean() ? -1.25 : 1.25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1.5 : 1.5), posY + (rand.nextBoolean() ? -1.5 : 1.5), posZ + (rand.nextBoolean() ? -1.5 : 1.5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -1.75 : 1.75), posY + (rand.nextBoolean() ? -1.75 : 1.75), posZ + (rand.nextBoolean() ? -1.75 : 1.75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2 : 2), posY + (rand.nextBoolean() ? -2 : 2), posZ + (rand.nextBoolean() ? -2 : 2), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2.25 : 2.25), posY + (rand.nextBoolean() ? -2.25 : 2.25), posZ + (rand.nextBoolean() ? -2.25 : 2.25), rand.nextDouble() * (rand.nextBoolean() ? -2.25 : 2.25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2.5 : 2.5), posY + (rand.nextBoolean() ? -2.5 : 2.5), posZ + (rand.nextBoolean() ? -2.5 : 2.5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -2.75 : 2.75), posY + (rand.nextBoolean() ? -2.75 : 2.75), posZ + (rand.nextBoolean() ? -2.75 : 2.75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3 : 3), posY + (rand.nextBoolean() ? -3 : 3), posZ + (rand.nextBoolean() ? -3 : 3), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
			
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3.25 : 3.25), posY + (rand.nextBoolean() ? -3.25 : 3.25), posZ + (rand.nextBoolean() ? -3.25 : 3.25), rand.nextDouble() * (rand.nextBoolean() ? -3.25 : 3.25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3.5 : 2.5), posY + (rand.nextBoolean() ? -3.5 : 3.5), posZ + (rand.nextBoolean() ? -3.5 : 3.5), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -3.75 : 2.75), posY + (rand.nextBoolean() ? -3.75 : 3.75), posZ + (rand.nextBoolean() ? -3.75 : 3.75), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -4 : 4), posY + (rand.nextBoolean() ? -4 : 4), posZ + (rand.nextBoolean() ? -4 : 4), rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25), rand.nextDouble() / 8, rand.nextDouble() * (rand.nextBoolean() ? -.25 : .25));
				}

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
		nbt.setBoolean("hasImpacted", impacted);
		nbt.setInteger("impactTicks", impactTicks);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		type = GrenadeType.byId(nbt.getByte("grenadeType"));
		impacted = nbt.getBoolean("hasImpacted");
		impactTicks = nbt.getInteger("impactTicks");
	}

	@Override
	public void readSpawnData(ByteArrayDataInput data) {
		type = GrenadeType.byId(data.readByte());
	}	
}