package mcwarfare.common.entities;

import mcwarfare.common.items.GunType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntityBullet extends EntityThrowable {
	
	public GunType gun;
	
	public EntityBullet(World world) {
		super(world);
	}
	
	public EntityBullet(World world, EntityLiving living, GunType gun) {
        super(world, living);
        this.gun = gun;
    }
	
	@Override
	protected void onImpact(MovingObjectPosition hit) {
		if (hit.entityHit != null) {
			hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, func_85052_h()), gun.getBulletDamage());
		}
		setDead();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setByte("gunType", (byte)gun.getId());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		gun = GunType.byId(nbt.getByte("gunType"));
	}
}