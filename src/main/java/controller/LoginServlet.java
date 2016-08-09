package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import model.ModelUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static final Logger MEGALOG = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);

        String submit = request.getParameter("submit");
        User currentUser = (User)session.getAttribute("user");
        if (submit != null && currentUser ==  null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            ModelUser model = new ModelUser();
            User user = model.login(login, password);

            //String url = request.getParameter("url");
            if (user != null) {
                session.setAttribute("user", user);
                request.setAttribute("successLogin", true);
                // если юзер авторизуется с любой другой страницы - туда его и возвращаем
              //  if (!url.equals("/login")) {
                    response.sendRedirect("/");
                    return;
                //}
            } else {
                MEGALOG.info("login attempt");
                request.setAttribute("successLogin", false);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(request, response);
    //    User user = UserDao.find(username, password);

    /*    if(user != null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/profile.jsp");
        } else {
            request.setAttribute("error","Unknow login, try again");
            request.getRequestDispatcher("/login.jsp");
        }
    */

}





}
