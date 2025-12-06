package com.dhj.ingameime;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parent) {
        super(parent, getConfigElements(), Tags.MOD_ID, false, false, Tags.MOD_NAME);
    }

    private static @Nonnull List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();
        Configuration config = Config.getConfig();
        for (String category : Config.CATEGORIES) {
            list.addAll(new ConfigElement(config.getCategory(category)).getChildElements());
        }
        return list;
    }
}
