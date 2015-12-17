package halocraft;

import halocraft.armor.ActiveCamoArmor;
import halocraft.armor.CovenantArmor;
import halocraft.armor.HaloArmor;
import halocraft.blocks.ForerunnerFloorBlock;
import halocraft.blocks.ForerunnerOre;
import halocraft.blocks.ForerunnerWallBlock;
import halocraft.blocks.HaloBlock;
import halocraft.blocks.HaloOre;
import halocraft.blocks.PurplePlasmaBlock;
import halocraft.blocks.RedPlasmaBlock;
import halocraft.blocks.RoofBlock;
import halocraft.creativetabs.HaloCreativeTab;
import halocraft.entities.EntityBlueElite;
import halocraft.entities.EntityBullet;
import halocraft.entities.EntityElite;
import halocraft.entities.EntityFragGrenade;
import halocraft.entities.EntityGhost;
import halocraft.entities.EntityGreenPlasma;
import halocraft.entities.EntityGrunt;
import halocraft.entities.EntityMarine;
import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityOrangePlasma;
import halocraft.entities.EntityPlasmaRocket;
import halocraft.entities.EntityPromethean;
import halocraft.entities.EntityPulseGrenade;
import halocraft.entities.EntityPurplePlasma;
import halocraft.entities.EntityRedElite;
import halocraft.entities.EntityRedPlasma;
import halocraft.entities.EntityRocket;
import halocraft.entities.EntityScorpion;
import halocraft.entities.EntityWarthog;
import halocraft.entities.EntityWarthogTurret;
import halocraft.items.CovenantPiece;
import halocraft.items.FragGrenade;
import halocraft.items.GreenPlasmaIngot;
import halocraft.items.ItemAmmoAssaultRifle;
import halocraft.items.ItemAmmoPlasma;
import halocraft.items.ItemAmmoPlasmaRocket;
import halocraft.items.ItemCarbineAmmo;
import halocraft.items.ItemEnergySword;
import halocraft.items.ItemForerunnerShard;
import halocraft.items.ItemGhost;
import halocraft.items.ItemHealthPack;
import halocraft.items.ItemMongoose;
import halocraft.items.ItemNeedlerAmmo;
import halocraft.items.ItemOil;
import halocraft.items.ItemRedPlasmaAmmo;
import halocraft.items.ItemRocket;
import halocraft.items.ItemRubber;
import halocraft.items.ItemScorpion;
import halocraft.items.ItemWarthog;
import halocraft.items.ItemWarthogTurret;
import halocraft.items.ItemWheel;
import halocraft.items.PrometheanSword;
import halocraft.items.PulseGrenade;
import halocraft.items.PurplePlasmaIngot;
import halocraft.items.RedPlasmaIngot;
import halocraft.items.SpartaniumIngot;
import halocraft.items.TankHarvester;
import halocraft.items.firearms.ItemAssaultRifle;
import halocraft.items.firearms.ItemBattleRifle;
import halocraft.items.firearms.ItemBoltshot;
import halocraft.items.firearms.ItemCarbineRifle;
import halocraft.items.firearms.ItemFuelRodCannon;
import halocraft.items.firearms.ItemIncinerationCannon;
import halocraft.items.firearms.ItemLightRifle;
import halocraft.items.firearms.ItemNeedler;
import halocraft.items.firearms.ItemRocketLauncher;
import halocraft.items.firearms.ItemScattershot;
import halocraft.items.firearms.ItemSniperRifle;
import halocraft.items.firearms.ItemSuppressor;
import halocraft.items.firearms.Pistol;
import halocraft.items.firearms.PlasmaRifle;
import halocraft.packets.FireMessage;
import halocraft.packets.FireMessageHandler;
import halocraft.packets.HalocraftPacketHandler;
import halocraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "halocraft", version = "1.5")
public class HaloCraft
{
	public int counter = 0;

