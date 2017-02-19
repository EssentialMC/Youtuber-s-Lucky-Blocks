package thvardhan.ytluckyblocks.items;

import thvardhan.ytluckyblocks.CommonProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class LevinSword extends ItemSword {

	public LevinSword(String string, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(string);
		this.setCreativeTab(CommonProxy.tabYTStuffMod);
		
	}
	
	
	@Override
	public Item setNoRepair() {
		return super.setNoRepair();
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
	
		
		return super.onLeftClickEntity(stack, player, entity);
	}

}