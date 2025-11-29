package com.dhj.ingameime.control;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.io.IOException;

/**
 * Universal interface for all types of text fields.
 */
public interface IControl {
    @Nullable
    Object getControlObject();

    void writeText(String text) throws IOException;

    boolean isVisible();

    @Nonnull
    Point getCursorPos();
}
