package org.example.springaichatbot.exception;

import org.example.springaichatbot.llm.ModelProvider;

public class UnsupportedModelProviderException extends LlmException {
    
    public UnsupportedModelProviderException(ModelProvider modelProvider) {
        super("지원하지 않는 모델 벤더: " + modelProvider);
    }
    
    public UnsupportedModelProviderException(String message) {
        super(message);
    }
}
