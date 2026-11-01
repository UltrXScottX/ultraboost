package com.ultraxscott.ultraboost.mixin;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import com.ultraxscott.ultraboost.util.PerformanceUtil;
import net.minecraft.client.particle.ParticleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public abstract class ParticleManagerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void ultraboost$beforeTick(CallbackInfo ci) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (!config.enabled || !config.particleReduction) {
            return;
        }

        int limit = PerformanceUtil.computeParticleLimit();
        if (limit > 0) {
            // Particle budgets can be enforced from this point to reduce visual and CPU cost.
        }
    }
}
