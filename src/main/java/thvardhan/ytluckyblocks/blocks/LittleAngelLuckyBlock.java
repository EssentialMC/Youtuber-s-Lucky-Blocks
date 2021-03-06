package thvardhan.ytluckyblocks.blocks;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thvardhan.ytluckyblocks.CommonProxy;
import thvardhan.ytluckyblocks.entity.EntityBabyAngel;
import thvardhan.ytluckyblocks.entity.EntityPeteZahHutt;
import thvardhan.ytluckyblocks.entity.EntitySerialPlayer;
import thvardhan.ytluckyblocks.functions.ExtraFunctions;
import thvardhan.ytluckyblocks.items.ModItems;

import java.util.Random;

public class LittleAngelLuckyBlock extends Block {
    public LittleAngelLuckyBlock(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setCreativeTab(CommonProxy.tabYTStuffMod);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightLevel(0F);
    }

    public LittleAngelLuckyBlock(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.ROCK, 0, 10000);
    }

    public LittleAngelLuckyBlock(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        for (int i = 0; i < 3; ++i) {
            int j = rand.nextInt(2) * 2 - 1;
            int k = rand.nextInt(2) * 2 - 1;
            double d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
            double d1 = (double) ((float) pos.getY() + rand.nextFloat());
            double d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) k;
            double d3 = (double) (rand.nextFloat() * (float) j);
            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.125D;
            double d5 = (double) (rand.nextFloat() * (float) k);
            worldIn.spawnParticle(EnumParticleTypes.SPELL, d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (!world.isRemote && player != null && !(player instanceof FakePlayer)) {
            world.setBlockToAir(pos);
            drops(world, pos, player);
        }
        return false;
    }

    private void drops(World worldIn, BlockPos pos, EntityPlayer player) {

        Enchantment[] e = new Enchantment[5];
        e[0] = Enchantment.getEnchantmentByID(50);
        e[1] = Enchantment.getEnchantmentByID(19);
        e[2] = Enchantment.getEnchantmentByID(48);
        e[3] = Enchantment.getEnchantmentByID(7);
        e[4] = Enchantment.getEnchantmentByID(21);


        Random rand = new Random();


        switch (rand.nextInt(51)) {

            default: {
                ExtraFunctions.addEnchantsMany(new ItemStack(Items.DIAMOND_SWORD), e, 5, worldIn, pos);
            }
            case 0: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.ytBoots));
                break;
            }
            case 1: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.ytChestplate));
                break;
            }
            case 2: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.ytHelmet));
                break;
            }
            case 3: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.ytLeggings));
                break;
            }
            case 4: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.angelBoots));
                break;
            }
            case 5: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.angelChestplate));
                break;
            }
            case 6: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.angelHelmet));
                break;
            }
            case 7: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.angelLeggings));
                break;
            }
            case 8: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModItems.megaSword));
                break;
            }
            case 9: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.GLOWSTONE);
                break;
            }
            case 10: {
                ExtraFunctions.summonMobsNearby(new EntityPeteZahHutt(worldIn), 25, worldIn, pos, rand);
                break;
            }
            case 11: {
                ExtraFunctions.summonMobsNearby(new EntityIronGolem(worldIn), 15, worldIn, pos, rand);
                break;
            }
            case 12: {
                ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Blocks.FLOWER_POT), 23, 1, 2);
                break;
            }
            case 13: {
                ExtraFunctions.summonMobsOnBreakBlock(new EntityWither(worldIn), 1, worldIn, pos);
                break;
            }
            case 14: {
                ExtraFunctions.holeDeathTrap(worldIn, pos);
                break;
            }
            case 15: {
                ExtraFunctions.summonMobsNearby(new EntityCreeper(worldIn), 70, worldIn, pos, rand);
                break;
            }
            case 16: {
                ExtraFunctions.summonCowNearby(worldIn, pos, 10, rand);
                break;
            }
            case 17: {
                ExtraFunctions.tpPlayerInGround(player);
                break;
            }
            case 18: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModBlocks.diamondButton));
                break;
            }
            case 19: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModBlocks.ironButton));
                break;
            }
            case 20: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ModBlocks.goldButton));
                break;
            }
            case 21: {
                ExtraFunctions.anvilRain(worldIn, pos);
                break;
            }
            case 22: {
                ExtraFunctions.flyingIsle(worldIn, pos);
                break;
            }
            case 23: {
                ExtraFunctions.luckyBlockTower(worldIn, pos);
                break;
            }
            case 24: {
                ExtraFunctions.luckyBlockBox(worldIn, pos, rand);
                break;
            }
            case 25: {
                ExtraFunctions.mountainOne(worldIn, pos, rand);
                break;
            }
            case 26: {
                ExtraFunctions.summonMobsOnBreakBlock(new EntityBabyAngel(worldIn), 15, worldIn, pos);
                break;
            }
            case 27: {
                ExtraFunctions.summonMobsOnBreakBlock(new EntityBabyAngel(worldIn), 10, worldIn, pos);
                break;
            }
            case 28: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.COMMAND_BLOCK);
                ExtraFunctions.chat(ChatFormatting.GOLD + "I Wonder If You Can Do Anything With This Command Block..", player);
                break;
            }
            case 29: {
                ExtraFunctions.toVoid(worldIn, pos);
                break;
            }
            case 30: {
                ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Blocks.MELON_BLOCK), 25, 0, 0);
                break;
            }
            case 31: {
                ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Blocks.PUMPKIN), 25, 0, 0);
                break;
            }
            case 32: {
                ExtraFunctions.summonMobsOnBreakBlock(new EntitySerialPlayer(worldIn), rand.nextInt(50) + 1, worldIn, pos);
                break;
            }
            case 33: {
                ExtraFunctions.materialKit(worldIn, pos, rand);
                break;
            }
            case 34: {
                ItemStack[] i = {new ItemStack(Items.APPLE), new ItemStack(Items.ARROW), new ItemStack(Items.BAKED_POTATO)
                        , new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.MAP), new ItemStack(Items.DIAMOND_AXE),
                        new ItemStack(Items.DIAMOND_HORSE_ARMOR)};
                ExtraFunctions.addRandomEnchtToRandomItems(worldIn, i, e, 8, pos, rand);
                break;
            }
            case 35: {
                ExtraFunctions.summonItemWithLoop(worldIn, pos, Items.BAKED_POTATO, 50, 1, 10);
                ExtraFunctions.chat("ItS PoTaT RaIn!", player);
                break;
            }
            case 36: {
                ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.IRON_AXE), 5, 1, 50);
                break;
            }
            case 37: {
                ExtraFunctions.orcArmy(worldIn, pos, 50, rand);
                break;
            }
            case 38: {
                ExtraFunctions.addEnchantsMany(new ItemStack(ModItems.swordLogdotzip), e, 8, worldIn, pos);
                break;
            }
            case 39: {
                ExtraFunctions.redstoneKit(worldIn, pos);
                break;
            }
            case 40: {
                ExtraFunctions.foodKit(worldIn, pos);
                break;
            }
            case 41: {
                ExtraFunctions.hellWellStructure(worldIn, pos, rand);
                break;
            }
            case 42: {
                ExtraFunctions.setTntWithBlock(worldIn, pos, rand);
                break;
            }
            case 43: {
                ExtraFunctions.lookUp(worldIn, player);
                break;
            }
            case 44: {
                ExtraFunctions.setOneBlock(worldIn, pos, ModBlocks.captainSparkelzLuckyBlock);
                break;
            }
            case 45: {
                ExtraFunctions.setOneBlock(worldIn, pos, ModBlocks.gamingWithJenLuckyBlock);
                break;
            }
            case 46: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.TNT);
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Items.FLINT_AND_STEEL));
                break;
            }
            case 47: {
                ExtraFunctions.summonMobsOnBreakBlock(new EntitySerialPlayer(worldIn), 20, worldIn, pos);
                break;
            }
            case 48: {
                ExtraFunctions.endWellStruct(worldIn, pos, rand);
                break;
            }
            case 49: {
                ExtraFunctions.holeDeathTrap(worldIn, pos);
                break;
            }
            case 50: {
                ExtraFunctions.burgerStruct(worldIn, pos);
                break;
            }


        }//switch ends
    }//method end


}
