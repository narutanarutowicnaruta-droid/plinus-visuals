package me.plinus.visual;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class PlinusVisual implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("[Plinus Visual] Mod loaded!");

        ModKeys.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            while (ModKeys.CLICK_GUI.consumeClick()) {
                if (client.screen instanceof VisualScreen) {
                    client.setScreen(null);
                } else {
                    client.setScreen(new VisualScreen());
                }
            }

            while (ModKeys.FREECAM.consumeClick()) {
                System.out.println("[Plinus Visual] Freecam pressed!");
            }

            while (ModKeys.WAYPOINT.consumeClick()) {
                System.out.println("[Plinus Visual] Waypoint pressed!");
            }
        });
    }
}
