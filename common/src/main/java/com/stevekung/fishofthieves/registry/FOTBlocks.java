package com.stevekung.fishofthieves.registry;

import com.stevekung.fishofthieves.FOTPlatform;
import com.stevekung.fishofthieves.block.FishBoneBlock;
import com.stevekung.fishofthieves.block.FishPlaqueBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class FOTBlocks
{
    public static final Block FISH_BONE = new FishBoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).pushReaction(PushReaction.DESTROY).strength(0.25f).dynamicShape().offsetType(BlockBehaviour.OffsetType.XYZ).sound(SoundType.BONE_BLOCK));

    public static final Block OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block SPRUCE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.SPRUCE_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block BIRCH_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.BIRCH_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block JUNGLE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.JUNGLE_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block ACACIA_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.ACACIA_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block DARK_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.DARK_OAK_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block MANGROVE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.MANGROVE_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block CHERRY_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.CHERRY_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.CHERRY_WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block BAMBOO_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.BAMBOO_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.BAMBOO_WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block CRIMSON_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.CRIMSON_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.NETHER_WOOD), FishPlaqueBlock.Type.WOODEN);
    public static final Block WARPED_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.of().mapColor(Blocks.WARPED_PLANKS.defaultMapColor()).noCollission().strength(1.0F).sound(SoundType.NETHER_WOOD), FishPlaqueBlock.Type.WOODEN);

    public static final Block IRON_FRAME_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(OAK_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_SPRUCE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(SPRUCE_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_BIRCH_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(BIRCH_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_JUNGLE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(JUNGLE_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_ACACIA_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(ACACIA_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_DARK_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(DARK_OAK_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_MANGROVE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(MANGROVE_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_CHERRY_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(CHERRY_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_BAMBOO_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(BAMBOO_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_CRIMSON_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(CRIMSON_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);
    public static final Block IRON_FRAME_WARPED_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(WARPED_FISH_PLAQUE), FishPlaqueBlock.Type.IRON);

    public static final Block GOLDEN_FRAME_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(OAK_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_SPRUCE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(SPRUCE_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_BIRCH_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(BIRCH_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_JUNGLE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(JUNGLE_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_ACACIA_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(ACACIA_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_DARK_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(DARK_OAK_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_MANGROVE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(MANGROVE_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_CHERRY_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(CHERRY_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_BAMBOO_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(BAMBOO_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_CRIMSON_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(CRIMSON_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);
    public static final Block GOLDEN_FRAME_WARPED_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(WARPED_FISH_PLAQUE), FishPlaqueBlock.Type.GOLDEN);

    public static final Block GILDED_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(OAK_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_SPRUCE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(SPRUCE_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_BIRCH_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(BIRCH_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_JUNGLE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(JUNGLE_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_ACACIA_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(ACACIA_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_DARK_OAK_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(DARK_OAK_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_MANGROVE_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(MANGROVE_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_CHERRY_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(CHERRY_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_BAMBOO_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(BAMBOO_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_CRIMSON_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(CRIMSON_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);
    public static final Block GILDED_WARPED_FISH_PLAQUE = new FishPlaqueBlock(BlockBehaviour.Properties.copy(WARPED_FISH_PLAQUE), FishPlaqueBlock.Type.GILDED);

    public static void init()
    {
        register("fish_bone", FISH_BONE);

        register("oak_fish_plaque", OAK_FISH_PLAQUE);
        register("spruce_fish_plaque", SPRUCE_FISH_PLAQUE);
        register("birch_fish_plaque", BIRCH_FISH_PLAQUE);
        register("jungle_fish_plaque", JUNGLE_FISH_PLAQUE);
        register("acacia_fish_plaque", ACACIA_FISH_PLAQUE);
        register("dark_oak_fish_plaque", DARK_OAK_FISH_PLAQUE);
        register("mangrove_fish_plaque", MANGROVE_FISH_PLAQUE);
        register("cherry_fish_plaque", CHERRY_FISH_PLAQUE);
        register("bamboo_fish_plaque", BAMBOO_FISH_PLAQUE);
        register("crimson_fish_plaque", CRIMSON_FISH_PLAQUE);
        register("warped_fish_plaque", WARPED_FISH_PLAQUE);

        register("iron_frame_oak_fish_plaque", IRON_FRAME_OAK_FISH_PLAQUE);
        register("iron_frame_spruce_fish_plaque", IRON_FRAME_SPRUCE_FISH_PLAQUE);
        register("iron_frame_birch_fish_plaque", IRON_FRAME_BIRCH_FISH_PLAQUE);
        register("iron_frame_jungle_fish_plaque", IRON_FRAME_JUNGLE_FISH_PLAQUE);
        register("iron_frame_acacia_fish_plaque", IRON_FRAME_ACACIA_FISH_PLAQUE);
        register("iron_frame_dark_oak_fish_plaque", IRON_FRAME_DARK_OAK_FISH_PLAQUE);
        register("iron_frame_mangrove_fish_plaque", IRON_FRAME_MANGROVE_FISH_PLAQUE);
        register("iron_frame_cherry_fish_plaque", IRON_FRAME_CHERRY_FISH_PLAQUE);
        register("iron_frame_bamboo_fish_plaque", IRON_FRAME_BAMBOO_FISH_PLAQUE);
        register("iron_frame_crimson_fish_plaque", IRON_FRAME_CRIMSON_FISH_PLAQUE);
        register("iron_frame_warped_fish_plaque", IRON_FRAME_WARPED_FISH_PLAQUE);

        register("golden_frame_oak_fish_plaque", GOLDEN_FRAME_OAK_FISH_PLAQUE);
        register("golden_frame_spruce_fish_plaque", GOLDEN_FRAME_SPRUCE_FISH_PLAQUE);
        register("golden_frame_birch_fish_plaque", GOLDEN_FRAME_BIRCH_FISH_PLAQUE);
        register("golden_frame_jungle_fish_plaque", GOLDEN_FRAME_JUNGLE_FISH_PLAQUE);
        register("golden_frame_acacia_fish_plaque", GOLDEN_FRAME_ACACIA_FISH_PLAQUE);
        register("golden_frame_dark_oak_fish_plaque", GOLDEN_FRAME_DARK_OAK_FISH_PLAQUE);
        register("golden_frame_mangrove_fish_plaque", GOLDEN_FRAME_MANGROVE_FISH_PLAQUE);
        register("golden_frame_cherry_fish_plaque", GOLDEN_FRAME_CHERRY_FISH_PLAQUE);
        register("golden_frame_bamboo_fish_plaque", GOLDEN_FRAME_BAMBOO_FISH_PLAQUE);
        register("golden_frame_crimson_fish_plaque", GOLDEN_FRAME_CRIMSON_FISH_PLAQUE);
        register("golden_frame_warped_fish_plaque", GOLDEN_FRAME_WARPED_FISH_PLAQUE);

        register("gilded_oak_fish_plaque", GILDED_OAK_FISH_PLAQUE);
        register("gilded_spruce_fish_plaque", GILDED_SPRUCE_FISH_PLAQUE);
        register("gilded_birch_fish_plaque", GILDED_BIRCH_FISH_PLAQUE);
        register("gilded_jungle_fish_plaque", GILDED_JUNGLE_FISH_PLAQUE);
        register("gilded_acacia_fish_plaque", GILDED_ACACIA_FISH_PLAQUE);
        register("gilded_dark_oak_fish_plaque", GILDED_DARK_OAK_FISH_PLAQUE);
        register("gilded_mangrove_fish_plaque", GILDED_MANGROVE_FISH_PLAQUE);
        register("gilded_cherry_fish_plaque", GILDED_CHERRY_FISH_PLAQUE);
        register("gilded_bamboo_fish_plaque", GILDED_BAMBOO_FISH_PLAQUE);
        register("gilded_crimson_fish_plaque", GILDED_CRIMSON_FISH_PLAQUE);
        register("gilded_warped_fish_plaque", GILDED_WARPED_FISH_PLAQUE);
    }

    private static void register(String key, Block block)
    {
        FOTPlatform.registerBlock(key, block);
    }
}