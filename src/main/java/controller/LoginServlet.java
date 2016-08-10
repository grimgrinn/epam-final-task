package controller;

import entity.User;
import model.ModelUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        HttpSession session = request.getSession(true);
        System.out.println("me in loginservlet!");
        String submit = request.getParameter("submit");
        User currentUser = (User)session.getAttribute("user");

        System.out.println("this is iuser from ligin servlet -> " + currentUser);
        if (submit != null && currentUser ==  null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            ModelUser model = new ModelUser();
            User user = model.login(login, password);
            System.out.println("this is user form IF -> "+ user);
            //String url = request.getParameter("url");
            if (user != null) {
                session.setAttribute("user", user);
                request.setAttribute("successLogin", true);
                System.out.println("everything is ok!, go to main servler!");
                    response.sendRedirect("/");
                    return;
                //}
            } else {
                MEGALOG.info("login attempt");
                request.setAttribute("successLogin", false);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
  }

}
