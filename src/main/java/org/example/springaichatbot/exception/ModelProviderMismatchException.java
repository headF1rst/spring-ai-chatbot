package org.example.springaichatbot.exception;

import org.example.springaichatbot.llm.ModelProvider;

public class ModelProviderMismatchException extends LlmException {

    public ModelProviderMismatchException(ModelProvider provider, String model) {
        super(String.format("Model '%s' is not compatible with provider '%s'", model, provider));
    }
}
