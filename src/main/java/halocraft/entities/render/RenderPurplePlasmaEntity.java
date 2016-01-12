package halocraft.entities.render;

import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import halocraft.entities.EntityPurplePlasma;
import halocraft.models.ModelBullet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPurplePlasmaEntity extends Render<EntityPurplePlasma>
{
	public WavefrontModel needleModel = WavefrontAPI.instance().loadModel(halocraft.HaloCraft.class, "halocraft", "Needle", "/assets/halocraft/models/entity/Needle");
	private static final ResourceLocation plasmaTextures = new ResourceLocation("halocraft:textures/entities/PurplePlasmaRender.png");

	public RenderPurplePlasmaEntity(RenderManager rendermanager)
	{
		super(rendermanager);
		this.shadowSize = 0.5F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPurplePlasma entity)
	{
		return plasmaTextures;
	}

	@Override
	public void doRender(EntityPurplePlasma plasma, double posX, double posY, double posZ, float f, float f1)
	{
		bindEntityTexture(plasma);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) posX, (float) posY, (float) posZ);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F - plasma.prevRotationPitch - (plasma.rotationPitch - plasma.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		ModelBase model = new ModelBullet();
		if (model != null)
			model.render(plasma, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
