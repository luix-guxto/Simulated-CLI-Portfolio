package com.luixguxto.br.util.enums;

public enum Level {
    BASIC,
    INTERMEDIATE,
    ADVANCED;
    public String getLabel(String lang){
        return LevelLabelResolver.getLabel(this, lang);
    }
}