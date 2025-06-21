package org.example.springaichatbot.llm;

import org.springframework.ai.chat.model.ChatResponse;

public interface LlmModelStrategy {

    ChatResponse generateResponse(String userMessage, String model, String systemPrompt);
    ModelProvider getModelProvider();
}
