
package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSession extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");
        String birthday = (String) session.getAttribute("birthday");

        if (name == null || birthday == null) {
            out.println("<h2>Welcome on my site!</h2>");
            out.println("<form method='post'>");
            out.println("Full name: <input name='name' required><br>");
            out.println("Date of birth: <input type='date' name='birthday' required><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        } else {
            LocalDate today = LocalDate.now();
            LocalDate birthDate = LocalDate.parse(birthday);

            LocalDate nextBirthday = birthDate.withYear(today.getYear());

            if (!nextBirthday.isAfter(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }

            long days = ChronoUnit.DAYS.between(today, nextBirthday);

            out.println("<h2>Hi, " + name + ".</h2>");
            out.println("<p>There are " + days +
                        " days to your birthday.</p>");
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.setAttribute("name", request.getParameter("name"));
        session.setAttribute("birthday", request.getParameter("birthday"));

        response.sendRedirect("ShowSession");
    }
}
