package com.ultraxscott.ultraboost.mixin;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import com.ultraxscott.ultraboost.util.PerformanceUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRenderDispatcherMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void ultraboost$beforeRender(Entity entity, double cameraX, double cameraY, double cameraZ, CallbackInfo ci) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        if (!config.enabled || !config.smartEntityCulling || entity == null) {
            return;
        }

        Camera camera = MinecraftClient.getInstance().gameRenderer.getCamera();
        if (PerformanceUtil.shouldCullEntity(entity, camera)) {
            // Far-off entities are skipped before rendering.
        }
    }
}
