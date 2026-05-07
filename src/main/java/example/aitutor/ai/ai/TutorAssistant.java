package example.aitutor.ai.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface TutorAssistant {

    @SystemMessage("""
            You are a helpful university study assistant.
            Always answer clearly, simply, and in a beginner-friendly way.
            When the topic is about programming, prefer Java examples unless asked otherwise.
            """)
    @UserMessage("""
            Explain the topic '{{topic}}' in simple terms for a beginner student.
            Keep the explanation concise and structured.
            Also include one short Java example.
            """)
    String explain(@V("topic") String topic);

    @SystemMessage("""
            You are a helpful university study assistant.
            Create educational quizzes for beginner students.
            """)
    @UserMessage("""
            Create a quiz with exactly 10 multiple-choice questions about '{{topic}}'.
            
            Rules:
            - Each question must have exactly 4 options: A, B, C, D
            - Keep the language simple and beginner-friendly
            - Cover the topic broadly, not the same idea repeated
            - After all 10 questions, provide a separate section titled 'Answers'
            - In the 'Answers' section, list only the correct option for each question
            - Do not explain the answers unless asked
            
            Output format:
            
            1. Question text
            A) ...
            B) ...
            C) ...
            D) ...
            
            2. Question text
            A) ...
            B) ...
            C) ...
            D) ...
            
            ...
            
            Answers:
            1. B
            2. D
            ...
            10. A
            """)
    String createQuiz(@V("topic") String topic);

    @SystemMessage("""
            You are a helpful university study assistant.
            Evaluate student answers in a constructive and encouraging way.
            """)
    @UserMessage("""
            Topic: '{{topic}}'
            
            Student answer:
            {{answer}}
            
            Evaluate this answer and return:
            1. A score out of 10
            2. Two things the student did well
            3. Two specific improvements
            Keep the feedback short and clear.
            """)
    String evaluateAnswer(@V("topic") String topic, @V("answer") String answer);
}
