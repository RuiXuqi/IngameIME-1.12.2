package com.dhj.ingameime.control;

import com.dhj.ingameime.ClientProxy;
import com.dhj.ingameime.mixins.vanilla.AccessorGuiTextField;
import net.minecraft.client.gui.GuiTextField;

import javax.annotation.Nonnull;
import java.awt.*;

public class VanillaTextFieldControl<T extends GuiTextField> extends AbstractControl<GuiTextField> {

    protected VanillaTextFieldControl(T control) {
        super(control);
    }

    @Override
    public boolean isVisible() {
        return this.controlObject.getVisible();
    }

    @Nonnull
    @Override
    public Point getCursorPos() {
        AccessorGuiTextField accessor = (AccessorGuiTextField) this.controlObject;
        return AbstractControl.getCursorPos(
                accessor.getFont(), this.controlObject.getText(),
                this.controlObject.xPosition, this.controlObject.yPosition, this.controlObject.width, this.controlObject.height,
                accessor.getLineScrollOffset(), this.controlObject.getCursorPosition(), this.controlObject.getSelectionEnd(),
                this.controlObject.getEnableBackgroundDrawing()
        );
    }

    /**
     * Try to set the GuiTextField object focus.
     *
     * @param object The field to be set
     * @return Success or not
     */
    @SuppressWarnings("UnusedReturnValue")
    public static boolean onFocusChange(GuiTextField object, boolean focused) {
        ClientProxy.INSTANCE.onControlFocus(new VanillaTextFieldControl<>(object), focused, false);
        return true;
    }
}
