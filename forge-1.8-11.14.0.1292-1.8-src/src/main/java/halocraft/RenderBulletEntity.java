package halocraft;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBulletEntity extends Render{
	private static final ResourceLocation bulletTextures = new ResourceLocation("halocraft:textures/entities/BulletRender.png");
	public RenderBulletEntity(RenderManager rendermanager) {
		super(rendermanager);
		// TODO Auto-generated constructor stub
	}
	protected ResourceLocation getEntityTexture(EntityBullet entity){
		return bulletTextures;
	}
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityBullet)entity);	

	}
}