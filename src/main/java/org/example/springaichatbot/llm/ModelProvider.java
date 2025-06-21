package org.example.springaichatbot.llm;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.example.springaichatbot.exception.ModelProviderMismatchException;

@Getter
public enum ModelProvider {
    OPEN_AI(Arrays.asList(
        "gpt-3.5-turbo", 
        "gpt-3.5-turbo-16k", 
        "gpt-4", 
        "gpt-4-turbo", 
        "gpt-4o",
        "gpt-4-32k"
    )),
    GEMINI(Arrays.asList(
        "gemini-pro", 
        "gemini-ultra", 
        "gemini-1.5-pro",
        "gemini-1.5-flash",
        "gemini-2.5-pro",
        "gemini-2.5-flash"
    ));
    // ANTHROPIC
    // LLAMA

    private final List<String> supportedModels;

    ModelProvider(List<String> supportedModels) {
        this.supportedModels = supportedModels;
    }

    public void validateModel(String model) {
        if (model == null) {
            throw new ModelProviderMismatchException(this, "null");
        }
        
        boolean isValid = supportedModels.stream()
                .anyMatch(supportedModel -> 
                    model.toLowerCase().startsWith(supportedModel.toLowerCase()));
        
        if (!isValid) {
            throw new ModelProviderMismatchException(this, model);
        }
    }
}
