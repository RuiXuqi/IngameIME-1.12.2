package com.dhj.ingameime.gui;

import com.dhj.ingameime.Internal;
import ingameime.InputContext;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

public class OverlayScreen extends Widget {
    public WidgetPreEdit PreEdit = new WidgetPreEdit();
    public WidgetCandidateList CandidateList = new WidgetCandidateList();
    public WidgetInputMode WInputMode = new WidgetInputMode();

    @Override
    public boolean isActive() {
        InputContext inputCtx = Internal.InputCtx;
        return inputCtx != null && inputCtx.getActivated();
    }

    @Override
    public void layout() {
        // Container does not need layout
    }

    @Override
    public void draw() {
        if (!isActive()) return;

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);
        GL11.glTranslatef(0, 0, 30f);

        PreEdit.draw();
        CandidateList.draw();
        WInputMode.draw();

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_BLEND);

        GL11.glPopMatrix();
    }

    public void setCaretPos(int x, int y) {
        PreEdit.setPos(x, y);
        CandidateList.setPos(x, y);
        WInputMode.setPos(x, y);
    }
}
