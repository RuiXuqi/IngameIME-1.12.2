package com.dhj.ingameime.control;

import com.dhj.ingameime.ClientProxy;
import com.dhj.ingameime.mixins.flux.AccessorGuiTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import sonar.fluxnetworks.client.gui.basic.GuiTextField;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;

public class FluxTextFieldControl<T extends GuiTextField> extends AbstractControl<GuiTextField> {
    private final @Nullable GuiScreen container;

    protected FluxTextFieldControl(T control, @Nullable GuiScreen container) {
        super(control);
        this.container = container;
    }

    @Override
    public boolean isVisible() {
        return this.controlObject.getVisible();
    }

    @Nonnull
    @Override
    public Point getCursorPos() {
        AccessorGuiTextField accessor = (AccessorGuiTextField) this.controlObject;
        return AbstractControl.getContainerCursorPos(
                this.container, accessor.getFont(), this.controlObject.getText(),
                this.controlObject.x, this.controlObject.y, this.controlObject.width, this.controlObject.height,
                accessor.getLineScrollOffset(), this.controlObject.getCursorPosition(), this.controlObject.getSelectionEnd(),
                true
        );
    }

    /**
     * Try to set the GuiTextField object focus.
     *
     * @param object The field to be set
     */
    public static void onFocusChange(GuiTextField object, boolean focused) {
        ClientProxy.INSTANCE.onControlFocus(new FluxTextFieldControl<>(object, Minecraft.getMinecraft().currentScreen), focused, false);
    }
}
