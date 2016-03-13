package halocraft.items.firearms;

import halocraft.entities.EntityBullet;
import halocraft.proxies.CommonProxy;

public class ItemShotgun extends ItemFirearm
{
	public static String name = "itemShotgun";
	public static ItemFirearm instance = new ItemShotgun();

	public ItemShotgun()
	{
		super();

		this.damage = 6;
		this.ammoItem = CommonProxy.ammoAssaultRifle;
		this.bulletClass = EntityBullet.class;
		this.setUnlocalizedName("halocraft:" + name.toLowerCase());
	}
}
