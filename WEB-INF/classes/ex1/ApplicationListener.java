package ex1;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        ServletContext context = event.getServletContext();

        context.setAttribute("appName", "ING1 Web Application");

        System.out.println("Application Started");
    }

    public void contextDestroyed(ServletContextEvent event) {

        System.out.println("Application Stopped");
    }
}
