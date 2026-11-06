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
            getStatus("Full Bright", FeatureSettings.FULL_BRIGHT),
            button -> {
                FeatureSettings.FULL_BRIGHT = !FeatureSettings.FULL_BRIGHT;
                button.setMessage(getStatus("Full Bright", FeatureSettings.FULL_BRIGHT));
            }
        ).bounds(x, y, 200, 20).build());

        addRenderableWidget(Button.builder(
            getStatus("Hit Marker", FeatureSettings.HIT_MARKER),
            button -> {
                FeatureSettings.HIT_MARKER = !FeatureSettings.HIT_MARKER;
                button.setMessage(getStatus("Hit Marker", FeatureSettings.HIT_MARKER));
            }
        ).bounds(x, y + 25, 200, 20).build());

        addRenderableWidget(Button.builder(
            getStatus("Particles", FeatureSettings.PARTICLES),
            button -> {
                FeatureSettings.PARTICLES = !FeatureSettings.PARTICLES;
                button.setMessage(getStatus("Particles", FeatureSettings.PARTICLES));
            }
        ).bounds(x, y + 50, 200, 20).build());

        addRenderableWidget(Button.builder(
            getStatus("Waypoints", FeatureSettings.WAYPOINTS),
            button -> {
                FeatureSettings.WAYPOINTS = !FeatureSettings.WAYPOINTS;
                button.setMessage(getStatus("Waypoints", FeatureSettings.WAYPOINTS));
            }
        ).bounds(x, y + 75, 200, 20).build());
    }

    private Component getStatus(String name, boolean enabled) {
        return Component.literal(
            name + ": " + (enabled ? "ON" : "OFF")
        );
    }

    @Override
    public void render(
        GuiGraphics graphics,
        int mouseX,
        int mouseY,
        float partialTick
    ) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);

        graphics.drawCenteredString(
            this.font,
            "PLINUS VISUAL",
            this.width / 2,
            this.height / 2 - 95,
            0xFFB56AFF
        );

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
