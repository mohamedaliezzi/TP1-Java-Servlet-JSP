
package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String item = request.getParameter("newItem");
        HttpSession session = request.getSession();

        ArrayList<String> items =
            (ArrayList<String>) session.getAttribute("items");

        if (items == null) {
            items = new ArrayList<String>();
        }

        if (item != null && !item.trim().isEmpty()) {
            items.add(item.trim());
        }

        session.setAttribute("items", items);

        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (String i : items) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
        }

        out.println("<html><body>");
        out.println("<h2>Liste des éléments</h2>");
        out.println("<ul>");

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            out.println("<li>" + entry.getKey() + " - "
                        + entry.getValue() + " fois</li>");
        }

        out.println("</ul>");
        out.println("<a href='items.html'>Ajouter un autre élément</a>");
        out.println("</body></html>");
    }
}
