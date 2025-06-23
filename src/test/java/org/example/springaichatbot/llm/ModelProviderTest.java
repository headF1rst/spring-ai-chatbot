package org.example.springaichatbot.llm;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.example.springaichatbot.exception.ModelProviderMismatchException;
import org.junit.jupiter.api.Test;

class ModelProviderTest {

    @Test
    void validateModel_shouldThrowException_whenModelIsNull() {
        // Arrange
        ModelProvider provider = ModelProvider.OPEN_AI;
        String model = null;

        // Act & Assert
        assertThatThrownBy(() -> provider.validateModel(model))
            .isInstanceOf(ModelProviderMismatchException.class);
    }

    @Test
    void validateModel_shouldThrowException_whenModelIsNotSupportedByProvider() {
        // Arrange
        ModelProvider provider = ModelProvider.OPEN_AI;
        String model = "unsupported-model";

        // Act & Assert
        assertThatThrownBy(() -> provider.validateModel(model))
            .isInstanceOf(ModelProviderMismatchException.class)
            .hasMessageContaining("is not compatible with provider");
    }

    @Test
    void validateModel_shouldNotThrowException_whenModelIsSupportedForOpenAI() {
        // Arrange
        ModelProvider provider = ModelProvider.OPEN_AI;
        String model = "gpt-3.5-turbo";

        // Act & Assert
        assertThatCode(() -> provider.validateModel(model))
            .doesNotThrowAnyException();
    }

    @Test
    void validateModel_shouldNotThrowException_whenModelPartiallyMatchesIgnoreCase() {
        // Arrange
        ModelProvider provider = ModelProvider.GEMINI;
        String model = "GeMiNi-PrO";

        // Act & Assert
        assertThatCode(() -> provider.validateModel(model))
            .doesNotThrowAnyException();
    }

    @Test
    void validateModel_shouldThrowException_whenModelDoesNotMatchAnyGeminiPattern() {
        // Arrange
        ModelProvider provider = ModelProvider.GEMINI;
        String model = "some-other-model";

        // Act & Assert
        assertThatThrownBy(() -> provider.validateModel(model))
            .isInstanceOf(ModelProviderMismatchException.class)
            .hasMessageContaining("is not compatible with provider");
    }

    @Test
    void validateModel_shouldNotThrowException_whenModelMatchesSupportedGeminiModel() {
        // Arrange
        ModelProvider provider = ModelProvider.GEMINI;
        String model = "gemini-2.5-flash";

        // Act & Assert
        assertThatCode(() -> provider.validateModel(model))
            .doesNotThrowAnyException();
    }
}
