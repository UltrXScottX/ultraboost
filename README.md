# UltraBoost

UltraBoost is a lightweight Fabric client-side performance mod for Minecraft Java Edition 1.21.6.

Features:
- Smart entity culling
- Particle reduction
- Optional simulation distance control
- FPS target tuning
- Fast fog and render scale options
- Reduced lighting updates
- Configurable entity update throttling
- Cloth Config + Mod Menu support
- Right Shift key to open config

## Build

Requirements:
- Java 21
- Gradle 8+
- Fabric Loader 0.16+
- Fabric API for 1.21.6

Build commands:
```bash
./gradlew build
```

If you do not have the wrapper installed, use:
```bash
gradle build
```

## Install
1. Put the generated JAR from `build/libs/` into your Fabric mods folder.
2. Make sure you are running Minecraft 1.21.6 with Fabric Loader 0.16+.
3. Install Fabric API and optionally Cloth Config / Mod Menu.
4. Launch Minecraft and press Right Shift to open UltraBoost.

## Notes
This mod is client-side only and designed to improve smoothness and FPS, especially on lower-end hardware and mobile launchers such as Pojav and Zalith.
