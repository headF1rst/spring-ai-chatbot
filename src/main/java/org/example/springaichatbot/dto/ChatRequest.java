package org.example.springaichatbot.dto;

import java.util.List;

/**
 * Record representing a chat request with user message, stop sequences, and temperature.
 */
public record ChatRequest(
    String message,
    List<String> stop,
    Double temperature
) {
    /**
     * Constructor with default temperature value.
     */
    public ChatRequest(String message, List<String> stop) {
        this(message, stop, 0.7);
    }
}
