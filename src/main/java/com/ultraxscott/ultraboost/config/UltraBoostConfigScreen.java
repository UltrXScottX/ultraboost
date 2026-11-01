package com.ultraxscott.ultraboost.config;

import com.ultraxscott.ultraboost.UltraBoost;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class UltraBoostConfigScreen {
    private UltraBoostConfigScreen() {
    }

    public static Screen create(MinecraftClient client, Screen parent) {
        UltraBoostConfig config = UltraBoostConfig.getInstance();
        ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(Text.translatable("screen.ultraboost.title"));

        builder.setSavingRunnable(UltraBoostConfig::save);

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        ConfigCategory general = builder.getOrCreateCategory(Text.translatable("category.ultraboost.general"));
        general.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.enabled"),
                config.enabled
            )
            .setTooltip(Text.translatable("option.ultraboost.enabled.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.enabled = value)
            .build());

        general.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.fps_limiter_enabled"),
                config.fpsLimiterEnabled
            )
            .setTooltip(Text.translatable("option.ultraboost.fps_limiter_enabled.tooltip"))
            .setDefaultValue(false)
            .setSaveConsumer(value -> config.fpsLimiterEnabled = value)
            .build());

        general.addEntry(entryBuilder.startIntField(
                Text.translatable("option.ultraboost.target_fps"),
                config.targetFps
            )
            .setTooltip(Text.translatable("option.ultraboost.target_fps.tooltip"))
            .setDefaultValue(60)
            .setMin(30)
            .setMax(240)
            .setSaveConsumer(value -> config.targetFps = value)
            .build());

        general.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.dynamic_simulation_distance"),
                config.dynamicSimulationDistance
            )
            .setTooltip(Text.translatable("option.ultraboost.dynamic_simulation_distance.tooltip"))
            .setDefaultValue(false)
            .setSaveConsumer(value -> config.dynamicSimulationDistance = value)
            .build());

        general.addEntry(entryBuilder.startIntField(
                Text.translatable("option.ultraboost.simulation_distance"),
                config.simulationDistance
            )
            .setTooltip(Text.translatable("option.ultraboost.simulation_distance.tooltip"))
            .setDefaultValue(8)
            .setMin(2)
            .setMax(16)
            .setSaveConsumer(value -> config.simulationDistance = value)
            .build());

        general.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.reduce_weather"),
                config.reduceWeather
            )
            .setTooltip(Text.translatable("option.ultraboost.reduce_weather.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.reduceWeather = value)
            .build());

        general.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.reduce_clouds"),
                config.reduceClouds
            )
            .setTooltip(Text.translatable("option.ultraboost.reduce_clouds.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.reduceClouds = value)
            .build());

        ConfigCategory rendering = builder.getOrCreateCategory(Text.translatable("category.ultraboost.rendering"));
        rendering.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.render_scale_enabled"),
                config.renderScaleEnabled
            )
            .setTooltip(Text.translatable("option.ultraboost.render_scale_enabled.tooltip"))
            .setDefaultValue(false)
            .setSaveConsumer(value -> config.renderScaleEnabled = value)
            .build());

        rendering.addEntry(entryBuilder.startFloatField(
                Text.translatable("option.ultraboost.render_scale"),
                config.renderScale
            )
            .setTooltip(Text.translatable("option.ultraboost.render_scale.tooltip"))
            .setDefaultValue(0.8F)
            .setMin(0.5F)
            .setMax(1.0F)
            .setSaveConsumer(value -> config.renderScale = value)
            .build());

        rendering.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.fast_fog"),
                config.fastFog
            )
            .setTooltip(Text.translatable("option.ultraboost.fast_fog.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.fastFog = value)
            .build());

        rendering.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.reduce_overdraw"),
                config.reduceOverdraw
            )
            .setTooltip(Text.translatable("option.ultraboost.reduce_overdraw.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.reduceOverdraw = value)
            .build());

        rendering.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.disable_expensive_effects"),
                config.disableExpensiveEffects
            )
            .setTooltip(Text.translatable("option.ultraboost.disable_expensive_effects.tooltip"))
            .setDefaultValue(false)
            .setSaveConsumer(value -> config.disableExpensiveEffects = value)
            .build());

        ConfigCategory entities = builder.getOrCreateCategory(Text.translatable("category.ultraboost.entities"));
        entities.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.smart_entity_culling"),
                config.smartEntityCulling
            )
            .setTooltip(Text.translatable("option.ultraboost.smart_entity_culling.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.smartEntityCulling = value)
            .build());

        entities.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.frustum_culling"),
                config.frustumCulling
            )
            .setTooltip(Text.translatable("option.ultraboost.frustum_culling.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.frustumCulling = value)
            .build());

        entities.addEntry(entryBuilder.startIntField(
                Text.translatable("option.ultraboost.entity_culling_range"),
                config.entityCullingRange
            )
            .setTooltip(Text.translatable("option.ultraboost.entity_culling_range.tooltip"))
            .setDefaultValue(24)
            .setMin(8)
            .setMax(64)
            .setSaveConsumer(value -> config.entityCullingRange = value)
            .build());

        entities.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.particle_reduction"),
                config.particleReduction
            )
            .setTooltip(Text.translatable("option.ultraboost.particle_reduction.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.particleReduction = value)
            .build());

        entities.addEntry(entryBuilder.startIntField(
                Text.translatable("option.ultraboost.max_particles"),
                config.maxParticles
            )
            .setTooltip(Text.translatable("option.ultraboost.max_particles.tooltip"))
            .setDefaultValue(512)
            .setMin(32)
            .setMax(2048)
            .setSaveConsumer(value -> config.maxParticles = value)
            .build());

        entities.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.reduce_entity_updates"),
                config.reduceEntityUpdates
            )
            .setTooltip(Text.translatable("option.ultraboost.reduce_entity_updates.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.reduceEntityUpdates = value)
            .build());

        entities.addEntry(entryBuilder.startIntField(
                Text.translatable("option.ultraboost.entity_update_throttle_ms"),
                config.entityUpdateThrottleMs
            )
            .setTooltip(Text.translatable("option.ultraboost.entity_update_throttle_ms.tooltip"))
            .setDefaultValue(2)
            .setMin(0)
            .setMax(20)
            .setSaveConsumer(value -> config.entityUpdateThrottleMs = value)
            .build());

        ConfigCategory advanced = builder.getOrCreateCategory(Text.translatable("category.ultraboost.advanced"));
        advanced.addEntry(entryBuilder.startBooleanToggle(
                Text.translatable("option.ultraboost.lower_lighting"),
                config.lowerLighting
            )
            .setTooltip(Text.translatable("option.ultraboost.lower_lighting.tooltip"))
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.lowerLighting = value)
            .build());

        advanced.addEntry(entryBuilder.startButton(Text.translatable("option.ultraboost.reset_to_defaults"), () -> {
            UltraBoostConfig.resetToDefaults();
            UltraBoost.LOGGER.info("UltraBoost config reset to defaults.");
        }).build());

        return builder.build();
    }
}
