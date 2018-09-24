package ch.fhnw.webfr.flashcard.web.requests;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionnaireRequest implements RequestHandler {
    private final QuestionnaireRepository questionnaireRepository;
    private final Long questionnaireId;

    public QuestionnaireRequest(QuestionnaireRepository repository, String id) {
        questionnaireRepository = repository;
        questionnaireId = Long.parseLong(id);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Questionnaire questionnaire;

        try {
            questionnaire = questionnaireRepository.findById(questionnaireId);
        } catch (IndexOutOfBoundsException exception) {
            questionnaire = null;
        }

        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Questionnaire</h3>");

        if (questionnaire == null) {
            writer.append("<h4>Not Found</h4>");
        } else {
            writer.append("<h4>" + questionnaire.getTitle() +"</h4>");
            writer.append("<p>" + questionnaire.getDescription() +"</p>");
        }

        writer.append("</body></html>");
    }
}
