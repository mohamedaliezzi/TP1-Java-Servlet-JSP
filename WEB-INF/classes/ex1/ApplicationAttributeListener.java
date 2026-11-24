package ex1;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener
        implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Application attribute added: "
                + event.getName());
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Application attribute replaced: "
                + event.getName());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Application attribute removed: "
                + event.getName());
    }
}