	@SidedProxy(clientSide = "halocraft.proxies.ClientProxy", serverSide = "halocraft.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static String MODID = "halocraft";
	public static String VERSION = "1.5";

	// World Generation
	public static HaloGenerationClass HaloOreGen;

	// Blocks
	public final static Block haloOre = new HaloOre(Material.iron);
	public final static Block forerunnerOre = new ForerunnerOre(Material.iron);
	public final static Block redPlasmaOre = new halocraft.blocks.RedPlasmaOre(Material.iron);
	public final static Block greenPlasmaOre = new halocraft.blocks.GreenPlasmaOre(Material.iron);
	public final static Block purplePlasmaOre = new halocraft.blocks.PurplePlasmaOre(Material.iron);
	// Armor
	public static int helmetID = 0;
	public static int chestplateID = 0;
	public static int leggingID = 0;
	public static int bootID = 0;

	public static Item spartanHelmet;
	public static Item spartanChestplate;
	public static Item spartanLeggings;
	public static Item spartanBoots;

	public static Item prometheanHelmet;
	public static Item prometheanChestplate;
	public static Item prometheanLeggings;
	public static Item prometheanBoots;

	public static Item spartanLockeHelmet;
	public static Item spartanLockeChestplate;
	public static Item spartanLockeLeggings;
	public static Item spartanLockeBoots;

	public static Item greenGrenadierHelmet;
	public static Item greenGrenadierChestplate;
	public static Item greenGrenadierLeggings;
	public static Item greenGrenadierBoots;
	
	public static Item orangeGrenadierHelmet;
	public static Item orangeGrenadierChestplate;
	public static Item orangeGrenadierLeggings;
	public static Item orangeGrenadierBoots;
	
	public static Item reconHelmet;
	public static Item reconChestplate;
	public static Item reconLeggings;
	public static Item reconBoots;
	
	public static Item blueReconHelmet;
	public static Item blueReconChestplate;
	public static Item blueReconLeggings;
	public static Item blueReconBoots;
	
	public static Item redReconHelmet;
	public static Item redReconChestplate;
	public static Item redReconLeggings;
	public static Item redReconBoots;

	public static Item marineHelmet;
	public static Item marineChestplate;
	public static Item marineLeggings;
	public static Item marineBoots;
	public static Item blueMarineHelmet;
	public static Item blueMarineChestplate;
	public static Item blueMarineLeggings;
	public static Item blueMarineBoots;
	public static Item redMarineHelmet;
	public static Item redMarineChestplate;
	public static Item redMarineLeggings;
	public static Item redMarineBoots;

	public static Item redSpartanHelmet;
	public static Item redSpartanChestplate;
	public static Item redSpartanLeggings;
	public static Item redSpartanBoots;
	public static Item greenSpartanHelmet;
	public static Item greenSpartanChestplate;
	public static Item greenSpartanLeggings;
	public static Item greenSpartanBoots;
	public static Item blueSpartanHelmet;
	public static Item blueSpartanChestplate;
	public static Item blueSpartanLeggings;
	public static Item blueSpartanBoots;

	public static Item covenantHelmet;
	public static Item covenantChestplate;
	public static Item covenantLeggings;
	public static Item covenantBoots;
	public static Item covenantPiece;

	public static Item activeCamoChestplate;

	public static Item jetpack;

	// Creative Tabs
	public static CreativeTabs haloCreativeTab;

	// Items
	public static Item spartaniumIngot;
	public static Item ammoRocket;
	public static Item ammoAssaultRifle;
	public static Item ammoPlasma;
	public static Item itemWheel;
	public static Item itemOil;
	public static Item ammoPlasmaRocket;
	public static Item tankHarvester;
	public static Item itemRubber;

	// Tool Materials
	public static ToolMaterial haloMaterial;
	public static ToolMaterial prometheanMaterial;

	// Armor Material
	public static ArmorMaterial haloArmor;
	public static ArmorMaterial covenantArmor;
	public static ArmorMaterial activeCamoArmor;
	public static ArmorMaterial prometheanArmor;
	public static ArmorMaterial marineArmor;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLLog.getLogger().info("[HaloCraft 2.0]: Starting to load...");

		haloCreativeTab = new HaloCreativeTab(CreativeTabs.getNextID(), "haloCreativeTab");
		spartaniumIngot = new SpartaniumIngot();
		itemOil = new ItemOil();
		itemWheel = new ItemWheel();
		itemRubber = new ItemRubber();
		ammoPlasmaRocket = new ItemAmmoPlasmaRocket();
		tankHarvester = new TankHarvester();
		ammoPlasma = new ItemAmmoPlasma();
		haloMaterial = EnumHelper.addToolMaterial("HaloMaterial", 3, 1750, 9.0F, 6.0F, 10);
		prometheanMaterial = EnumHelper.addToolMaterial("PrometheanMaterial", 3, 1750, 9.0F, 8.0F, 10);
		prometheanArmor = EnumHelper.addArmorMaterial("PrometheanArmor", "halocraft:textures/models/armor/PrometheanArmor", 100, new int[] { 6, 9, 7, 5 }, 30);
		haloArmor = EnumHelper.addArmorMaterial("HaloArmor", "halocraft:textures/models/armor/HaloArmor", 75, new int[] { 5, 7, 7, 5 }, 30);
		covenantArmor = EnumHelper.addArmorMaterial("CovenantArmor", "halocraft:textures/models/armor/CovenantArmor", 50, new int[] { 5, 6, 6, 5 }, 30);
		marineArmor = EnumHelper.addArmorMaterial("MarineArmor", "halocraft:textures/models/armor/MarineArmor", 50, new int[] { 5, 6, 6, 5 }, 30);
		activeCamoArmor = EnumHelper.addArmorMaterial("ActiveCamoArmor", "halocraft:textures/models/armor/ActiveCamoArmor", 100, new int[] { 6, 6, 10, 8 }, 30);
		HaloOreGen = new HaloGenerationClass();
		covenantPiece = new CovenantPiece();
		ammoRocket = new ItemRocket();
		ammoAssaultRifle = new ItemAmmoAssaultRifle();

		// Promethean Armor
		prometheanHelmet = new halocraft.armor.PrometheanArmor(prometheanArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("prometheanHelmet");
		prometheanChestplate = new halocraft.armor.PrometheanArmor(prometheanArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("PrometheanChestplate");
		prometheanLeggings = new halocraft.armor.PrometheanArmor(prometheanArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("PrometheanLeggings");
		prometheanBoots = new halocraft.armor.PrometheanArmor(prometheanArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("PrometheanBoots");

		// Spartan Locke Armor
		spartanLockeHelmet = new halocraft.armor.SpartanLockeArmor(haloArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("SpartanLockeHelmet");
		spartanLockeChestplate = new halocraft.armor.SpartanLockeArmor(haloArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("SpartanLockeChestplate");
		spartanLockeLeggings = new halocraft.armor.SpartanLockeArmor(haloArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("SpartanLockeLeggings");
		spartanLockeBoots = new halocraft.armor.SpartanLockeArmor(haloArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("SpartanLockeBoots");

		//Grenadier Armor
		greenGrenadierHelmet = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("GreenGrenadierHelmet");
		greenGrenadierChestplate = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("GreenGrenadierChestplate");
		greenGrenadierLeggings = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("GreenGrenadierLeggings");
		greenGrenadierBoots = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("GreenGrenadierBoots");
		
		orangeGrenadierHelmet = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("OrangeGrenadierHelmet");
		orangeGrenadierChestplate = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("OrangeGrenadierChestplate");
		orangeGrenadierLeggings = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("OrangeGrenadierLeggings");
		orangeGrenadierBoots = new halocraft.armor.GrenadierArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("OrangeGrenadierBoots");
		
		// Recon Armor
		reconHelmet = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("GreenGrenadierHelmet");
		reconChestplate = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("GreenGrenadierChestplate");
		reconLeggings = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("GreenGrenadierLeggings");
		reconBoots = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("GreenGrenadierBoots");
		
		blueReconHelmet = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("BlueReconHelmet");
		blueReconChestplate = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("BlueReconChestplate");
		blueReconLeggings = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("BlueReconLeggings");
		blueReconBoots = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("BlueReconBoots");
		
		redReconHelmet = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("RedReconHelmet");
		redReconChestplate = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("RedReconChestplate");
		redReconLeggings = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("RedReconLeggings");
		redReconBoots = new halocraft.armor.ReconArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("RedReconBoots");

		// Marine Armor
		marineHelmet = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("MarineHelmet");
		marineChestplate = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("MarineChestplate");
		marineLeggings = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("MarineLeggings");
		marineBoots = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("MarineBoots");

		redMarineHelmet = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("RedMarineHelmet");
		redMarineChestplate = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("RedMarineChestplate");
		redMarineLeggings = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("RedMarineLeggings");
		redMarineBoots = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("RedMarineBoots");

		blueMarineHelmet = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("BlueMarineHelmet");
		blueMarineChestplate = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("BlueMarineChestplate");
		blueMarineLeggings = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("BlueMarineLeggings");
		blueMarineBoots = new halocraft.armor.MarineArmor(marineArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("BlueMarineBoots");

		jetpack = new HaloArmor(haloArmor, chestplateID, 1).setUnlocalizedName("Jetpack");

		halocraft.HaloCraft.blueSpartanHelmet = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("BlueSpartanHelmet");
		halocraft.HaloCraft.blueSpartanChestplate = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("BlueSpartanChestplate");
		halocraft.HaloCraft.blueSpartanLeggings = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("BlueSpartanLeggings");
		halocraft.HaloCraft.blueSpartanBoots = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("BlueSpartanBoots");
		halocraft.HaloCraft.greenSpartanHelmet = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("GreenSpartanHelmet");
		halocraft.HaloCraft.greenSpartanChestplate = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("GreenSpartanChestplate");
		halocraft.HaloCraft.greenSpartanLeggings = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("GreenSpartanLeggings");
		halocraft.HaloCraft.greenSpartanBoots = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("GreenSpartanBoots");
		halocraft.HaloCraft.redSpartanHelmet = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("RedSpartanHelmet");
		halocraft.HaloCraft.redSpartanChestplate = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("RedSpartanChestplate");
		halocraft.HaloCraft.redSpartanLeggings = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("RedSpartanLeggings");
		halocraft.HaloCraft.redSpartanBoots = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("RedSpartanBoots");
		halocraft.HaloCraft.spartanHelmet = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("SpartanHelmet");
		halocraft.HaloCraft.spartanChestplate = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("SpartanChestplate");
		halocraft.HaloCraft.spartanLeggings = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("SpartanLeggings");
		halocraft.HaloCraft.spartanBoots = new HaloArmor(halocraft.HaloCraft.haloArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("SpartanBoots");
		halocraft.HaloCraft.covenantHelmet = new CovenantArmor(halocraft.HaloCraft.covenantArmor, halocraft.HaloCraft.helmetID, 0).setUnlocalizedName("CovenantHelmet");
		halocraft.HaloCraft.covenantChestplate = new CovenantArmor(halocraft.HaloCraft.covenantArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("CovenantChestplate");
		halocraft.HaloCraft.covenantLeggings = new CovenantArmor(halocraft.HaloCraft.covenantArmor, halocraft.HaloCraft.leggingID, 2).setUnlocalizedName("CovenantLeggings");
		halocraft.HaloCraft.covenantBoots = new CovenantArmor(halocraft.HaloCraft.covenantArmor, halocraft.HaloCraft.bootID, 3).setUnlocalizedName("CovenantBoots");
		halocraft.HaloCraft.activeCamoChestplate = new ActiveCamoArmor(halocraft.HaloCraft.activeCamoArmor, halocraft.HaloCraft.chestplateID, 1).setUnlocalizedName("ActiveCamoChestplate");

		// Register Entities
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityMongoose.class, "Mongoose", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityScorpion.class, "Socrpion", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityPlasmaRocket.class, "PlasmaRocket", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityGhost.class, "Ghost", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityPurplePlasma.class, "PurplePlasma", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityWarthogTurret.class, "WarthogTurret", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityRocket.class, "Rocket", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityRedPlasma.class, "RedPlasma", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityGreenPlasma.class, "GreenPlasma", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityWarthog.class, "Warthog", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityFragGrenade.class, "fragGrenade", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityPulseGrenade.class, "pulseGrenade", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerModEntity(EntityOrangePlasma.class, "OrangePlasma", getRandomID(), this, 250, 15, true);

		EntityRegistry.registerModEntity(EntityElite.class, "GoldenElite", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerEgg(EntityElite.class, 0xFFEE00, 0xFFFFFF);
		EntityRegistry.addSpawn(EntityElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityRedElite.class, "RedElite", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerEgg(EntityRedElite.class, 0xFF0000, 0x000000);
		EntityRegistry.addSpawn(EntityRedElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityBlueElite.class, "BlueElite", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerEgg(EntityBlueElite.class, 0x002FFF, 0xCC00FF);
		EntityRegistry.addSpawn(EntityBlueElite.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityGrunt.class, "Grunt", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerEgg(EntityGrunt.class, 0x4F2E00, 0x424242);
		EntityRegistry.addSpawn(EntityGrunt.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityPromethean.class, "Promethean", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerEgg(EntityPromethean.class, 0x000000, 0xFF7700);
		EntityRegistry.addSpawn(EntityPromethean.class, 15, 4, 10, EnumCreatureType.MONSTER, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		EntityRegistry.registerModEntity(EntityMarine.class, "Marine", getRandomID(), this, 250, 15, true);
		EntityRegistry.registerEgg(EntityMarine.class, 0x000000, 0x47BEE6);
		EntityRegistry.addSpawn(EntityMarine.class, 15, 4, 10, EnumCreatureType.CREATURE, BiomeGenBase.taigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.desertHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHillsPlus, BiomeGenBase.birchForest, BiomeGenBase.savanna, BiomeGenBase.mesa, BiomeGenBase.roofedForest, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.mesaPlateau);

		// Register Items and Blocks
		GameRegistry.registerItem(ItemScattershot.instance, ItemScattershot.name);
		GameRegistry.registerItem(ItemEnergySword.instance, ItemEnergySword.name);
		GameRegistry.registerItem(PrometheanSword.instance, PrometheanSword.name);
		GameRegistry.registerBlock(haloOre, "HaloOre");
		GameRegistry.registerBlock(RedPlasmaBlock.instance, RedPlasmaBlock.name);
		GameRegistry.registerBlock(PurplePlasmaBlock.instance, PurplePlasmaBlock.name);
		GameRegistry.registerBlock(forerunnerOre, "ForerunnerOre");
		GameRegistry.registerItem(itemWheel, "itemWheel");
		GameRegistry.registerItem(itemOil, "itemOil");
		GameRegistry.registerBlock(redPlasmaOre, "RedPlasmaOre");
		GameRegistry.registerBlock(greenPlasmaOre, "GreenPlasmaOre");
		GameRegistry.registerBlock(purplePlasmaOre, "PurplePlasmaOre");
		GameRegistry.registerBlock(HaloBlock.instance, HaloBlock.name);
		GameRegistry.registerItem(ItemMongoose.instance, ItemMongoose.name);
		GameRegistry.registerItem(ItemWarthogTurret.instance, ItemWarthogTurret.name);
		GameRegistry.registerItem(covenantPiece, "covenantPiece");
		GameRegistry.registerItem(FragGrenade.instance, FragGrenade.name);
		GameRegistry.registerItem(spartaniumIngot, "SpartaniumIngot");
		GameRegistry.registerItem(ItemRocketLauncher.instance, ItemRocketLauncher.name);
		GameRegistry.registerItem(ammoRocket, "ammoRocket");
		GameRegistry.registerItem(jetpack, "Jetpack");
		GameRegistry.registerItem(ammoAssaultRifle, "ammoAssaultRifle");
		GameRegistry.registerItem(ItemSuppressor.instance, ItemSuppressor.name);
		GameRegistry.registerItem(ItemForerunnerShard.instance, ItemForerunnerShard.name);
		GameRegistry.registerItem(ItemAssaultRifle.instance, ItemAssaultRifle.name);
		GameRegistry.registerItem(ItemBattleRifle.instance, ItemBattleRifle.name);
		GameRegistry.registerItem(ItemHealthPack.instance, ItemHealthPack.name);
		GameRegistry.registerItem(ItemRedPlasmaAmmo.instance, ItemRedPlasmaAmmo.name);
		GameRegistry.registerItem(ItemGhost.instance, ItemGhost.name);
		GameRegistry.registerItem(ammoPlasmaRocket, "ammoPlasmaRocket");
		GameRegistry.registerItem(itemRubber, "itemRubber");
		GameRegistry.registerItem(ItemLightRifle.instance, ItemLightRifle.name);
		GameRegistry.registerItem(ItemScorpion.instance, ItemScorpion.name);
		GameRegistry.registerItem(ItemIncinerationCannon.instance, ItemIncinerationCannon.name);
		GameRegistry.registerItem(ammoPlasma, "ammoPlasma");
		GameRegistry.registerItem(PulseGrenade.instance, PulseGrenade.name);
		GameRegistry.registerItem(Pistol.instance, Pistol.name);
		GameRegistry.registerItem(ItemNeedlerAmmo.instance, ItemNeedlerAmmo.name);
		GameRegistry.registerItem(RedPlasmaIngot.instance, RedPlasmaIngot.name);
		GameRegistry.registerItem(ItemSniperRifle.instance, ItemSniperRifle.name);
		GameRegistry.registerItem(tankHarvester, "TankHarvester");
		GameRegistry.registerItem(ItemCarbineRifle.instance, ItemCarbineRifle.name);
		GameRegistry.registerItem(ItemNeedler.instance, ItemNeedler.name);
		GameRegistry.registerItem(ItemWarthog.instance, ItemWarthog.name);
		GameRegistry.registerItem(GreenPlasmaIngot.instance, GreenPlasmaIngot.name);
		GameRegistry.registerItem(prometheanHelmet, "prometheanHelmet");
		GameRegistry.registerItem(prometheanChestplate, "PrometheanChestplate");
		GameRegistry.registerItem(prometheanLeggings, "PrometheanLeggings");
		GameRegistry.registerItem(prometheanBoots, "PrometheanBoots");
		GameRegistry.registerItem(spartanLockeHelmet, "SpartanLockeHelmet");
		GameRegistry.registerItem(spartanLockeChestplate, "SpartanLockeChestplate");
		GameRegistry.registerItem(spartanLockeLeggings, "SpartanLockeLeggings");
		GameRegistry.registerItem(spartanLockeBoots, "SpartanLockeBoots");
		GameRegistry.registerItem(greenGrenadierHelmet, "GreenGrenadierHelmet");
		GameRegistry.registerItem(greenGrenadierChestplate, "GreenGrenadierChestplate");
		GameRegistry.registerItem(greenGrenadierLeggings, "GreenGrenadierLeggings");
		GameRegistry.registerItem(greenGrenadierBoots, "GreenGrenadierBoots");
		GameRegistry.registerItem(orangeGrenadierHelmet, "OrangeGrenadierHelmet");
		GameRegistry.registerItem(orangeGrenadierChestplate, "OrangeGrenadierChestplate");
		GameRegistry.registerItem(orangeGrenadierLeggings, "OrangeGrenadierLeggings");
		GameRegistry.registerItem(orangeGrenadierBoots, "OrangeGrenadierBoots");
		GameRegistry.registerItem(reconHelmet, "ReconHelmet");
		GameRegistry.registerItem(reconChestplate, "ReconChestplate");
		GameRegistry.registerItem(reconLeggings, "ReconLeggings");
		GameRegistry.registerItem(reconBoots, "ReconBoots");
		GameRegistry.registerItem(blueReconHelmet, "BlueReconHelmet");
		GameRegistry.registerItem(blueReconChestplate, "BlueReconChestplate");
		GameRegistry.registerItem(blueReconLeggings, "BlueReconLeggings");
		GameRegistry.registerItem(blueReconBoots, "BlueReconBoots");
		GameRegistry.registerItem(redReconHelmet, "RedReconHelmet");
		GameRegistry.registerItem(redReconChestplate, "RedReconChestplate");
		GameRegistry.registerItem(redReconLeggings, "RedReconLeggings");
		GameRegistry.registerItem(redReconBoots, "RedReconBoots");
		GameRegistry.registerItem(marineHelmet, "MarineHelmet");
		GameRegistry.registerItem(marineChestplate, "MarineChestplate");
		GameRegistry.registerItem(marineLeggings, "MarineLeggings");
		GameRegistry.registerItem(marineBoots, "MarineBoots");
		GameRegistry.registerItem(redMarineHelmet, "RedMarineHelmet");
		GameRegistry.registerItem(redMarineChestplate, "RedMarineChestplate");
		GameRegistry.registerItem(redMarineLeggings, "RedMarineLeggings");
		GameRegistry.registerItem(redMarineBoots, "RedMarineBoots");
		GameRegistry.registerItem(blueMarineHelmet, "BlueMarineHelmet");
		GameRegistry.registerItem(blueMarineChestplate, "BlueMarineChestplate");
		GameRegistry.registerItem(blueMarineLeggings, "BlueMarineLeggings");
		GameRegistry.registerItem(blueMarineBoots, "BlueMarineBoots");
		GameRegistry.registerItem(halocraft.HaloCraft.spartanHelmet, "SpartanHelmet");
		GameRegistry.registerItem(halocraft.HaloCraft.spartanChestplate, "SpartanChestplate");
		GameRegistry.registerItem(halocraft.HaloCraft.spartanLeggings, "SpartanLeggings");
		GameRegistry.registerItem(halocraft.HaloCraft.spartanBoots, "SpartanBoots");
		GameRegistry.registerItem(halocraft.HaloCraft.redSpartanHelmet, "RedSpartanHelmet");
		GameRegistry.registerItem(halocraft.HaloCraft.redSpartanChestplate, "RedSpartanChestplate");
		GameRegistry.registerItem(halocraft.HaloCraft.redSpartanLeggings, "RedSpartanLeggings");
		GameRegistry.registerItem(halocraft.HaloCraft.redSpartanBoots, "RedSpartanBoots");
		GameRegistry.registerItem(halocraft.HaloCraft.greenSpartanHelmet, "GreenSpartanHelmet");
		GameRegistry.registerItem(halocraft.HaloCraft.greenSpartanChestplate, "GreenSpartanChestplate");
		GameRegistry.registerItem(halocraft.HaloCraft.greenSpartanLeggings, "GreenSpartanLeggings");
		GameRegistry.registerItem(halocraft.HaloCraft.greenSpartanBoots, "GreenSpartanBoots");
		GameRegistry.registerItem(halocraft.HaloCraft.blueSpartanHelmet, "BlueSpartanHelmet");
		GameRegistry.registerItem(halocraft.HaloCraft.blueSpartanChestplate, "BlueSpartanChestplate");
		GameRegistry.registerItem(halocraft.HaloCraft.blueSpartanLeggings, "BlueSpartanLeggings");
		GameRegistry.registerItem(halocraft.HaloCraft.blueSpartanBoots, "BlueSpartanBoots");
		GameRegistry.registerItem(PurplePlasmaIngot.instance, PurplePlasmaIngot.name);
		GameRegistry.registerItem(halocraft.HaloCraft.covenantHelmet, "CovenantHelmet");
		GameRegistry.registerItem(halocraft.HaloCraft.covenantChestplate, "CovenantChestplate");
		GameRegistry.registerItem(halocraft.HaloCraft.covenantLeggings, "CovenantLeggings");
		GameRegistry.registerItem(halocraft.HaloCraft.covenantBoots, "CovenantBoots");
		GameRegistry.registerItem(halocraft.HaloCraft.activeCamoChestplate, "ActiveCamoChestplate");
		GameRegistry.registerItem(ItemFuelRodCannon.instance, ItemFuelRodCannon.name);
		GameRegistry.registerItem(PlasmaRifle.instance, PlasmaRifle.name);
		GameRegistry.registerItem(ItemCarbineAmmo.instance, ItemCarbineAmmo.name);
		GameRegistry.registerBlock(RoofBlock.instance, RoofBlock.name);
		GameRegistry.registerBlock(ForerunnerWallBlock.instance, ForerunnerWallBlock.name);
		GameRegistry.registerBlock(ForerunnerFloorBlock.instance, ForerunnerFloorBlock.name);
		GameRegistry.registerItem(ItemBoltshot.instance, ItemBoltshot.name);
		// Block Recipes
		GameRegistry.addRecipe(new ItemStack(HaloBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(PurplePlasmaBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', PurplePlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(RedPlasmaBlock.instance, 1), new Object[] { "XXX", "XXX", "XXX", 'X', RedPlasmaIngot.instance });

		GameRegistry.addRecipe(new ItemStack(itemRubber, 2), new Object[] { "XXX", "XXX", "XXX", 'X', itemOil });

		// Gun Recipes
		ItemStack gunpowderStack = new ItemStack(Items.gunpowder);
		ItemStack glassPaneStack = new ItemStack(Blocks.glass_pane);
		ItemStack redGlassPaneStack = new ItemStack(Blocks.stained_glass_pane, 1, 14);
		GameRegistry.addRecipe(new ItemStack(ItemBattleRifle.instance, 1), new Object[] { "ZA ", "XXY", " AX", 'X', spartaniumIngot, 'Y', gunpowderStack, 'Z', glassPaneStack, 'A', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemLightRifle.instance, 1), new Object[] { "ZX ", "YXX", " XX", 'X', RedPlasmaIngot.instance, 'Y', ItemRedPlasmaAmmo.instance, 'Z', redGlassPaneStack });
		GameRegistry.addRecipe(new ItemStack(Pistol.instance, 1), new Object[] { "   ", " XY", "  Z", 'X', spartaniumIngot, 'Y', gunpowderStack, 'Z', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemSniperRifle.instance, 1), new Object[] { "XYX", "ZYY", " IY", 'X', glassPaneStack, 'Y', spartaniumIngot, 'Z', gunpowderStack, 'I', new ItemStack(Items.iron_ingot) });
		// Recipes
		GameRegistry.addRecipe(new ItemStack(ItemWarthogTurret.instance, 1), new Object[] { "  Z", "XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel, 'Z', ItemAssaultRifle.instance });
		GameRegistry.addRecipe(new ItemStack(ItemWarthog.instance, 1), new Object[] { "   ", "XXX", "YXY", 'X', HaloBlock.instance, 'Y', itemWheel });
		GameRegistry.addRecipe(new ItemStack(ItemScorpion.instance, 1), new Object[] { "YXX", "XXX", "XXX", 'X', HaloBlock.instance, 'Y', ItemRocketLauncher.instance });
		GameRegistry.addRecipe(new ItemStack(ItemGhost.instance, 1), new Object[] { "   ", "XY ", "YYY", 'X', PlasmaRifle.instance, 'Y', PurplePlasmaBlock.instance });
		GameRegistry.addRecipe(new ItemStack(ItemIncinerationCannon.instance, 1), new Object[] { "  X", "YYX", " ZY", 'X', ItemRedPlasmaAmmo.instance, 'Y', RedPlasmaBlock.instance, 'Z', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(tankHarvester, 1), new Object[] { "XXX", "XYX", "XXX", 'X', spartaniumIngot, 'Y', ItemScorpion.instance });

		// Pulse Grenade
		GameRegistry.addRecipe(new ItemStack(PulseGrenade.instance, 1), new Object[] { " X ", "XYX", " X ", 'X', RedPlasmaIngot.instance, 'Y', Blocks.tnt });

		// Spartan Armor
		GameRegistry.addRecipe(new ItemStack(spartanHelmet, 1), new Object[] { "XXX", "X X", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(spartanChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(spartanLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', spartaniumIngot });
		GameRegistry.addRecipe(new ItemStack(spartanBoots, 1), new Object[] { "X X", "X X", 'X', spartaniumIngot });

		// Promethean Armor
		GameRegistry.addRecipe(new ItemStack(prometheanHelmet, 1), new Object[] { "XXX", "X X", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(prometheanChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(prometheanLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', RedPlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(prometheanBoots, 1), new Object[] { "X X", "X X", 'X', RedPlasmaIngot.instance });

		// Marine Armor
		GameRegistry.addRecipe(new ItemStack(marineHelmet, 1), new Object[] { "XXX", "Y Y", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(marineChestplate, 1), new Object[] { "Y Y", "XXX", "XXX", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(marineLeggings, 1), new Object[] { "YYY", "X X", "X X", 'X', spartaniumIngot, 'Y', Items.leather });
		GameRegistry.addRecipe(new ItemStack(marineBoots, 1), new Object[] { "Y Y", "X X", 'X', spartaniumIngot, 'Y', Items.leather });

		GameRegistry.addRecipe(new ItemStack(covenantHelmet, 1), new Object[] { "XXX", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(covenantChestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(covenantLeggings, 1), new Object[] { "XXX", "X X", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(covenantBoots, 1), new Object[] { "X X", "X X", 'X', covenantPiece });
		GameRegistry.addRecipe(new ItemStack(ammoRocket, 5), new Object[] { " X ", " X ", " YZ", 'X', spartaniumIngot, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ammoPlasmaRocket, 5), new Object[] { " X ", " X ", " YZ", 'X', GreenPlasmaIngot.instance, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ItemRedPlasmaAmmo.instance, 1), new Object[] { " X ", " X ", " YZ", 'X', RedPlasmaIngot.instance, 'Y', gunpowderStack, 'Z', new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ItemMongoose.instance, 1), new Object[] { "X  ", "YYY", "ZYZ", 'X', spartaniumIngot, 'Y', HaloBlock.instance, 'Z', itemWheel });

		// Health Pack Crafting Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHealthPack.instance, 1), new ItemStack(Items.nether_wart, 1), new ItemStack(Items.speckled_melon, 1), new ItemStack(Blocks.wool, 1));

		// Active Camo Armor
		GameRegistry.addShapelessRecipe(new ItemStack(activeCamoChestplate, 1), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.fermented_spider_eye, 1), new ItemStack(Items.nether_wart, 1), spartanChestplate);

		// Forerunner Blocks
		GameRegistry.addRecipe(new ItemStack(ForerunnerFloorBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ItemForerunnerShard.instance) });
		GameRegistry.addRecipe(new ItemStack(ForerunnerWallBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ForerunnerFloorBlock.instance) });
		GameRegistry.addRecipe(new ItemStack(RoofBlock.instance, 1), new Object[] { "XX ", "XX ", 'X', new ItemStack(ForerunnerWallBlock.instance) });

		// Red Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanHelmet, 1), new ItemStack(Items.dye, 1, 1), spartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanChestplate, 1), new ItemStack(Items.dye, 1, 1), spartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanLeggings, 1), new ItemStack(Items.dye, 1, 1), spartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(redSpartanBoots, 1), new ItemStack(Items.dye, 1, 1), spartanBoots);

		// Red Marine Armor
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineHelmet, 1), new ItemStack(Items.dye, 1, 1), marineHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineChestplate, 1), new ItemStack(Items.dye, 1, 1), marineChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineLeggings, 1), new ItemStack(Items.dye, 1, 1), marineLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(redMarineBoots, 1), new ItemStack(Items.dye, 1, 1), marineBoots);

		// Blue Marine Armor
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineHelmet, 1), new ItemStack(Items.dye, 1, 6), marineHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineChestplate, 1), new ItemStack(Items.dye, 1, 6), marineChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineLeggings, 1), new ItemStack(Items.dye, 1, 6), marineLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(blueMarineBoots, 1), new ItemStack(Items.dye, 1, 6), marineBoots);

		// Green Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanHelmet, 1), new ItemStack(Items.dye, 1, 10), spartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanChestplate, 1), new ItemStack(Items.dye, 1, 10), spartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanLeggings, 1), new ItemStack(Items.dye, 1, 10), spartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(greenSpartanBoots, 1), new ItemStack(Items.dye, 1, 10), spartanBoots);

		// Blue Spartan Armor
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanHelmet, 1), new ItemStack(Items.dye, 1, 6), spartanHelmet);
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanChestplate, 1), new ItemStack(Items.dye, 1, 6), spartanChestplate);
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanLeggings, 1), new ItemStack(Items.dye, 1, 6), spartanLeggings);
		GameRegistry.addShapelessRecipe(new ItemStack(blueSpartanBoots, 1), new ItemStack(Items.dye, 1, 6), spartanBoots);

		GameRegistry.addRecipe(new ItemStack(itemWheel, 1), new Object[] { "XXX", "XYX", "XXX", 'X', itemRubber, 'Y', Items.iron_ingot });
		ItemStack stickStack = new ItemStack(Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemEnergySword.instance, 1), new Object[] { " X ", " X ", " Y ", 'X', PurplePlasmaIngot.instance, 'Y', stickStack });
		GameRegistry.addRecipe(new ItemStack(PrometheanSword.instance, 1), new Object[] { " X ", " X ", " Y ", 'X', RedPlasmaIngot.instance, 'Y', stickStack });
		ItemStack gunStack = new ItemStack(Items.gunpowder);
		GameRegistry.addRecipe(new ItemStack(ItemRocketLauncher.instance, 1), new Object[] { " XX", "YYY", " IZ", 'X', ammoRocket, 'Y', spartaniumIngot, 'Z', HaloBlock.instance, 'I', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ItemFuelRodCannon.instance, 1), new Object[] { "XXZ", "XYZ", " XX", 'X', GreenPlasmaIngot.instance, 'Y', covenantPiece, 'Z', ammoPlasmaRocket });
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemAssaultRifle.instance, 1), new Object[] { "   ", "XXY", " ZX", 'X', spartaniumIngot, 'Y', gunStack, 'Z', ironStack });
		ItemStack goldStack = new ItemStack(Items.gold_ingot);
		ItemStack greenIngotStack = new ItemStack(GreenPlasmaIngot.instance);
		GameRegistry.addRecipe(new ItemStack(ammoAssaultRifle, 15), new Object[] { " X ", " X ", "XYX", 'X', goldStack, 'Y', gunStack });
		GameRegistry.addRecipe(new ItemStack(ItemCarbineAmmo.instance, 15), new Object[] { " X ", " X ", "XYX", 'X', greenIngotStack, 'Y', gunStack });
		GameRegistry.addRecipe(new ItemStack(ItemNeedlerAmmo.instance, 15), new Object[] { " X ", " X ", "XYX", 'X', new ItemStack(PurplePlasmaIngot.instance), 'Y', gunStack });
		GameRegistry.addRecipe(new ItemStack(ItemCarbineRifle.instance, 1), new Object[] { "XZ ", "PGG", " CG", 'X', covenantPiece, 'C', new ItemStack(ItemCarbineAmmo.instance), 'Z', new ItemStack(RedPlasmaIngot.instance), 'P', new ItemStack(PurplePlasmaIngot.instance), 'G', new ItemStack(GreenPlasmaIngot.instance) });
		GameRegistry.addRecipe(new ItemStack(ItemNeedler.instance, 1), new Object[] { "XXX", "YYY", "  Y", 'X', ItemNeedlerAmmo.instance, 'Y', PurplePlasmaIngot.instance });
		GameRegistry.addRecipe(new ItemStack(PlasmaRifle.instance, 1), new Object[] { "YY ", " XY", "YY ", 'X', ammoPlasma, 'Y', RedPlasmaIngot.instance });
		GameRegistry.addSmelting(haloOre, new ItemStack(spartaniumIngot, 1), 0.1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.dirt), new ItemStack(itemOil, 1), 0.1f);
		GameRegistry.addSmelting(redPlasmaOre, new ItemStack(RedPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(purplePlasmaOre, new ItemStack(PurplePlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addSmelting(forerunnerOre, new ItemStack(ItemForerunnerShard.instance, 1), 0.1f);
		GameRegistry.addSmelting(GreenPlasmaIngot.instance, new ItemStack(ammoPlasma, 1), 0.1f);
		GameRegistry.addSmelting(greenPlasmaOre, new ItemStack(GreenPlasmaIngot.instance, 1), 0.1f);
		GameRegistry.addShapelessRecipe(new ItemStack(covenantPiece, 1), new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.coal, 1));
		// Frag Grenade Crafting
		ItemStack tntStack = new ItemStack(Blocks.tnt);
		GameRegistry.addRecipe(new ItemStack(FragGrenade.instance, 1), new Object[] { " X ", "XYX", "XXX", 'X', ironStack, 'Y', tntStack });

		// World Gen Registration
		GameRegistry.registerWorldGenerator(HaloOreGen, 1);

		if (event.getSide() == Side.CLIENT)
			proxy.preInit();
	}

	public int getRandomID()
	{
		counter++;
		return counter + EntityRegistry.findGlobalUniqueEntityId();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Register Key Handler(s)
		proxy.registerKey();

		// Register Rendering Classes
		proxy.registerRenders();

		// Register Packet Handler
		HalocraftPacketHandler.INSTANCE.registerMessage(FireMessageHandler.class, FireMessage.class, 0, Side.SERVER);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.getLogger().info("[HaloCraft 2.0]: Loaded Successfully!");
		FMLLog.getLogger().info("[HaloCraft 2.0]: This mod was created by NEGAFINITY, if you have issues please post them on GitHub!");
	}
}
