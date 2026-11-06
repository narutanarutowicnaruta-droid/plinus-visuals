package me.plinus.visual;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.KeyMapping.Category;
import org.lwjgl.glfw.GLFW;

public class PlinusVisual implements ClientModInitializer {

    public static boolean clickGuiOpen = false;

    @Override
    public void onInitializeClient() {
        System.out.println("[Plinus Visual] Mod loaded!");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            if (client.options.keyShift.isDown()) {
                // GUI hotkey will be handled in the next class.
            }
        });
    }
}
