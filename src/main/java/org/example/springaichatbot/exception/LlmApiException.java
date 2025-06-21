package org.example.springaichatbot.exception;

public class LlmApiException extends LlmException {
    
    public LlmApiException(String message) {
        super(message);
    }
    
    public LlmApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
