
package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Cookie Values</h2>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();

                if (name.equals("firstName") ||
                    name.equals("lastName") ||
                    name.equals("birthDay") ||
                    name.equals("sex")) {

                    out.println("<p>" + name + " : "
                                + c.getValue() + "</p>");
                }
            }
        } else {
            out.println("<p>No cookies found!</p>");
        }

        out.println("</body></html>");
    }
}
