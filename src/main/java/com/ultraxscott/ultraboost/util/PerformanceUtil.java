package com.ultraxscott.ultraboost.util;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class PerformanceUtil {
    private PerformanceUtil() {
    }

    public static boolean shouldCullEntity(Entity entity, Camera camera) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (!config.enabled || !config.smartEntityCulling || entity == null || camera == null) {
            return false;
        }

        Vec3d entityPos = entity.getPos();
        Vec3d cameraPos = camera.getPos();
        double dx = entityPos.x - cameraPos.x;
        double dy = entityPos.y - cameraPos.y;
        double dz = entityPos.z - cameraPos.z;
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return distance > config.entityCullingRange;
    }

    public static float clampRenderScale(float value) {
        return MathHelper.clamp(value, 0.5F, 1.0F);
    }

    public static int computeParticleLimit() {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (!config.enabled || !config.particleReduction) {
            return Integer.MAX_VALUE;
        }
        return Math.max(32, config.maxParticles);
    }

    public static int effectiveSimulationDistance(int defaultDistance) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (!config.enabled || !config.dynamicSimulationDistance) {
            return defaultDistance;
        }
        return Math.min(defaultDistance, config.simulationDistance);
    }

    public static boolean shouldUseFastFog() {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        return config.enabled && config.fastFog;
    }
}
