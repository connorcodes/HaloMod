package halocraft;

import halocraft.armor.ActiveCamoArmor;
import halocraft.armor.CovenantArmor;
import halocraft.armor.HaloArmor;
import halocraft.blocks.HaloBlock;
import halocraft.blocks.HaloOre;
import halocraft.blocks.PurplePlasmaBlock;
import halocraft.blocks.RedPlasmaBlock;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityFragGrenade;
import halocraft.entities.EntityGhost;
import halocraft.entities.EntityGreenPlasma;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityPlasmaRocket;
import halocraft.entities.EntityPurplePlasma;
import halocraft.entities.EntityRedPlasma;
import halocraft.entities.EntityRocket;
import halocraft.entities.EntityScorpion;
import halocraft.entities.EntityWarthog;
import halocraft.entities.EntityWarthogTurret;
import halocraft.items.CovenantPiece;
import halocraft.items.FragGrenade;
import halocraft.items.GreenPlasmaIngot;
import halocraft.items.HaloIngot;
import halocraft.items.ItemAmmoAssaultRifle;
import halocraft.items.ItemAmmoPlasma;
import halocraft.items.ItemAmmoPlasmaRocket;
import halocraft.items.ItemAssaultRifle;
import halocraft.items.ItemBattleRifle;
import halocraft.items.ItemCarbineAmmo;
import halocraft.items.ItemCarbineRifle;
import halocraft.items.ItemEnergySword;
import halocraft.items.ItemFuelRodCannon;
import halocraft.items.ItemGhost;
import halocraft.items.ItemHealthPack;
import halocraft.items.ItemIncinerationCannon;
import halocraft.items.ItemMongoose;
import halocraft.items.ItemNeedler;
import halocraft.items.ItemNeedlerAmmo;
import halocraft.items.ItemOil;
import halocraft.items.ItemRedPlasmaAmmo;
import halocraft.items.ItemRocket;
import halocraft.items.ItemRubber;
import halocraft.items.ItemScorpion;
import halocraft.items.ItemSniperRifle;
import halocraft.items.ItemWarthog;
import halocraft.items.ItemWarthogTurret;
import halocraft.items.ItemWheel;
import halocraft.items.Pistol;
import halocraft.items.PlasmaRifle;
import halocraft.items.PurplePlasmaIngot;
import halocraft.items.RedPlasmaIngot;
import halocraft.items.RocketLauncher;
import halocraft.items.TankHarvester;
import halocraft.packets.FireMessage;
import halocraft.packets.FireMessageHandler;
import halocraft.packets.HalocraftPacketHandler;
import halocraft.proxies.ClientProxy;
import halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid="halocraft", version="1.3")
public class Main{
	@SidedProxy(clientSide="halocraft.proxies.ClientProxy", serverSide="halocraft.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	public static String MODID = "halocraft";
	public static String VERSION = "1.3";
	//World Generation
	public static HaloGenerationClass HaloOreGen;
	//Armor Material
	public static ArmorMaterial HaloArmor;
	public static ArmorMaterial CovenantArmor;
	public static ArmorMaterial ActiveCamoArmor;
	//Blocks
	public final static Block HaloOre = new HaloOre(Material.iron);
	public final static Block RedPlasmaOre = new halocraft.blocks.RedPlasmaOre(Material.iron);
	public final static Block GreenPlasmaOre = new halocraft.blocks.GreenPlasmaOre(Material.iron);
	public final static Block PurplePlasmaOre = new halocraft.blocks.PurplePlasmaOre(Material.iron);
	//Armor
	public static int helmetID = 0;
	public static int chestplateID = 0;
	public static int leggingID = 0;
	public static int bootID = 0;
	public static Item SpartanHelmet;
	public static Item SpartanChestplate;
	public static Item SpartanLeggings;
	public static Item SpartanBoots;
	public static Item RedSpartanHelmet;
	public static Item RedSpartanChestplate;
	public static Item RedSpartanLeggings;
	public static Item RedSpartanBoots;
	public static Item GreenSpartanHelmet;
	public static Item GreenSpartanChestplate;
	public static Item GreenSpartanLeggings;
	public static Item GreenSpartanBoots;
	public static Item BlueSpartanHelmet;
	public static Item BlueSpartanChestplate;
	public static Item BlueSpartanLeggings;
	public static Item BlueSpartanBoots;
	public static Item CovenantHelmet;
	public static Item CovenantChestplate;
	public static Item CovenantLeggings;
	public static Item CovenantBoots;
	public static Item covenantPiece;
	public static Item ActiveCamoChestplate;
	//Items
	public static Item HaloIngot = new HaloIngot();
	public static Item ammoRocket;
	public static Item ammoAssaultRifle;
	public static Item ammoPlasma;
	public static Item itemWheel;
	public static Item itemOil;
	public static Item itemRedPlasmaAmmo;
	public static Item ammoPlasmaRocket;
	public static Item tankHarvester;
	public static Item itemRubber;
	public static Item itemWarthogTurret;
	//Tool Materials
	public static ToolMaterial HaloMaterial;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		itemOil = new ItemOil();
		itemWheel = new ItemWheel();
		itemRubber = new ItemRubber();
		ammoPlasmaRocket = new ItemAmmoPlasmaRocket();
		//Initalize Tank Harvester
		tankHarvester = new TankHarvester();
		itemWarthogTurret = new ItemWarthogTurret();
		//Initialize Plasma
		ammoPlasma = new ItemAmmoPlasma();
		HaloMaterial = EnumHelper.addToolMaterial("HaloMaterial", 3, 1750, 9.0F, 6.0F, 10);
		HaloArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/HaloArmor", 100, new int[]{6, 6, 10, 8}, 30);
		CovenantArmor = EnumHelper.addArmorMaterial("CovenantArmor", "halocraft:textures/models/armor/CovenantArmor", 85, new int[]{4, 4, 10, 8}, 30);
		ActiveCamoArmor = EnumHelper.addArmorMaterial("ActiveCamoArmor", "halocraft:textures/models/armor/ActiveCamoArmor", 100, new int[]{6, 6, 10, 8}, 30);
		HaloOreGen = new HaloGenerationClass();
		//HaloBlock = new HaloBlock(Material.iron);
		covenantPiece = new CovenantPiece();
		ammoRocket = new ItemRocket();
		ammoAssaultRifle = new ItemAmmoAssaultRifle();
		itemRedPlasmaAmmo = new ItemRedPlasmaAmmo();
		halocraft.Main.BlueSpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("BlueSpartanHelmet");
		halocraft.Main.BlueSpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("BlueSpartanChestplate");
		halocraft.Main.BlueSpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("BlueSpartanLeggings");
		halocraft.Main.BlueSpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("BlueSpartanBoots");
		halocraft.Main.GreenSpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("GreenSpartanHelmet");
		halocraft.Main.GreenSpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("GreenSpartanChestplate");
		halocraft.Main.GreenSpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("GreenSpartanLeggings");
		halocraft.Main.GreenSpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("GreenSpartanBoots");
		halocraft.Main.RedSpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("RedSpartanHelmet");
		halocraft.Main.RedSpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("RedSpartanChestplate");
		halocraft.Main.RedSpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("RedSpartanLeggings");
		halocraft.Main.RedSpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("RedSpartanBoots");
		halocraft.Main.SpartanHelmet = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("SpartanHelmet");
		halocraft.Main.SpartanChestplate = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("SpartanChestplate");
		halocraft.Main.SpartanLeggings = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("SpartanLeggings");
		halocraft.Main.SpartanBoots = new HaloArmor(halocraft.Main.HaloArmor, halocraft.Main.bootID, 3).setUnlocalizedName("SpartanBoots");
		halocraft.Main.CovenantHelmet = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.helmetID, 0).setUnlocalizedName("CovenantHelmet");
		halocraft.Main.CovenantChestplate = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("CovenantChestplate");
		halocraft.Main.CovenantLeggings = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.leggingID, 2).setUnlocalizedName("CovenantLeggings");
		halocraft.Main.CovenantBoots = new CovenantArmor(halocraft.Main.CovenantArmor, halocraft.Main.bootID, 3).setUnlocalizedName("CovenantBoots");
		halocraft.Main.ActiveCamoChestplate = new ActiveCamoArmor(halocraft.Main.ActiveCamoArmor, halocraft.Main.chestplateID, 1).setUnlocalizedName("ActiveCamoChestplate");
		GameRegistry.registerItem(ItemEnergySword.instance, ItemEnergySword.name);
		int randomID3 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", randomID3, this, 250, 50, true);
		int randomID4 = EntityRegistry.findGlobalUniqueEntityId() + 1;
		EntityRegistry.registerModEntity(EntityMongoose.class, "Mongoose", randomID4, this, 250, 50, true);
		int randomID9 = EntityRegistry.findGlobalUniqueEntityId() + 5;
		EntityRegistry.registerModEntity(EntityScorpion.class, "Socrpion", randomID9, this, 250, 50, true);
		int randomID10 = EntityRegistry.findGlobalUniqueEntityId() + 6;
		EntityRegistry.registerModEntity(EntityPlasmaRocket.class, "PlasmaRocket", randomID10, this, 250, 50, true);
		int randomID11 = EntityRegistry.findGlobalUniqueEntityId() + 7;
		EntityRegistry.registerModEntity(EntityGhost.class, "Ghost", randomID11, this, 250, 50, true);
		int randomID12 = EntityRegistry.findGlobalUniqueEntityId() + 8;
		EntityRegistry.registerModEntity(EntityPurplePlasma.class, "PurplePlasma", randomID12, this, 250, 50, true);
		int randomID14 = EntityRegistry.findGlobalUniqueEntityId() + 10;
		EntityRegistry.registerModEntity(EntityWarthogTurret.class, "WarthogTurret", randomID14, this, 250, 50, true);
		int randomID2 = EntityRegistry.findGlobalUniqueEntityId() + 2;
		EntityRegistry.registerModEntity(EntityRocket.class, "Rocket", randomID2, this, 250, 50, true);
		int randomID7 = EntityRegistry.findGlobalUniqueEntityId() + 3;
		EntityRegistry.registerModEntity(EntityRedPlasma.class, "RedPlasma", randomID7, this, 250, 50, true);
		int randomID8 = EntityRegistry.findGlobalUniqueEntityId() + 4;
		EntityRegistry.registerModEntity(EntityGreenPlasma.class, "GreenPlasma", randomID8, this, 250, 50, true);
		int randomID13 = EntityRegistry.findGlobalUniqueEntityId() + 9;
		EntityRegistry.registerModEntity(EntityWarthog.class, "Warthog", randomID13, this, 250, 50, true);
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityElite.class, "Elite", randomID, 230, 78);
		EntityRegistry.addSpawn(EntityElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, 
				BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, 
				BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, 
				BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, 
				BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, 
				BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);
		int randomID5 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityGrunt.class, "Grunt", randomID5, 78, 230);
		EntityRegistry.addSpawn(EntityGrunt.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, 
				BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, 
				BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, 
				BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, 
				BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, 
				BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);
		//EntityRegistry.registerModEntity(EntityElite.class,"Elite", randomID, this, 250, 50, true);
		int randomID6 = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(EntityFragGrenade.class, "fragGrenade", randomID6 + 1, this, 128, 1, true);
		GameRegistry.registerBlock(HaloOre, "HaloOre");
		GameRegistry.registerBlock(RedPlasmaBlock.instance, RedPlasmaBlock.name);
		GameRegistry.registerBlock(PurplePlasmaBlock.instance, PurplePlasmaBlock.name);
		GameRegistry.registerItem(itemWheel, "itemWheel");
		GameRegistry.registerItem(itemOil, "itemOil");
		GameRegistry.registerBlock(RedPlasmaOre, "RedPlasmaOre");
		GameRegistry.registerBlock(GreenPlasmaOre, "GreenPlasmaOre");
		GameRegistry.registerBlock(PurplePlasmaOre, "PurplePlasmaOre");
		GameRegistry.registerBlock(HaloBlock.instance, HaloBlock.name);
		GameRegistry.registerItem(ItemMongoose.instance, ItemMongoose.name);
		GameRegistry.registerItem(itemWarthogTurret, "itemWarthogTurret");
		GameRegistry.registerItem(covenantPiece, "covenantPiece");
		GameRegistry.registerItem(FragGrenade.instance, FragGrenade.name);
		GameRegistry.registerItem(HaloIngot, "HaloIngot");
		GameRegistry.registerItem(RocketLauncher.instance, RocketLauncher.name);
		GameRegistry.registerItem(ammoRocket, "ammoRocket");
		GameRegistry.registerItem(ammoAssaultRifle, "ammoAssaultRifle");
		GameRegistry.registerItem(ItemAssaultRifle.instance, ItemAssaultRifle.name);
		GameRegistry.registerItem(ItemBattleRifle.instance, ItemBattleRifle.name);
		GameRegistry.registerItem(ItemHealthPack.instance, ItemHealthPack.name);
		GameRegistry.registerItem(itemRedPlasmaAmmo, "itemRedPlasmaAmmo");
		GameRegistry.registerItem(ItemGhost.instance, ItemGhost.name);
		GameRegistry.registerItem(ammoPlasmaRocket, "ammoPlasmaRocket");
		GameRegistry.registerItem(itemRubber, "itemRubber");
		GameRegistry.registerItem(ItemScorpion.instance, ItemScorpion.name);
		GameRegistry.registerItem(ItemIncinerationCannon.instance, ItemIncinerationCannon.name);
		GameRegistry.registerItem(ammoPlasma, "ammoPlasma");
		GameRegistry.registerItem(Pistol.instance, Pistol.name);
		GameRegistry.registerItem(ItemNeedlerAmmo.instance, ItemNeedlerAmmo.name);
		GameRegistry.registerItem(RedPlasmaIngot.instance, RedPlasmaIngot.name);
		GameRegistry.registerItem(ItemSniperRifle.instance, ItemSniperRifle.name);
		GameRegistry.registerItem(tankHarvester, "TankHarvester");
		GameRegistry.registerItem(ItemCarbineRifle.instance, ItemCarbineRifle.name);
		GameRegistry.registerItem(ItemNeedler.instance, ItemNeedler.name);
		GameRegistry.registerItem(ItemWarthog.instance, ItemWarthog.name);
		GameRegistry.registerItem(halocraft.Main.SpartanHelmet, "SpartanHelmet");
		GameRegistry.registerItem(GreenPlasmaIngot.instance, GreenPlasmaIngot.name);
		GameRegistry.registerItem(halocraft.Main.SpartanChestplate, "SpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.SpartanLeggings, "SpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.SpartanBoots, "SpartanBoots");
		GameRegistry.registerItem(halocraft.Main.RedSpartanHelmet, "RedSpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.RedSpartanChestplate, "RedSpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.RedSpartanLeggings, "RedSpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.RedSpartanBoots, "RedSpartanBoots");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanHelmet, "GreenSpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanChestplate, "GreenSpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanLeggings, "GreenSpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.GreenSpartanBoots, "GreenSpartanBoots");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanHelmet, "BlueSpartanHelmet");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanChestplate, "BlueSpartanChestplate");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanLeggings, "BlueSpartanLeggings");
		GameRegistry.registerItem(halocraft.Main.BlueSpartanBoots, "BlueSpartanBoots");
		GameRegistry.registerItem(PurplePlasmaIngot.instance, PurplePlasmaIngot.name);
		GameRegistry.registerItem(halocraft.Main.CovenantHelmet, "CovenantHelmet");
		GameRegistry.registerItem(halocraft.Main.CovenantChestplate, "CovenantChestplate");
		GameRegistry.registerItem(halocraft.Main.CovenantLeggings, "CovenantLeggings");
		GameRegistry.registerItem(halocraft.Main.CovenantBoots, "CovenantBoots");
		GameRegistry.registerItem(halocraft.Main.ActiveCamoChestplate, "ActiveCamoChestplate");
		GameRegistry.registerItem(ItemFuelRodCannon.instance, ItemFuelRodCannon.name);
		GameRegistry.registerItem(PlasmaRifle.instance, PlasmaRifle.name);
		GameRegistry.registerItem(ItemCarbineAmmo.instance, ItemCarbineAmmo.name);
		//Block Recipes
		GameRegistry.addRecipe(new ItemStack(HaloBlock.instance, 1), new Object[]{"XXX","XXX","XXX", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(PurplePlasmaBlock.instance, 1), new Object[]{"XXX","XXX","XXX", 'X', PurplePlasmaIngot.instance});
		GameRegistry.addRecipe(new ItemStack(RedPlasmaBlock.instance, 1), new Object[]{"XXX","XXX","XXX", 'X', RedPlasmaIngot.instance});
		
		GameRegistry.addRecipe(new ItemStack(itemRubber, 2), new Object[]{"XXX","XXX","XXX", 'X', itemOil});
		
		//Gun Recipes
		ItemStack gunpowderStack = new ItemStack(Items.gunpowder);
		ItemStack glassPaneStack = new ItemStack(Blocks.glass_pane);
		GameRegistry.addRecipe(new ItemStack(ItemBattleRifle.instance, 1), new Object[]{"ZA ","XXY", " AX", 'X', HaloIngot, 'Y', gunpowderStack, 'Z', glassPaneStack, 'A', new ItemStack(Items.iron_ingot)});
		GameRegistry.addRecipe(new ItemStack(Pistol.instance, 1), new Object[]{"   "," XY", "  Z", 'X', HaloIngot, 'Y', gunpowderStack, 'Z', new ItemStack(Items.iron_ingot)});
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifle.instance, 1), new Object[]{"XYX","ZYY", " IY", 'X', glassPaneStack, 'Y', HaloIngot, 'Z', gunpowderStack, 'I', new ItemStack(Items.iron_ingot)});
		//Recipes
		ItemStack woolStack = new ItemStack(Blocks.wool);
		ItemStack goldenAppleStack = new ItemStack(Items.golden_apple);
		GameRegistry.addRecipe(new ItemStack(itemWarthogTurret, 1), new Object[]{"  Z","XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel, 'Z', ItemAssaultRifle.instance});
		GameRegistry.addRecipe(new ItemStack(ItemWarthog.instance, 1), new Object[]{"   ","XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel});
		GameRegistry.addRecipe(new ItemStack(ItemScorpion.instance, 1), new Object[]{"YXX","XXX", "XXX", 'X', HaloBlock.instance, 'Y', RocketLauncher.instance});
		GameRegistry.addRecipe(new ItemStack(ItemGhost.instance, 1), new Object[]{"   ","XY ", "YYY", 'X', PlasmaRifle.instance, 'Y', PurplePlasmaBlock.instance});
		GameRegistry.addRecipe(new ItemStack(ItemIncinerationCannon.instance, 1), new Object[]{"  X","YYX", " ZY", 'X', itemRedPlasmaAmmo, 'Y', RedPlasmaBlock.instance, 'Z', RedPlasmaIngot.instance});
		GameRegistry.addRecipe(new ItemStack(tankHarvester, 1), new Object[]{"XXX","XYX", "XXX", 'X', HaloIngot, 'Y', ItemScorpion.instance});
		GameRegistry.addRecipe(new ItemStack(SpartanHelmet, 1), new Object[]{"XXX","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanChestplate, 1), new Object[]{"X X","XXX", "XXX", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanLeggings, 1), new Object[]{"XXX","X X","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(SpartanBoots, 1), new Object[]{"X X","X X", 'X', HaloIngot});
		GameRegistry.addRecipe(new ItemStack(CovenantHelmet, 1), new Object[]{"XXX","X X", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(CovenantChestplate, 1), new Object[]{"X X","XXX", "XXX", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(CovenantLeggings, 1), new Object[]{"XXX","X X","X X", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(CovenantBoots, 1), new Object[]{"X X","X X", 'X', covenantPiece});
		GameRegistry.addRecipe(new ItemStack(ammoRocket, 5), new Object[]{" X "," X ", " YZ", 'X', new ItemStack(HaloBlock.instance), 'Y', gunpowderStack, 'Z', new ItemStack(Items.string)});
		GameRegistry.addRecipe(new ItemStack(ammoPlasmaRocket, 5), new Object[]{" X "," X ", " YZ", 'X', GreenPlasmaIngot.instance, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string)});
		GameRegistry.addRecipe(new ItemStack(itemRedPlasmaAmmo, 1), new Object[]{" X "," X ", " YZ", 'X', RedPlasmaIngot.instance, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string)});
		ItemStack coalStack = new ItemStack(Items.coal);
		GameRegistry.addRecipe(new ItemStack(ItemMongoose.instance, 1), new Object[]{"X  ","YYY", "ZYZ", 'X', HaloIngot, 'Y', HaloBlock.instance, 'Z', itemWheel});
		//Health Pack Crafting Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHealthPack.instance, 1), new ItemStack(Items.nether_wart, 1), new ItemStack(Items.speckled_melon, 1), new ItemStack(Blocks.wool, 1));
		//Active Camo Armor	
		GameRegistry.addShapelessRecipe(new ItemStack(ActiveCamoChestplate, 1), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.fermented_spider_eye, 1), new ItemStack(Items.nether_wart, 1), SpartanChestplate);
		//Red Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanHelmet, 1), new ItemStack(Items.dye, 1, 1), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanChestplate, 1), new ItemStack(Items.dye, 1, 1), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanLeggings, 1), new ItemStack(Items.dye, 1, 1), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(RedSpartanBoots, 1), new ItemStack(Items.dye, 1, 1), SpartanBoots);
		//Green Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanHelmet, 1), new ItemStack(Items.dye, 1, 10), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanChestplate, 1), new ItemStack(Items.dye, 1, 10), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanLeggings, 1), new ItemStack(Items.dye, 1, 10), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(GreenSpartanBoots, 1), new ItemStack(Items.dye, 1, 10), SpartanBoots);
		//Blue Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanHelmet, 1), new ItemStack(Items.dye, 1, 6), SpartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanChestplate, 1), new ItemStack(Items.dye, 1, 6), SpartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanLeggings, 1), new ItemStack(Items.dye, 1, 6), SpartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(BlueSpartanBoots, 1), new ItemStack(Items.dye, 1, 6), SpartanBoots);
		GameRegistry.addRecipe(new ItemStack(itemWheel, 1), new Object[]{"XXX", "XYX", "XXX", 'X', itemRubber, 'Y', Items.iron_ingot});
		ItemStack stickStack = new ItemStack(Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemEnergySword.instance, 1), new Object[]{" X "," X ", " Y ", 'X', PurplePlasmaIngot.instance, 'Y', stickStack});
		ItemStack gunStack = new ItemStack(Items.gunpowder);
		GameRegistry.addRecipe(new ItemStack(RocketLauncher.instance, 1), new Object[]{" XX", "YYY", " IZ", 'X', ammoRocket, 'Y', HaloIngot, 'Z', HaloBlock.instance, 'I', new ItemStack(Items.iron_ingot)});
		GameRegistry.addRecipe(new ItemStack(ItemFuelRodCannon.instance, 1), new Object[]{"XXZ", "XYZ", " XX", 'X', GreenPlasmaIngot.instance, 'Y', covenantPiece, 'Z', ammoPlasmaRocket});
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemAssaultRifle.instance, 1), new Object[]{"   ", "XXY", " ZX", 'X', HaloIngot, 'Y', gunStack, 'Z', ironStack});
		ItemStack goldStack = new ItemStack(Items.gold_ingot);
		ItemStack greenIngotStack = new ItemStack(GreenPlasmaIngot.instance);
		GameRegistry.addRecipe(new ItemStack(ammoAssaultRifle, 15), new Object[]{" X ", " X ", "XYX", 'X', goldStack, 'Y', gunStack});
		GameRegistry.addRecipe(new ItemStack(ItemCarbineAmmo.instance, 15), new Object[]{" X ", " X ", "XYX", 'X', greenIngotStack, 'Y', gunStack});
		GameRegistry.addRecipe(new ItemStack(ItemNeedlerAmmo.instance, 15), new Object[]{" X ", " X ", "XYX", 'X', new ItemStack(PurplePlasmaIngot.instance), 'Y', gunStack});
		GameRegistry.addRecipe(new ItemStack(ItemCarbineRifle.instance, 1), new Object[]{"XZ ", "PGG", " CG", 'X', covenantPiece, 'C', new ItemStack(ItemCarbineAmmo.instance), 'Z', new ItemStack(RedPlasmaIngot.instance), 'P', new ItemStack(PurplePlasmaIngot.instance), 'G', new ItemStack(GreenPlasmaIngot.instance)});
		GameRegistry.addRecipe(new ItemStack(ItemNeedler.instance, 1), new Object[]{"XXX", "YYY", "  Y", 'X', ItemNeedlerAmmo.instance, 'Y', PurplePlasmaIngot.instance});
		GameRegistry.addRecipe(new ItemStack(PlasmaRifle.instance, 1), new Object[]{"YY ", " XY", "YY ", 'X', ammoPlasma, 'Y', RedPlasmaIngot.instance});
		GameRegistry.addSmelting(HaloOre, new ItemStack(HaloIngot, 1), 0.1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.dirt), new ItemStack(itemOil, 1), 0.1f);
		GameRegistry.addSmelting(RedPlasmaOre, new ItemStack(RedPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(PurplePlasmaOre, new ItemStack(PurplePlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(GreenPlasmaIngot.instance, new ItemStack(ammoPlasma, 1), 0.1f);
		GameRegistry.addSmelting(GreenPlasmaOre, new ItemStack(GreenPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addShapelessRecipe(new ItemStack(covenantPiece, 1), new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.coal, 1));
		//Frag Grenade Crafting
		ItemStack tntStack = new ItemStack(Blocks.tnt);
		GameRegistry.addRecipe(new ItemStack(FragGrenade.instance, 1), new Object[]{" X ", "XYX", "XXX", 'X', ironStack, 'Y', tntStack});
		//World Gen
		GameRegistry.registerWorldGenerator(HaloOreGen, 1);
		
		if (event.getSide() == Side.CLIENT)
			proxy.preInit();
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		//Register Key
		proxy.registerKey();
		
		//Rendering
		proxy.registerRenders();
		
		//Register Packet
		HalocraftPacketHandler.INSTANCE.registerMessage(FireMessageHandler.class, FireMessage.class, 0, Side.SERVER);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println("HaloCraft 2.0 Started Successfully!");
		System.out.println("HaloCraft 2.0 is a MOD created by NEGAFINITY.");
	}
}

