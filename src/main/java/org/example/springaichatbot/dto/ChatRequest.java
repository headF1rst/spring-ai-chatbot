package org.example.springaichatbot.dto;

import java.util.List;

public record ChatRequest(
    String message,
    List<String> stop,
    Double temperature
) {
}
