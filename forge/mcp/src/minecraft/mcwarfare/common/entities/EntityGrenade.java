package mcwarfare.common.entities;

import java.util.List;
import java.util.Random;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import mcwarfare.common.items.GrenadeType;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable implements IEntityAdditionalSpawnData {

	private boolean impacted = false;
	private int impactTicks = 0;
	private boolean var8;
	
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
		super.onUpdate();
		if (impacted) {
			impactTicks++;
			
			if (impactTicks >= 40) {
				
				switch (type){
				case NORMAL:
					detonate();
				case SMOKE :
				 
					detonate();
				}
				
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

			if (rand.nextInt(2) == 0) {
				
				for (int i = 0; i < 300; i++) {
					worldObj.spawnParticle("largesmoke", posX + (rand.nextBoolean() ? -4 : 4) * rand.nextDouble(), posY, posZ + (rand.nextBoolean() ? -4 : 4) * rand.nextDouble(), (rand.nextBoolean() ? -.1 : .1) * rand.nextDouble() * rand.nextDouble(), rand.nextDouble() * rand.nextDouble(), (rand.nextBoolean() ? -.1 : .1) * rand.nextDouble() * rand.nextDouble());
				}
			}
			if (!worldObj.isRemote && rand.nextInt(500) == 0) {
				setDead();
			}
			break;
			}
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
	public void writeSpawnData(ByteArrayDataOutput data) {
		data.writeByte(type.toId());
		data.writeBoolean(impacted);
		data.writeInt(impactTicks);
	}

	@Override
	public void readSpawnData(ByteArrayDataInput data) {
		type = GrenadeType.byId(data.readByte());
		impacted = data.readBoolean();
		impactTicks = data.readInt();
	}	
}