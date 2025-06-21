package org.example.springaichatbot.service;

import org.example.springaichatbot.llm.ModelProvider;
import org.springframework.ai.chat.model.ChatResponse;

public interface ChatUseCase {

    ChatResponse getResponse(ModelProvider modelProvider, String model, String userMessage);
}
