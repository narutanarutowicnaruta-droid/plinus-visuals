package me.plinus.visual;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class VisualScreen extends Screen {

    public VisualScreen() {
        super(Component.literal("Plinus Visual"));
    }

    @Override
    protected void init() {
        int x = this.width / 2 - 100;
        int y = this.height / 2 - 65;

        addRenderableWidget(Button.builder(
            status("Full Bright", FeatureSettings.FULL_BRIGHT),
            button -> {
                FeatureSettings.FULL_BRIGHT = !FeatureSettings.FULL_BRIGHT;
                button.setMessage(status("Full Bright", FeatureSettings.FULL_BRIGHT));
            }
        ).bounds(x, y, 200, 20).build());

        addRenderableWidget(Button.builder(
            status("Hit Marker", FeatureSettings.HIT_MARKER),
            button -> {
                FeatureSettings.HIT_MARKER = !FeatureSettings.HIT_MARKER;
                button.setMessage(status("Hit Marker", FeatureSettings.HIT_MARKER));
            }
        ).bounds(x, y + 25, 200, 20).build());

        addRenderableWidget(Button.builder(
            status("Particles", FeatureSettings.PARTICLES),
            button -> {
                FeatureSettings.PARTICLES = !FeatureSettings.PARTICLES;
                button.setMessage(status("Particles", FeatureSettings.PARTICLES));
            }
        ).bounds(x, y + 50, 200, 20).build());

        addRenderableWidget(Button.builder(
            status("Waypoints", FeatureSettings.WAYPOINTS),
            button -> {
                FeatureSettings.WAYPOINTS = !FeatureSettings.WAYPOINTS;
                button.setMessage(status("Waypoints", FeatureSettings.WAYPOINTS));
            }
        ).bounds(x, y + 75, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Закрыть"),
            button -> onClose()
        ).bounds(x, y + 105, 200, 20).build());
    }

    private Component status(String name, boolean enabled) {
        return Component.literal(name + " [" + (enabled ? "ON" : "OFF") + "]");
    }

    @Override
    public void render(
        GuiGraphics graphics,
        int mouseX,
        int mouseY,
        float partialTick
    ) {
        // Обычный тёмный фон. Без размытия!
        graphics.fill(
            0, 0, this.width, this.height,
            0x99000000
        );

        int x = this.width / 2;
        int y = this.height / 2;

        graphics.fill(
            x - 115, y - 95,
            x + 115, y + 140,
            0xEE171717
        );

        graphics.fill(
            x - 115, y - 95,
            x + 115, y - 65,
            0xFF7736C9
        );

        graphics.drawCenteredString(
            this.font,
            "PLINUS VISUAL",
            x, y - 85,
            0xFFFFFFFF
        );

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
