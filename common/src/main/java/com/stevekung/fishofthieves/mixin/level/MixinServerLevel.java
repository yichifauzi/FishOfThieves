package com.stevekung.fishofthieves.mixin.level;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import com.llamalad7.mixinextras.sugar.Local;
import com.stevekung.fishofthieves.registry.FOTEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel extends Level
{
    MixinServerLevel()
    {
        super(null, null, null, null, null, false, false, 0, 0);
    }

    @Inject(method = "tickChunk", cancellable = true, at = @At(value = "INVOKE", target = "net/minecraft/server/level/ServerLevel.isThundering()Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void fishofthieves$specialThunderTick(LevelChunk chunk, int randomTickSpeed, CallbackInfo info, @Local(index = 4, ordinal = 0) boolean isRaining, @Local(index = 5, ordinal = 1) int x, @Local(index = 6, ordinal = 2) int z)
    {
        var blockPos = this.findNearestStormfish(this.getBlockRandomPos(x, 0, z, 15));

        if (blockPos.isPresent() && isRaining && this.isThundering() && this.random.nextInt(5000) == 0)
        {
            var lightningBolt = EntityType.LIGHTNING_BOLT.create(this);
            lightningBolt.moveTo(Vec3.atBottomCenterOf(blockPos.get()));
            this.addFreshEntity(lightningBolt);
        }
    }

    private boolean isRainingAtFromBelowWater(BlockPos blockPos)
    {
        if (!this.isRaining() || !this.canSeeSkyFromBelowWater(blockPos) || this.getBrightness(LightLayer.SKY, blockPos) < 12)
        {
            return false;
        }
        var biome = this.getBiome(blockPos).value();
        return biome.getPrecipitationAt(blockPos) == Biome.Precipitation.RAIN;
    }

    private Optional<BlockPos> findNearestStormfish(BlockPos blockPos)
    {
        var blockPos2 = this.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);
        var aabb = new AABB(blockPos2, new BlockPos(blockPos2.getX(), this.getMaxBuildHeight(), blockPos2.getZ())).inflate(8.0D);
        return Optional.of(this.getEntities(FOTEntities.STORMFISH, aabb, living -> living != null && living.isAlive() && this.isRainingAtFromBelowWater(blockPos2))).filter(stormfish -> !stormfish.isEmpty()).map(stormfish -> stormfish.get(this.random.nextInt(stormfish.size())).blockPosition());
    }
}