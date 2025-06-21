package org.example.springaichatbot.exception;

public class PromptLoadingException extends LlmException {
    
    public PromptLoadingException(String message) {
        super(message);
    }
    
    public PromptLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
