package ex1;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener
        implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("Request attribute added: "
                + event.getName());
    }

    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("Request attribute replaced: "
                + event.getName());
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("Request attribute removed: "
                + event.getName());
    }
}
