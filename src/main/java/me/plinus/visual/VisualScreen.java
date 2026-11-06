
package me.plinus.visual;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class VisualScreen extends Screen {

    public VisualScreen() {
        super(Text.literal("Plinus Visual"));
    }

    @Override
    protected void init() {
        int x = this.width / 2 - 100;
        int y = this.height / 2 - 65;

        addDrawableChild(createButton(
            "Full Bright", FeatureSettings.FULL_BRIGHT,
            x, y, value -> FeatureSettings.FULL_BRIGHT = value
        ));

        addDrawableChild(createButton(
            "Hit Marker", FeatureSettings.HIT_MARKER,
            x, y + 25, value -> FeatureSettings.HIT_MARKER = value
        ));

        addDrawableChild(createButton(
            "Particles", FeatureSettings.PARTICLES,
            x, y + 50, value -> FeatureSettings.PARTICLES = value
        ));

        addDrawableChild(createButton(
            "Waypoints", FeatureSettings.WAYPOINTS,
            x, y + 75, value -> FeatureSettings.WAYPOINTS = value
        ));

        addDrawableChild(createButton(
            "Smooth Animation", FeatureSettings.SMOOTH_ANIMATION,
            x, y + 100, value -> FeatureSettings.SMOOTH_ANIMATION = value
        ));

        addDrawableChild(ButtonWidget.builder(
            Text.literal("Закрыть"),
            button -> close()
        ).dimensions(x, y + 130, 200, 20).build());
    }

    private ButtonWidget createButton(
        String name,
        boolean enabled,
        int x,
        int y,
        java.util.function.Consumer<Boolean> action
    ) {
        return ButtonWidget.builder(
            status(name, enabled),
            button -> {
                boolean next = !enabled;
                action.accept(next);
                button.setMessage(status(name, next));
            }
        ).dimensions(x, y, 200, 20).build();
    }

    private Text status(String name, boolean enabled) {
        return Text.literal(
            name + " [" + (enabled ? "ON" : "OFF") + "]"
        );
    }

    @Override
    public void render(
        DrawContext context,
        int mouseX,
        int mouseY,
        float delta
    ) {
        context.fill(0, 0, width, height, 0x99000000);

        int x = width / 2;
        int y = height / 2;

        context.fill(
            x - 115, y - 105,
            x + 115, y + 160,
            0xEE171717
        );

        context.fill(
            x - 115, y - 105,
            x + 115, y - 75,
            0xFF7736C9
        );

        context.drawCenteredTextWithShadow(
            textRenderer,
            "PLINUS VISUAL",
            x,
            y - 95,
            0xFFFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
