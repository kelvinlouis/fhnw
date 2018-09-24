package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;
import ch.fhnw.webfr.flashcard.web.requests.IndexRequest;
import ch.fhnw.webfr.flashcard.web.requests.QuestionnaireListRequest;
import ch.fhnw.webfr.flashcard.web.requests.QuestionnaireRequest;
import ch.fhnw.webfr.flashcard.web.requests.RequestHandler;

@SuppressWarnings("serial")
public class BasicServlet extends HttpServlet {
    /*
     * Attention: This repository will be used by all clients, concurrency
     * could be a problem. THIS VERSION IS NOT PRODUCTION READY!
     */
    private QuestionnaireRepository questionnaireRepository;

    private RequestHandler requestHandler;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        String[] pathElements = request.getRequestURI().split("/");
        if (isLastPathElementQuestionnaires(pathElements)) {
            requestHandler = new QuestionnaireListRequest(questionnaireRepository);
        } else if (isLastPathElementQuestionnaire(pathElements)) {
            String id = pathElements[pathElements.length - 1];
            requestHandler = new QuestionnaireRequest(questionnaireRepository, id);
        } else {
            requestHandler = new IndexRequest();
        }

        requestHandler.handleRequest(request, response);
    }

    private boolean isLastPathElementQuestionnaires(String[] pathElements) {
        String last = pathElements[pathElements.length - 1];
        return last.equals("questionnaires");
    }

    private boolean isLastPathElementQuestionnaire(String[] pathElements) {
        String prev = pathElements[pathElements.length - 2];
        String id = pathElements[pathElements.length - 1];
        return prev.equals("questionnaires") && !id.isEmpty();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        questionnaireRepository = new QuestionnaireInitializer().initRepoWithTestData();
    }
}
