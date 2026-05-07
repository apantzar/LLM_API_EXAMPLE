package example.aitutor.ai.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class ModelFactory {

    public static ChatLanguageModel createChatModel() {
        return OpenAiChatModel.builder()
                .apiKey(AppConfig.getAPIkey())
                .modelName(AppConfig.getModelName())
                .temperature(AppConfig.getTemperature())
                .build();
    }
}
