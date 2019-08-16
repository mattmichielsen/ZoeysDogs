package us.michielsen.zoeysdogs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ZoeysDogs.MODID, version = ZoeysDogs.VERSION, dependencies = "required-after:copiousdogs")
public class ZoeysDogs
{
    public static final String MODID = "zoeysdogs";
    public static final String VERSION = "0.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Block dogOre = new DogOreBlock(Material.rock, "dogOre", GameRegistry.findItem("copiousdogs", "copiousdogs.dogBiscuit"));
        GameRegistry.registerBlock(dogOre, "dogOre");
    }
        
    private class DogOreBlock extends Block
    {
    	private Item toDrop;
    	
		public DogOreBlock(Material material, String blockName, Item toDrop)
		{
			super(material);
			this.setBlockName(blockName);
			this.setBlockTextureName(MODID + ":" + blockName);
			this.setCreativeTab(CreativeTabs.tabBlock);
			this.setHardness(3);
			this.setHarvestLevel("pickaxe", 3);
			this.toDrop = toDrop;
		}
		
		@Override
		public Item getItemDropped(int i, Random random, int j)
		{
			if (toDrop != null)
			{
				return toDrop;
			}
			else
			{
				return Item.getItemFromBlock(this);
			}
		}
    }
}
