
package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class firstServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDate");
        String sex = request.getParameter("sex");

        Cookie c1 = new Cookie("firstName", firstName);
        Cookie c2 = new Cookie("lastName", lastName);
        Cookie c3 = new Cookie("birthDay", birthDay);
        Cookie c4 = new Cookie("sex", sex);

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.addCookie(c4);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Cookies created successfully!</h2>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Birth Day: " + birthDay + "</p>");
        out.println("<p>Sex: " + sex + "</p>");
        out.println("</body></html>");
    }
}
