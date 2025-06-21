package org.example.springaichatbot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.example.springaichatbot.llm.ModelProvider;

public record ChatRequest(
    @NotNull
    @Schema(description = "사용자가 입력한 질문")
    String message,

    @Schema(description = "LLM 모델 벤더")
    ModelProvider provider,

    @NotNull
    @Schema(description = "사용할 LLM 모델")
    String model
) {
}
