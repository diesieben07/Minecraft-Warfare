package mcwarfare.client.render;

import mcwarfare.client.models.ModelGrenade;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class RenderGrenade extends Render {

	private final ModelGrenade model = new ModelGrenade();
	
	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        
        GL11.glRotatef(var8, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        loadTexture("/mcwarfare/resource/tex/grenade.png");
		model.render(var1, 0, 0, 0, 0, 0, 0);
        GL11.glPopMatrix();
	}
}
