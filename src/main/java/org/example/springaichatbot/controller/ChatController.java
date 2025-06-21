package org.example.springaichatbot.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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

    @Operation(summary = "LLM Chat API")
    @PostMapping("/api/v1/chat")
    public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest request) {
        ChatResponse response = chatUseCase.getResponse(request.provider(), request.model(), request.message());
        return ResponseEntity.ok(response);
    }
}
