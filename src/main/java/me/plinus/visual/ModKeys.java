package me.plinus.visual;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModKeys {

    public static KeyMapping CLICK_GUI;
    public static KeyMapping FREECAM;
    public static KeyMapping WAYPOINT;

    public static void register() {

        CLICK_GUI = KeyBindingHelper.registerKeyBinding(
            new KeyMapping(
                "key.plinus_visual.clickgui",
                GLFW.GLFW_KEY_LEFT_SHIFT,
                KeyMapping.Category.MISC
            )
        );

        FREECAM = KeyBindingHelper.registerKeyBinding(
            new KeyMapping(
                "key.plinus_visual.freecam",
                GLFW.GLFW_KEY_RIGHT_ALT,
                KeyMapping.Category.MISC
            )
        );

        WAYPOINT = KeyBindingHelper.registerKeyBinding(
            new KeyMapping(
                "key.plinus_visual.waypoint",
                GLFW.GLFW_KEY_B,
                KeyMapping.Category.MISC
            )
        );
    }
}
