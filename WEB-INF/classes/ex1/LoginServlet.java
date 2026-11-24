package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("user", username);

        PrintWriter out = response.getWriter();

        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h1>Connexion réussie</h1>");
        out.println("<p>Bienvenue " + username + " !</p>");
        out.println("<a href='items.html'>Accéder à la liste des articles</a>");
        out.println("</body></html>");
    }
}
