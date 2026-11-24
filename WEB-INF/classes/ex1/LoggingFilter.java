package ex1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        String prefix = config.getInitParameter("logPrefix");
        System.out.println(prefix + " LoggingFilter initialized");
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println("Before servlet: " + req.getRequestURL());

        long start = System.nanoTime();

        chain.doFilter(request, response);

        long end = System.nanoTime();

        System.out.println("After servlet: " + req.getRequestURL());
        System.out.println("Execution time: "
                + (end - start) / 1_000_000.0 + " ms");
    }

    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}
