package org.example.springaichatbot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.example.springaichatbot.dto.ChatRequest;
import org.example.springaichatbot.service.ChatUseCase;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatUseCase chatUseCase;

    @Operation(summary = "OpenAI Chat API")
    @ApiResponse(responseCode = "200", description = "Successfully generated AI response")
    @PostMapping("/api/v1/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        ChatResponse response = chatUseCase.getOpenAiResponse(request.message(), request.stop(), request.temperature());
        return ResponseEntity.ok(response);
    }
}
