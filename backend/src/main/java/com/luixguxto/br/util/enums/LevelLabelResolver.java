package com.luixguxto.br.util.enums;

import java.util.Map;

public class LevelLabelResolver {

    private static final Map<Level, String> EN = Map.of(
            Level.BASIC, "Basic",
            Level.INTERMEDIATE, "Intermediate",
            Level.ADVANCED, "Advanced"
    );

    private static final Map<Level, String> PT = Map.of(
            Level.BASIC, "Basico",
            Level.INTERMEDIATE, "Intermediario",
            Level.ADVANCED, "Avançado"
    );

    public static String getLabel(Level level, String lang) {
        return lang.equals("pt") ? PT.get(level) : EN.get(level);
    }
}