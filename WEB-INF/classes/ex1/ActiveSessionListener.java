package ex1;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener,
                                             ServletContextListener {

    private static AtomicInteger counter = new AtomicInteger(0);

    public void contextInitialized(ServletContextEvent event) {
        counter.set(0);
        event.getServletContext().setAttribute("activeSessions", 0);
    }

    public void sessionCreated(HttpSessionEvent event) {
        int active = counter.incrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", active);

        System.out.println("Session created. Active sessions: " + active);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        int active = counter.decrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", active);

        System.out.println("Session destroyed. Active sessions: " + active);
    }
}
