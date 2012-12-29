package mcwarfare.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBullet extends EntityArrow {

	public EntityBullet(World world) {
		super(world);
	}
	
	public EntityBullet(World par1World, EntityLiving par2EntityLiving, float par3) {
        super(par1World, par2EntityLiving, par3);
    }
}