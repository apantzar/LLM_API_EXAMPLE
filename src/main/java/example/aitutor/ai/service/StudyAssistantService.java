package example.aitutor.ai.service;

import example.aitutor.ai.domain.StudyRequest;
import example.aitutor.ai.domain.StudyResponse;

public interface StudyAssistantService {

    StudyResponse handle(StudyRequest request);
}
