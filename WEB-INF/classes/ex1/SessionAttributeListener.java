package ex1;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionAttributeListener
        implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Session attribute added: "
                + event.getName() + " = " + event.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Session attribute replaced: "
                + event.getName());
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Session attribute removed: "
                + event.getName());
    }
}
