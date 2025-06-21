package org.example.springaichatbot.llm;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.example.springaichatbot.exception.UnsupportedModelProviderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LlmModelFactory {
    private final Map<ModelProvider, LlmModelStrategy> modelStrategies;

    @Autowired
    public LlmModelFactory(List<LlmModelStrategy> strategies) {
        modelStrategies = new EnumMap<>(ModelProvider.class);

        for (LlmModelStrategy strategy : strategies) {
            modelStrategies.put(strategy.getModelProvider(), strategy);
        }
    }

    public LlmModelStrategy getModelStrategy(ModelProvider modelProvider) {
        LlmModelStrategy strategy = modelStrategies.get(modelProvider);
        if (strategy == null) {
            throw new UnsupportedModelProviderException(modelProvider);
        }
        return strategy;
    }
}
