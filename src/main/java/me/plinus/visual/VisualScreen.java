package me.plinus.visual;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class VisualScreen extends Screen {

    public VisualScreen() {
        super(Component.literal("Plinus Visual"));
    }

    @Override
    public void render(
            GuiGraphics graphics,
            int mouseX,
            int mouseY,
            float partialTick
    ) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        int left = centerX - 150;
        int top = centerY - 100;

        graphics.fill(
            left, top,
            left + 300, top + 200,
            0xEE151515
        );

        graphics.fill(
            left, top,
            left + 300, top + 28,
            0xFF7B35C9
        );

        graphics.drawCenteredString(
            this.font,
            "PLINUS VISUAL",
            centerX,
            top + 9,
            0xFFFFFFFF
        );

        graphics.drawString(
            this.font,
            "Visuals",
            left + 15,
            top + 45,
            0xFFFFFFFF
        );

        graphics.drawString(
            this.font,
            "PvP",
            left + 15,
            top + 70,
            0xFFFFFFFF
        );

        graphics.drawString(
            this.font,
            "YouTuber Tools",
            left + 15,
            top + 95,
            0xFFFFFFFF
        );

        graphics.drawString(
            this.font,
            "Plinus Visual 1.0.0",
            left + 15,
            top + 175,
            0xFFAAAAAA
        );

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
