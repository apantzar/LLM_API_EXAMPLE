package example.aitutor.ai.domain;

public class StudyResponse {

    private final AssistantMode mode;
    private final String content;
    private final String modelUsed;


    public StudyResponse(AssistantMode mode, String content, String modelUsed) {

        this.mode = mode;
        this.content = content;
        this.modelUsed = modelUsed;

    }

    public AssistantMode getMode() {
        return mode;
    }

    public String getContent() {
        return content;
    }

    public String getModelUsed() {
        return modelUsed;
    }

}
