
package me.plinus.visual;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;

public class PlinusVisual implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModKeys.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            while (ModKeys.CLICK_GUI.consumeClick()) {

                if (client.screen instanceof VisualScreen) {
                    client.setScreen(null);
                } else if (client.screen == null) {
                    client.setScreen(new VisualScreen());
                }
            }

            while (ModKeys.FREECAM.consumeClick()) {
                FeatureSettings.FREECAM = !FeatureSettings.FREECAM;
            }

            while (ModKeys.WAYPOINT.consumeClick()) {
                FeatureSettings.WAYPOINTS = !FeatureSettings.WAYPOINTS;
            }

        });
    }
}
