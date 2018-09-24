package ch.fhnw.webfr.flashcard.web.requests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexRequest implements RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Welcome</h3>");
        String url = request.getContextPath() + request.getServletPath();
        writer.append("<p><a href='" + response.encodeURL(url) + "/questionnaires'>All Questionnaires</a></p>");
        writer.append("</body></html>");
    }
}
