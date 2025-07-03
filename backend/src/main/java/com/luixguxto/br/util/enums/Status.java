package com.luixguxto.br.util.enums;

public enum Status {
    ONGOING,
    COMPLETED,
    PAUSED;
    public String getLabel(String lang) {
        return StatusLabelResolver.getLabel(this, lang);
    }
}