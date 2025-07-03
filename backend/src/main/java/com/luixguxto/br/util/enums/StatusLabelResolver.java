package com.luixguxto.br.util.enums;

import java.util.Map;

public class StatusLabelResolver {

    private static final Map<Status, String> EN = Map.of(
            Status.COMPLETED, "Completed",
            Status.ONGOING, "In progress",
            Status.PAUSED, "Interrupted"
    );

    private static final Map<Status, String> PT = Map.of(
            Status.COMPLETED, "Concluído",
            Status.ONGOING, "Em andamento",
            Status.PAUSED, "Trancado"
    );

    public static String getLabel(Status status, String lang) {
        return lang.equals("pt") ? PT.get(status) : EN.get(status);
    }
}
