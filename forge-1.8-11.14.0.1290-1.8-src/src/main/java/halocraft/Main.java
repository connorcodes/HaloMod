package halocraft;

import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid="halocraft", version="pre1.0")
public class Main{
	public static String MODID = "halocraft";
	public static String VERSION = "1";
	//World Generation
	public static HaloGenerationClass HaloOreGen;
	//Armor Material
	public static ArmorMaterial HaloArmor;
	//Weapons
	public static ItemSword swordEnergySword;
	//Blocks
	public static Block forerunnerBlock;
	public final static Block HaloOre = new HaloOre(Material.rock);
	//Entities
	public static Entity mobElite;
	public static Entity rocket;
	public static Entity bullet;
	public static Entity entityMongoose;
	//Armor
	public static int helmetID = 0;
	public static int chestplateID = 0;
	public static int leggingID = 0;
	public static int bootID = 0;
	public static Item SpartanHelmet;
	public static Item SpartanChestplate;
	public static Item SpartanLeggings;
	public static Item SpartanBoots;
	//Items
	public static Item HaloIngot = new HaloIngot();
	public static Item rocketLauncher;
	public static Item ammoRocket;
	public static Item itemAssaultRifle;
	public static Item ammoAssaultRifle;
	public static Item itemBattleRifle;
	public static Item itemMongoose;
	@EventHandler
	public void init(FMLPreInitializationEvent e){
		HaloArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/HaloArmor", 100, new int[]{4, 4, 10, 8}, 30);
		HaloOreGen = new HaloGenerationClass();
		rocketLauncher = new rocketLauncher();
		ammoRocket = new itemRocket();
		ammoAssaultRifle = new ammoAssaultRifle();
		itemAssaultRifle = new itemAssaultRifle();
		itemBattleRifle = new itemBattleRifle();
		itemMongoose = new ItemMongoose();
		SpartanHelmet = new HaloArmor(HaloArmor, helmetID, 0).setUnlocalizedName("SpartanHelmet");
		SpartanChestplate = new HaloArmor(HaloArmor, chestplateID, 1).setUnlocalizedName("SpartanChestplate");
		SpartanLeggings = new HaloArmor(HaloArmor, leggingID, 2).setUnlocalizedName("SpartanLeggings");
		SpartanBoots = new HaloArmor(HaloArmor, bootID, 3).setUnlocalizedName("SpartanBoots");
		swordEnergySword = new swordEnergySword(ToolMaterial.EMERALD);
		GameRegistry.registerItem(swordEnergySword, "energySword");
		forerunnerBlock = new forerunnerBlock(Material.rock);
		entityMongoose = new EntityMongoose(null);
		rocket = new EntityRocket(null);
		bullet = new EntityBullet(null);
		mobElite = new EntityElite(null);
		int randomID3 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", randomID3);
		int randomID4 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityMongoose.class, "Mongoose", randomID4);
		int randomID2 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityRocket.class, "Rocket", randomID2);
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityElite.class, "Elite", randomID, 230, 78);
		EntityRegistry.addSpawn(EntityElite.class, 5, 1, 2, EnumCreatureType.MONSTER);
		GameRegistry.registerItem(itemMongoose, "itemMongoose");
		GameRegistry.registerBlock(forerunnerBlock, "forerunnerBlock");
		GameRegistry.registerItem(SpartanHelmet, "SpartanHelmet");
		GameRegistry.registerItem(SpartanChestplate, "SpartanChestplate");
		GameRegistry.registerItem(SpartanLeggings, "SpartanLeggings");
		GameRegistry.registerItem(SpartanBoots, "SpartanBoots");
		GameRegistry.registerBlock(HaloOre, "HaloOre");
		GameRegistry.registerItem(HaloIngot, "HaloIngot");
		GameRegistry.registerItem(rocketLauncher, "rocketLauncher");
		GameRegistry.registerItem(ammoRocket, "ammoRocket");
		GameRegistry.registerItem(ammoAssaultRifle, "ammoAssaultRifle");
		GameRegistry.registerItem(itemAssaultRifle, "itemAssaultRifle");
		GameRegistry.registerItem(itemBattleRifle, "itemBattleRifle");
		//Recipies
		GameRegistry.addRecipe(new ItemStack(SpartanHelmet, 1), new Object[]{"XXX","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanChestplate, 1), new Object[]{"X X","XXX", "XXX", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanLeggings, 1), new Object[]{"XXX","X X","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanBoots, 1), new Object[]{"X X","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(ammoRocket, 5), new Object[]{" X "," X ", " X ", 'X', HaloIngot});
		ItemStack gunStack = new ItemStack(Items.gunpowder);
		GameRegistry.addRecipe(new ItemStack(rocketLauncher, 1), new Object[]{"XXX", "XYX", "XYX", 'X', HaloIngot, 'Y', gunStack});
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(itemAssaultRifle, 1), new Object[]{"ZXX", " ZX", " YZ", 'X', HaloIngot, 'Y', gunStack, 'Z', ironStack});
		ItemStack goldStack = new ItemStack(Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ammoAssaultRifle, 15), new Object[]{" X ", " X ", "XYX", 'X', goldStack, 'Y', gunStack});
		GameRegistry.addSmelting(HaloOre, new ItemStack(HaloIngot, 1), 0.1f);
		//World Gen
		GameRegistry.registerWorldGenerator(HaloOreGen, 1);
	}
	@EventHandler
	public void init(FMLInitializationEvent e){
		ModelResourceLocation res = new ModelResourceLocation("halocraft:energySword", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(swordEnergySword, 0, res);
		ModelResourceLocation res2 = new ModelResourceLocation("halocraft:HaloIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(HaloIngot, 0, res2);
		ModelResourceLocation res3 = new ModelResourceLocation("halocraft:SpartanChestplate", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SpartanChestplate, 0, res3);
		ModelResourceLocation res4 = new ModelResourceLocation("halocraft:SpartanHelmet", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SpartanHelmet, 0, res4);
		ModelResourceLocation res5 = new ModelResourceLocation("halocraft:SpartanLeggings", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SpartanLeggings, 0, res5);
		ModelResourceLocation res6 = new ModelResourceLocation("halocraft:SpartanBoots", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SpartanBoots, 0, res6);
		ModelResourceLocation res7 = new ModelResourceLocation("halocraft:ammoRocket", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ammoRocket, 0, res7);
		ModelResourceLocation res8 = new ModelResourceLocation("halocraft:rocketLauncher", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(rocketLauncher, 0, res8);
		ModelResourceLocation res9 = new ModelResourceLocation("halocraft:ammoAssaultRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ammoAssaultRifle, 0, res9);
		ModelResourceLocation res10 = new ModelResourceLocation("halocraft:itemAssaultRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemAssaultRifle, 0, res10);
		ModelResourceLocation res11 = new ModelResourceLocation("halocraft:itemBattleRifle", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBattleRifle, 0, res11);
		ModelResourceLocation res12 = new ModelResourceLocation("halocraft:itemMongoose", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemMongoose, 0, res12);
		Item itemBlockSimple = GameRegistry.findItem("halocraft", "HaloOre");
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("halocraft:HaloOre", "inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
		RenderingRegistry.registerEntityRenderingHandler(EntityMongoose.class, new RenderMongooseEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBulletEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocketEntity(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityElite.class, new RenderEliteEntity(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0));
	}
	public static CreativeTabs haloWeapons = new CreativeTabs("Halo Weapons"){
	public Item getTabIconItem(){
	return Items.diamond_sword;
	}
	};
}

