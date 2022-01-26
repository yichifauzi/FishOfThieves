package com.stevekung.fishofthieves.entity.animal;

import java.util.*;
import java.util.stream.Stream;

import com.stevekung.fishofthieves.FishOfThieves;
import com.stevekung.fishofthieves.entity.AbstractThievesFish;
import com.stevekung.fishofthieves.entity.ThievesFish;
import com.stevekung.fishofthieves.registry.FOTItems;
import com.stevekung.fishofthieves.registry.FOTSoundEvents;
import com.stevekung.fishofthieves.utils.Continentalness;
import com.stevekung.fishofthieves.utils.PeakTypes;
import com.stevekung.fishofthieves.utils.TerrainUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Islehopper extends AbstractThievesFish
{
    private static final Map<ThievesFish.FishVariant, ResourceLocation> GLOW_BY_TYPE = Collections.singletonMap(Variant.AMETHYST, new ResourceLocation(FishOfThieves.MOD_ID, "textures/entity/islehopper/amethyst_glow.png"));

    public Islehopper(EntityType<? extends Islehopper> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    public ItemStack getBucketItemStack()
    {
        return new ItemStack(FOTItems.ISLEHOPPER_BUCKET);
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return FOTSoundEvents.ISLEHOPPER_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return FOTSoundEvents.ISLEHOPPER_HURT;
    }

    @Override
    protected SoundEvent getFlopSound()
    {
        return FOTSoundEvents.ISLEHOPPER_FLOP;
    }

    @Override
    public boolean skipAttackInteraction(Entity entity)
    {
        var multiplier = this.isTrophy() ? 2 : 1;

        if (entity instanceof ServerPlayer serverPlayer && entity.hurt(DamageSource.mobAttack(this), multiplier))
        {
            if (!this.isSilent())
            {
                serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.PUFFER_FISH_STING, 0.0f));
            }
            serverPlayer.addEffect(new MobEffectInstance(MobEffects.POISON, 60 * multiplier, 0), this);
        }
        return false;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose)
    {
        return this.isTrophy() ? super.getDimensions(pose) : EntityDimensions.fixed(0.3F, 0.2F);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions size)
    {
        return this.isTrophy() ? 0.29F : 0.15F;
    }

    @Override
    public boolean canGlow()
    {
        return this.getVariant() == Variant.AMETHYST;
    }

    @Override
    public float getGlowBrightness(float ageInTicks)
    {
        return Mth.clamp(1.0F + Mth.cos(ageInTicks * 0.05f), 0.5F, 1.0F);
    }

    @Override
    public Variant getVariant()
    {
        return Variant.byId(this.entityData.get(TYPE));
    }

    @Override
    public int getSpawnVariantId(boolean bucket)
    {
        return ThievesFish.getSpawnVariant(this, Variant.BY_ID, Variant[]::new, bucket);
    }

    @Override
    public Map<FishVariant, ResourceLocation> getGlowTextureByType()
    {
        return GLOW_BY_TYPE;
    }

    public static boolean checkSpawnRules(EntityType<? extends WaterAnimal> entityType, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, Random random)
    {
        var waterRules = WaterAnimal.checkSurfaceWaterAnimalSpawnRules(entityType, levelAccessor, mobSpawnType, blockPos, random);
        var category = levelAccessor.getBiome(blockPos).getBiomeCategory();
        var continentalness = TerrainUtils.getContinentalness((ServerLevel) levelAccessor, blockPos);
        var peakTypes = TerrainUtils.getPeakTypes((ServerLevel) levelAccessor, blockPos);

        if (category == Biome.BiomeCategory.OCEAN || category == Biome.BiomeCategory.BEACH)
        {
            return (peakTypes == PeakTypes.LOW || peakTypes == PeakTypes.MID) && (continentalness == Continentalness.COAST || continentalness == Continentalness.OCEAN) && waterRules;
        }
        return category == Biome.BiomeCategory.UNDERGROUND && blockPos.getY() <= 0 || waterRules;
    }

    public enum Variant implements ThievesFish.FishVariant
    {
        STONE,
        MOSS(context ->
        {
            var category = TerrainUtils.getBiomeCategory(context.level(), context.blockPos());
            return category == Biome.BiomeCategory.JUNGLE || category == Biome.BiomeCategory.SWAMP || TerrainUtils.isInBiome(context.level(), context.blockPos(), Biomes.LUSH_CAVES);
        }),
        HONEY(context ->
        {
            var optional = TerrainUtils.lookForBlock(context.blockPos(), 5, blockPos2 ->
            {
                var blockState = context.level().getBlockState(blockPos2);
                var beehiveOptional = context.level().getBlockEntity(blockPos2, BlockEntityType.BEEHIVE);
                var isBeehive = blockState.is(BlockTags.BEEHIVES);
                return isBeehive && BeehiveBlockEntity.getHoneyLevel(blockState) == 5 && beehiveOptional.isPresent() && !beehiveOptional.get().isEmpty();
            });
            return optional.isPresent();
        }),
        RAVEN(context -> context.blockPos().getY() <= 0 && context.random().nextFloat() < FishOfThieves.CONFIG.spawnRate.ravenIslehopperProbability),
        AMETHYST(context -> TerrainUtils.lookForBlocksWithSize(context.blockPos(), 2, 16, blockPos2 -> context.level().getBlockState(blockPos2).is(BlockTags.CRYSTAL_SOUND_BLOCKS)));

        public static final Variant[] BY_ID = Stream.of(values()).sorted(Comparator.comparingInt(Variant::getId)).toArray(Variant[]::new);
        private final ThievesFish.Condition condition;

        Variant(ThievesFish.Condition condition)
        {
            this.condition = condition;
        }

        Variant()
        {
            this(ThievesFish.Condition.always());
        }

        @Override
        public String getName()
        {
            return this.name().toLowerCase(Locale.ROOT);
        }

        @Override
        public int getId()
        {
            return this.ordinal();
        }

        @Override
        public ThievesFish.Condition getCondition()
        {
            return this.condition;
        }

        public static Variant byId(int id)
        {
            var types = BY_ID;

            if (id < 0 || id >= types.length)
            {
                id = 0;
            }
            return types[id];
        }
    }
}