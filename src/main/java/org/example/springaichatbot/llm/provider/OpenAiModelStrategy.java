package org.example.springaichatbot.llm.provider;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springaichatbot.llm.LlmModelStrategy;
import org.example.springaichatbot.llm.ModelProvider;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiModelStrategy implements LlmModelStrategy {
    private final OpenAiApi openAiApi;

    @Override
    public ChatResponse generateResponse(String userMessage, String model, String systemPrompt) {
        List<Message> messages = List.of(
            SystemMessage.builder().text(systemPrompt).build(),
            UserMessage.builder().text(userMessage).build()
        );

        ChatOptions chatOptions = ChatOptions.builder()
            .model(model)
            .build();

        Prompt prompt = Prompt.builder()
            .messages(messages)
            .chatOptions(chatOptions)
            .build();

        OpenAiChatModel chatModel = OpenAiChatModel.builder()
            .openAiApi(openAiApi)
            .build();

        ChatResponse response = chatModel.call(prompt);
        log.info("OpenAI response: {}", response);
        return response;
    }

    @Override
    public ModelProvider getModelProvider() {
        return ModelProvider.OPEN_AI;
    }
}
