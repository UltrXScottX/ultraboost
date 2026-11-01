package com.ultraxscott.ultraboost.mixin;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void ultraboost$beforeTick(CallbackInfo ci) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (config.enabled && config.reduceWeather) {
            // Weather and world-level load reduction hooks can be extended here.
        }
    }
}
