package filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Фильтр доступа для неавторизованных пользователей. Если пользователь не залогинился, может увидеть только страницу логина или регистрации
 */
@WebFilter(urlPatterns = "*")
public class AccessFilter implements Filter {
    public static final Logger MEGALOG = LogManager.getLogger(AccessFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);

        String loginURI = ((HttpServletRequest) servletRequest).getContextPath() + "/login";
        String signUpURI = ((HttpServletRequest) servletRequest).getContextPath() + "/signup";
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = ((HttpServletRequest) servletRequest).getRequestURI().equals(loginURI) || ((HttpServletRequest) servletRequest).getRequestURI().equals(signUpURI);

        if(((HttpServletRequest) servletRequest).getRequestURI().matches(".*(css|jpg|png|gif|js)")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (loggedIn || loginRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
           // ((HttpServletResponse) servletResponse).sendRedirect(loginURI);
           // filterChain.doFilter(servletRequest, servletResponse);
            servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        }
}

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

}
