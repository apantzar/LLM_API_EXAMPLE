package example.aitutor.ai.service;

import dev.langchain4j.service.AiServices;
import example.aitutor.ai.ai.TutorAssistant;
import example.aitutor.ai.config.AppConfig;
import example.aitutor.ai.config.ModelFactory;
import example.aitutor.ai.domain.AssistantMode;
import example.aitutor.ai.domain.StudyRequest;
import example.aitutor.ai.domain.StudyResponse;

public class LangChainStudyAssistantService implements StudyAssistantService {

    private final TutorAssistant assistant;

    public LangChainStudyAssistantService() {
        assistant = AiServices.builder(TutorAssistant.class)
                .chatLanguageModel(ModelFactory.createChatModel())
                .build();
    }

    public StudyResponse handle(StudyRequest request) {
        String result;

        if (request.getMode() == AssistantMode.EXPLAIN) {
            result = assistant.explain(request.getTopic());
        } else if (request.getMode() == AssistantMode.QUIZ) {
            result = assistant.createQuiz(request.getTopic());
        } else if (request.getMode() == AssistantMode.EVALUATE) {
            result = assistant.evaluateAnswer(request.getTopic(), request.getStudentAnswer());
        } else {
            result = "Unsupported mode";
        }

        return new StudyResponse(
                request.getMode(),
                result,
                "LangChain4j with " + AppConfig.getModelName()
        );
    }
}
