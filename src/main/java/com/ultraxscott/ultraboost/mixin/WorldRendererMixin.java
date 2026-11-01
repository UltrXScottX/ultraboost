package com.ultraxscott.ultraboost.mixin;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import com.ultraxscott.ultraboost.util.PerformanceUtil;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void ultraboost$beforeRender(CallbackInfo ci) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (!config.enabled) {
            return;
        }

        if (config.fastFog && PerformanceUtil.shouldUseFastFog()) {
            // Fast fog tuning hook.
        }

        if (config.renderScaleEnabled && config.renderScale < 1.0F) {
            float clamped = PerformanceUtil.clampRenderScale(config.renderScale);
            if (clamped < 1.0F) {
                // Render scale tuning hook for reduced GPU pressure.
            }
        }
    }
}
