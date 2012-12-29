package mcwarfare.common;

import java.util.Iterator;
import java.util.List;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.PacketDispatcher;



import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;


public class EntityGrenade extends EntityThrowable 
{
        private int xTile = -1;
        private int yTile = -1;
        private int zTile = -1;
        private int inTile = 0;
        private int inData = 0;
        private boolean inGround = false;
        private int knockbackStrength = 0;
        private int ticksInGround;
        private int ticksInAir = 0;
        public String color;
        private double gravity;

        public EntityGrenade(World world)
        {
                super(world);
                this.setSize(0.5F, 0.5F);
        }

        public EntityGrenade(World world, EntityLiving entityliving)
        {
                super(world);
                
                this.setLocationAndAngles(entityliving.posX, entityliving.posY + entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
                this.setPosition(this.posX, this.posY, this.posZ);
                this.motionX = 5.0 * -MathHelper.sin(this.rotationYaw / 180F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180F * 3.141593F);
                this.motionZ = 5.0 * MathHelper.cos(this.rotationYaw / 180F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180F * 3.141593F);
                this.motionY = 5.0 * -MathHelper.sin(this.rotationPitch / 180F * 3.141593F);
                this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 1.5F, 1.0F);
                
               
        }

        

       

		@Override
		protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
			if (par1MovingObjectPosition.entityHit != null)
	        {
	            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_85052_h()), 0);
	        }

	        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
	        {
	            byte var2 = 1;

	            if (this.rand.nextInt(32) == 0)
	            {
	                var2 = 4;
	            }

	            for (int var3 = 0; var3 < var2; ++var3)
	            {
	                EntityChicken var4 = new EntityChicken(this.worldObj);
	                var4.setGrowingAge(-24000);
	                var4.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
	                this.worldObj.spawnEntityInWorld(var4);
	            }
	        }

	        for (int var5 = 0; var5 < 8; ++var5)
	        {
	            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	        }

	        if (!this.worldObj.isRemote)
	        {
	            this.setDead();
	        }
			
		}
		@Override
		
        public void onUpdate()
        {
                if (this.ticksInGround == 30)
                {
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 0.0F, true);
                        this.setDead();
                
        }
		
}}
