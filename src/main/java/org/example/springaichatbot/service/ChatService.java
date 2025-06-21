package org.example.springaichatbot.config;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springaichatbot.service.ChatUseCase;
import org.example.springaichatbot.util.PromptLoader;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService implements ChatUseCase {
    private final OpenAiApi openAiApi;
    private final PromptLoader promptLoader;

    private static final String OPEN_AI_MODEL = "gpt-3.5-turbo";
    private static final String SYSTEM_PROMPT_PATH = "prompts/system-prompt.md";

    @Override
    public ChatResponse getOpenAiResponse(String userMessage, List<String> stop, Double temperature) {
        String systemPromptContent = promptLoader.loadPrompt(SYSTEM_PROMPT_PATH);
        
        List<Message> messages = List.of(
            SystemMessage.builder()
                .text(systemPromptContent)
                .build(),
            UserMessage.builder()
                .text(userMessage)
                .build()
        );

        ChatOptions chatOptions = ChatOptions.builder()
            .model(OPEN_AI_MODEL)
            .temperature(temperature)
            .stopSequences(stop)
            .build();

        Prompt prompt = Prompt.builder()
            .messages(messages)
            .chatOptions(chatOptions)
            .build();

        OpenAiChatModel chatModel = OpenAiChatModel.builder()
            .openAiApi(openAiApi)
            .build();

        return chatModel.call(prompt);
    }
}
