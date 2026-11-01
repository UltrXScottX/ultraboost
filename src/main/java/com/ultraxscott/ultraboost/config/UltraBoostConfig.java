package com.ultraxscott.ultraboost.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ultraxscott.ultraboost.UltraBoost;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UltraBoostConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("ultraboost.json");

    private static UltraBoostConfig INSTANCE = new UltraBoostConfig();

    public boolean enabled = true;

    public boolean smartEntityCulling = true;
    public int entityCullingRange = 24;
    public boolean frustumCulling = true;

    public boolean particleReduction = true;
    public int maxParticles = 512;

    public boolean dynamicSimulationDistance = false;
    public int simulationDistance = 8;

    public boolean fpsLimiterEnabled = false;
    public int targetFps = 60;

    public boolean reduceWeather = true;
    public boolean reduceClouds = true;

    public boolean lowerLighting = true;
    public boolean reduceEntityUpdates = true;
    public int entityUpdateThrottleMs = 2;

    public boolean renderScaleEnabled = false;
    public float renderScale = 0.8F;

    public boolean fastFog = true;
    public boolean reduceOverdraw = true;
    public boolean disableExpensiveEffects = false;

    public static UltraBoostConfig getInstance() {
        return INSTANCE;
    }

    public static void load() {
        try {
            if (Files.exists(CONFIG_PATH)) {
                var json = Files.readString(CONFIG_PATH);
                UltraBoostConfig loaded = GSON.fromJson(json, UltraBoostConfig.class);
                INSTANCE = loaded == null ? new UltraBoostConfig() : loaded;
            } else {
                INSTANCE = new UltraBoostConfig();
                save();
            }
        } catch (IOException e) {
            UltraBoost.LOGGER.error("Failed to load UltraBoost config", e);
            INSTANCE = new UltraBoostConfig();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            Files.writeString(CONFIG_PATH, GSON.toJson(INSTANCE));
        } catch (IOException e) {
            UltraBoost.LOGGER.error("Failed to save UltraBoost config", e);
        }
    }

    public static void resetToDefaults() {
        INSTANCE = new UltraBoostConfig();
        save();
    }
}
