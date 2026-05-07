# LLM API Example

Ένα Java application που χρησιμοποιεί LangChain4J και OpenAI API.

## Χαρακτηριστικά

- LangChain4J framework με OpenAI integration
- Console interface
- Environment configuration
- Multiple study modes

## Προαπαιτούμενα

- Java 26
- Maven 3.6+
- OpenAI API Key

## Ρύθμιση

Clone το repository:
```bash
git clone <repository-url>
cd LLM-API-EXAMPLE
```

Δημιουργήστε .env αρχείο:
```bash
cp .env.example .env
```

Ανοίξτε το .env και συμπληρώστε τις παραμέτρους:
```env
OPENAI_API_KEY=your_openai_api_key_here
MODEL_NAME=gpt-4.1-mini
TEMPERATURE=
```

Κατασκευάστε το project:
```bash
mvn clean install
```

## Εκτέλεση

Τρέξτε την εφαρμογή:

```bash
mvn clean compile exec:java -Dexec.mainClass="example.aitutor.Main"
```

Ή μέσω IDE (IntelliJ IDEA / Eclipse):
- Ανοίξτε το Main.java και παίξτε το με Run

## Εξαρτήσεις

| Εξάρτηση | Έκδοση | Σκοπός |
|----------|--------|--------|
| LangChain4J | 0.33.0 | LLM framework |
| LangChain4J OpenAI | 0.33.0 | OpenAI integration |
| dotenv-java | 3.0.0 | Διαχείριση περιβάλλοντος |
| Kotlin | 2.3.10 | Kotlin support (optional) |

## Δομή Project

```
src/main/java/example/aitutor/
├── Main.java
├── ai/
│   ├── config/
│   │   ├── AppConfig.java
│   │   └── ModelFactory.java
│   ├── domain/
│   │   ├── AssistantMode.java
│   │   ├── StudyRequest.java
│   │   └── StudyResponse.java
│   ├── service/
│   │   ├── StudyAssistantService.java
│   │   └── LangChainStudyAssistantService.java
│   └── ui/
│       └── ConsoleApp.java
```

## Άδεια

MIT License




