package com.dhj.ingameime.control;

import com.dhj.ingameime.Internal;

import javax.annotation.Nonnull;
import java.awt.*;
import java.io.IOException;

public class NoControl implements IControl {

    public static final NoControl NO_CONTROL = new NoControl();

    private int x;
    private int y;

    private NoControl() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Object getControlObject() {
        return null;
    }

    @Override
    public void writeText(String text) throws IOException {
        if (Internal.getActivated()) {
            AbstractControl.writeCurrentScreenText(text);
        }
    }

    @Override
    public boolean isVisible() {
        return Internal.getActivated();
    }

    @Nonnull
    @Override
    public Point getCursorPos() {
        return new Point(this.x, this.y);
    }

    public void setCursorX(int x) {
        this.x = x;
    }

    public void setCursorY(int y) {
        this.y = y;
    }
}
