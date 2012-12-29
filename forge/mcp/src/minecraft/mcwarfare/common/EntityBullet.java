package mcwarfare.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {

	public EntityBullet(World world) {
		super(world);
	}
	
	public EntityBullet(World world, EntityLiving living) {
        super(world, living);
    }

	@Override
	protected void onImpact(MovingObjectPosition impact) {
		
	}
}