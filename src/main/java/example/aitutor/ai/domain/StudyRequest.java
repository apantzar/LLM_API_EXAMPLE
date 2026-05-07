package example.aitutor.ai.domain;

public class StudyRequest {
    private final AssistantMode mode;
    private final String topic;
    private final String studentAnswer;

    public StudyRequest(AssistantMode mode, String topic, String studentAnswer) {
        this.mode = mode;
        this.topic = topic;
        this.studentAnswer = studentAnswer;
    }

    public AssistantMode getMode() {
        return mode;
    }

    public String getTopic() {
        return topic;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }
}
