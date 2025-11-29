package com.dhj.ingameime;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.Arrays;

public class Config {
    private static Configuration config;
    public static final String[] CATEGORIES = new String[]{"api", "uiless", "general", "modetext"};

    public static String API_Windows = "TextServiceFramework";
    public static boolean UiLess_Windows = true;

    public static boolean TurnOffOnMouseMove = true;

    public static String AlphaModeText = "A";
    public static String NativeModeText = "中";

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            config.load();
        }
        sync();
    }

    public static void sync() {
        final Property P_API_Windows = config.get(
                CATEGORIES[0],
                "Windows",
                API_Windows,
                "Config the API to use in Windows platform (TextServiceFramework, Imm32)"
        ).setValidValues(new String[]{"TextServiceFramework", "Imm32"}).setRequiresMcRestart(true);
        if (Arrays.stream(P_API_Windows.getValidValues()).noneMatch(it -> it.equals(P_API_Windows.getString()))) {
            P_API_Windows.set(P_API_Windows.getDefault());
        }
        API_Windows = P_API_Windows.getString();

        UiLess_Windows = config.get(
                CATEGORIES[1],
                "Windows",
                UiLess_Windows,
                "Config if render CandidateList in game"
        ).setRequiresMcRestart(true).getBoolean();

        TurnOffOnMouseMove = config.get(
                CATEGORIES[2],
                "TurnOffOnMouseMove",
                TurnOffOnMouseMove,
                "Turn off InputMethod on mouse move"
        ).getBoolean();

        AlphaModeText = config.get(
                CATEGORIES[3],
                "AlphaMode",
                AlphaModeText,
                "Text to display when in Alpha mode"
        ).getString();

        NativeModeText = config.get(
                CATEGORIES[3],
                "NativeMode",
                NativeModeText,
                "Text to display when in Native mode"
        ).getString();

        if (config.hasChanged()) {
            config.save();
        }
    }

    public static Configuration getConfig() {
        return config;
    }
}
