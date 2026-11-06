package me.plinus.visual;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class ModKeys {

    public static KeyBinding CLICK_GUI;
    public static KeyBinding FREECAM;
    public static KeyBinding WAYPOINT;

    public static void register() {

        CLICK_GUI = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                "key.plinus_visual.clickgui",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyBinding.Category.MISC
            )
        );

        FREECAM = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                "key.plinus_visual.freecam",
                GLFW.GLFW_KEY_LEFT_ALT,
                KeyBinding.Category.MISC
            )
        );

        WAYPOINT = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                "key.plinus_visual.waypoint",
                GLFW.GLFW_KEY_B,
                KeyBinding.Category.MISC
            )
        );
    }
}
