package halocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class itemRocket extends Item{
	public itemRocket() {
        setMaxStackSize(32);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("ammoRocket");
	}
}