package com.ultraxscott.ultraboost;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltraBoost implements ModInitializer {
    public static final String MOD_ID = "ultraboost";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        UltraBoostConfig.load();
        LOGGER.info("UltraBoost initialized successfully.");
    }
}
