package com.ultraxscott.ultraboost;

import com.ultraxscott.ultraboost.config.UltraBoostConfig;
import com.ultraxscott.ultraboost.config.UltraBoostConfigScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class UltraBoostClient implements ClientModInitializer {
    public static final String CATEGORY = "category.ultraboost";

    public static final KeyBinding OPEN_CONFIG = KeyBindingHelper.registerKeyBinding(
        new KeyBinding(
            "key.ultraboost.open_config",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            CATEGORY
        )
    );

    @Override
    public void onInitializeClient() {
        UltraBoostConfig.load();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (OPEN_CONFIG.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(UltraBoostConfigScreen.create(client, null));
                }
            }
        });

        UltraBoost.LOGGER.info("UltraBoost client initialized.");
    }

    public static void openConfigScreen() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            client.execute(() -> client.setScreen(UltraBoostConfigScreen.create(client, client.currentScreen)));
        }
    }
}
