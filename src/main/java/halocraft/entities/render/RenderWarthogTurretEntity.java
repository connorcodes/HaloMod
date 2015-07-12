package halocraft.entities.render;

import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityWarthog;
import halocraft.entities.EntityWarthogTurret;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWarthogTurretEntity extends Render
{
    private static final ModelResourceLocation warthogModel = new ModelResourceLocation("halocraft:models/entity/WarthogTurret.b3d");

    public RenderWarthogTurretEntity(RenderManager renderManager)
    {
        super(renderManager);
        this.shadowSize = 0.5F;
    }
    Function<ResourceLocation, TextureAtlasSprite> textureGetter = new Function<ResourceLocation, TextureAtlasSprite>()
            {
                public TextureAtlasSprite apply(ResourceLocation location)
                {
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
                }
            };

    public void doRender(EntityWarthogTurret entityWarthogTurret, double p_180552_2_, double p_180552_4_, double p_180552_6_, float p_180552_8_, float p_180552_9_) throws IOException
    {
    	IModel warthogTurret = B3DLoader.instance.loadModel(warthogModel);
    	IBakedModel bakedWarthogTurret = warthogTurret.bake((TRSRTransformation.identity()),  Attributes.DEFAULT_BAKED_FORMAT, textureGetter);
    	World world = entityWarthogTurret.getWorldObj();
    	BlockPos blockpos = new BlockPos(entityWarthogTurret);
    	Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)p_180552_2_, (float)p_180552_4_ + 0.75F, (float)p_180552_6_ + .5F);
        //GlStateManager.rotate(-360.0F, 0.0F, 1.0F, 0.0F);
        float f2 = (float)entityWarthogTurret.getTimeSinceHit() - p_180552_9_;
        float f3 = entityWarthogTurret.getDamageTaken() - p_180552_9_;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)entityWarthogTurret.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }
        
        float f4 = 0.75F;
        GlStateManager.scale(f4, f4, f4);
        GlStateManager.scale(1.0F / f4, 1.0F / f4, 1.0F / f4);
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        
        worldrenderer.startDrawingQuads();
        GlStateManager.rotate(-90f, 0f, 0f, 1f);
        //Get Quads
        List<BakedQuad> generalQuads = bakedWarthogTurret.getGeneralQuads();
		for (BakedQuad q : generalQuads) {
			int[] vd = q.getVertexData();
			worldrenderer.setVertexFormat(Attributes.DEFAULT_BAKED_FORMAT);
			worldrenderer.addVertexData(vd);
		}
		for (EnumFacing face : EnumFacing.values()) {
            List<BakedQuad> faceQuads = 
           		 bakedWarthogTurret.getFaceQuads(face);
            for (BakedQuad q : faceQuads) {
                    int[] vd = q.getVertexData();
                    worldrenderer.setVertexFormat(Attributes.DEFAULT_BAKED_FORMAT);
                   worldrenderer.addVertexData(vd);
           }
		 }
		tessellator.draw();
        GlStateManager.popMatrix();
        super.doRender(entityWarthogTurret, p_180552_2_, p_180552_4_, p_180552_6_, p_180552_8_, p_180552_9_);
    }

    protected ResourceLocation getEntityTexture(EntityWarthogTurret p_180553_1_)
    {
        return null;
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityWarthogTurret)entity);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        try {
			this.doRender((EntityWarthogTurret)entity, x, y, z, p_76986_8_, partialTicks);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}