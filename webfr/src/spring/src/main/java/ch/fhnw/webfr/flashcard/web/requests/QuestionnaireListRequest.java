package ch.fhnw.webfr.flashcard.web.requests;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QuestionnaireListRequest implements RequestHandler {
    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireListRequest(QuestionnaireRepository repository) {
        questionnaireRepository = repository;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Fragebögen</h3>");
        for (Questionnaire questionnaire : questionnaires) {
            String url = request.getContextPath() + request.getServletPath();
            url = url + "/questionnaires/" + questionnaire.getId().toString();
            writer.append("<p><a href='" + response.encodeURL(url) + "'>" + questionnaire.getTitle() + "</a></p>");
        }
        writer.append("</body></html>");
    }
}
