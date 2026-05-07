package example.aitutor;

import example.aitutor.ai.service.LangChainStudyAssistantService;
import example.aitutor.ai.service.StudyAssistantService;
import example.aitutor.ai.ui.ConsoleApp;

public class Main {
    public static void main(String[] args) {
        StudyAssistantService service = new LangChainStudyAssistantService();
        ConsoleApp app = new ConsoleApp(service);

        app.start();
    }
}
