package org.example.springaichatbot.service;

import java.util.List;
import org.springframework.ai.chat.model.ChatResponse;

public interface ChatUseCase {

    ChatResponse getOpenAiResponse(String userMessage, List<String> stop, Double temperature);
}
