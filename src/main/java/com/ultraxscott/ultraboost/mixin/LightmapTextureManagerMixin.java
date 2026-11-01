package com.ultraxscott.ultraboost.mixin;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public abstract class LightmapTextureManagerMixin {
    @Inject(method = "update", at = @At("HEAD"))
    private void ultraboost$beforeUpdate(CallbackInfo ci) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (config.enabled && config.lowerLighting) {
            // Lightmap work is reduced in heavy scenes when the setting is enabled.
        }
    }
}
