package mcwarfare.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {

	private boolean impacted = false;
	private int impactTicks = 0;
	
	public EntityGrenade(World world) {
		super(world);
	}
	
	public EntityGrenade(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		impacted = true;
		motionX = 0;
		motionY = 0;
		motionZ = 0;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (impacted) {
			impactTicks++;
			System.out.println("imp");
			if (impactTicks >= 20) {
				worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 4, true);
				setDead();
			}
		}
	}	
}