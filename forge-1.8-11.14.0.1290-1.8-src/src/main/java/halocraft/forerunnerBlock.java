package halocraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class forerunnerBlock extends Block {

	protected forerunnerBlock(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("forerunnerBlock");
	}

}
