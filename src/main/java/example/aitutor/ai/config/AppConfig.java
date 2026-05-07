package example.aitutor.ai.config;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {

    private static final Dotenv dotenv = Dotenv.load();

    public AppConfig() {
    }

    public static String getAPIkey() {
        return dotenv.get("OPENAI_API_KEY");
    }

    public static String getModelName() {
        return dotenv.get("MODEL_NAME");
    }

    public static Double getTemperature() {
        return Double.parseDouble(dotenv.get("TEMPERATURE"));
    }
}
