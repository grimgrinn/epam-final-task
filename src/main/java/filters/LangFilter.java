package filters;

import languages.Languages;
import model.LanguageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import settings.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Фильтр с установкой типа, кодировки и языка
 */
@WebFilter(urlPatterns = "*")
public class LangFilter implements Filter {
    private static final Logger MEGALOG = LogManager.getLogger(LangFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType(Constants.CONTENT_TYPE);
        servletRequest.setCharacterEncoding(Constants.CONTENT_ENCODING);
        servletResponse.setContentType(Constants.CONTENT_TYPE);
        servletResponse.setCharacterEncoding(Constants.CONTENT_ENCODING);

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(true);
        String langParam = servletRequest.getParameter("lang");
        LanguageModel model = new LanguageModel();
        Languages currentLang = (Languages) session.getAttribute(Constants.SESSION_LANGUAGE_PARAM);
        Languages setLanguage = model.getLanguage(langParam, currentLang);
        session.setAttribute(Constants.SESSION_LANGUAGE_PARAM, setLanguage);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
