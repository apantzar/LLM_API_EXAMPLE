package example.aitutor.ai.ui;

import example.aitutor.ai.domain.AssistantMode;
import example.aitutor.ai.domain.StudyRequest;
import example.aitutor.ai.domain.StudyResponse;
import example.aitutor.ai.service.StudyAssistantService;

import java.util.Scanner;

public class ConsoleApp {

    private final StudyAssistantService service;

    public ConsoleApp(StudyAssistantService service) {
        this.service = service;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        printMenu();

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you, goodbye");
                break;
            }


            try {

                StudyRequest request = parseInput(input, scanner);
                StudyResponse response = service.handle(request);

                System.out.println("\n--- Response ---");
                System.out.println(response.getContent());
                System.out.println("\nModel: " + response.getModelUsed());


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public void printMenu() {
        System.out.println("=== AI Study Assistant ===");
        System.out.println("Commands:");
        System.out.println("explain <topic>");
        System.out.println("quiz <topic>");
        System.out.println("evaluate <topic>");
        System.out.println("exit");
    }

    private StudyRequest parseInput(String input, Scanner scanner) {
        String[] parts = input.split(" ", 2);

        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid command format");
        }

        String command = parts[0].toLowerCase();
        String topic = parts[1];
        AssistantMode mode;

        switch (command) {
            case "explain":
                mode = AssistantMode.EXPLAIN;
                return new StudyRequest(mode, topic, null);
            case "quiz":
                mode = AssistantMode.QUIZ;
                return new StudyRequest(mode, topic, null);
            case "evaluate":
                mode = AssistantMode.EVALUATE;
                System.out.println("Please enter your answer:");
                String userAnswer = scanner.nextLine();
                return new StudyRequest(mode, topic, userAnswer);
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
