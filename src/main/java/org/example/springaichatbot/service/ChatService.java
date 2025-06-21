package org.example.springaichatbot.service;

import lombok.RequiredArgsConstructor;
import org.example.springaichatbot.llm.LlmModelFactory;
import org.example.springaichatbot.llm.LlmModelStrategy;
import org.example.springaichatbot.llm.ModelProvider;
import org.example.springaichatbot.util.PromptLoader;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class ChatService implements ChatUseCase {
    private final LlmModelFactory modelFactory;
    private final PromptLoader promptLoader;

    private static final String SYSTEM_PROMPT_PATH = "prompts/system-prompt.md";

    @Override
    public ChatResponse getResponse(ModelProvider modelProvider, String model, String userMessage) {
        Assert.notNull(modelProvider, "ModelProvider must not be null.");
        Assert.notNull(model, "Model must not be null.");

        modelProvider.validateModel(model);
        String systemPromptContent = promptLoader.loadPrompt(SYSTEM_PROMPT_PATH);
        LlmModelStrategy modelStrategy = modelFactory.getModelStrategy(modelProvider);

        return modelStrategy.generateResponse(userMessage, model, systemPromptContent);
    }
}
