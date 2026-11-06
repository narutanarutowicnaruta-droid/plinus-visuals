
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

        addRenderableWidget(createButton(
            "Full Bright",
            FeatureSettings.FULL_BRIGHT,
            x, y,
            value -> FeatureSettings.FULL_BRIGHT = value
        ));

        addRenderableWidget(createButton(
            "Hit Marker",
            FeatureSettings.HIT_MARKER,
            x, y + 25,
            value -> FeatureSettings.HIT_MARKER = value
        ));

        addRenderableWidget(createButton(
            "Particles",
            FeatureSettings.PARTICLES,
            x, y + 50,
            value -> FeatureSettings.PARTICLES = value
        ));

        addRenderableWidget(createButton(
            "Waypoints",
            FeatureSettings.WAYPOINTS,
            x, y + 75,
            value -> FeatureSettings.WAYPOINTS = value
        ));

        addRenderableWidget(createButton(
            "Smooth Animation",
            FeatureSettings.SMOOTH_ANIMATION,
            x, y + 100,
            value -> FeatureSettings.SMOOTH_ANIMATION = value
        ));

        addRenderableWidget(Button.builder(
            Component.literal("Закрыть"),
            button -> onClose()
        ).bounds(x, y + 130, 200, 20).build());
    }

    private Button createButton(
        String name,
        boolean enabled,
        int x,
        int y,
        java.util.function.Consumer<Boolean> action
    ) {
        return Button.builder(
            status(name, enabled),
            button -> {
                boolean next = !enabled;
                action.accept(next);
                button.setMessage(status(name, next));
            }
        ).bounds(x, y, 200, 20).build();
    }

    private Component status(String name, boolean enabled) {
        return Component.literal(
            name + " [" + (enabled ? "ON" : "OFF") + "]"
        );
    }

    @Override
    public void render(
        GuiGraphics graphics,
        int mouseX,
        int mouseY,
        float partialTick
    ) {

        graphics.fill(
            0, 0, width, height,
            0x99000000
        );

        int x = width / 2;
        int y = height / 2;

        graphics.fill(
            x - 115, y - 105,
            x + 115, y + 160,
            0xEE171717
        );

        graphics.fill(
            x - 115, y - 105,
            x + 115, y - 75,
            0xFF7736C9
        );

        graphics.drawCenteredString(
            font,
            "PLINUS VISUAL",
            x,
            y - 95,
            0xFFFFFFFF
        );

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
