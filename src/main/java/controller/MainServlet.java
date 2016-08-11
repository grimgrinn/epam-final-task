package controller;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * а вот такой невероятный мэин сервлед
 */
public class MainServlet extends HttpServlet{

    private static final Logger MEGALOG = LogManager.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("wea re in main servler now!");

       HttpSession session = request.getSession(false);

        try {
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                System.out.println("suces login");
                response.sendRedirect("/profile?id="+user.getId());
                return;
            } else {
                System.out.println("no!");
            }
        } catch (NullPointerException e) {
            System.out.println("There is no session  - " + e);
            MEGALOG.info("There is no session yet, redirect to login ", e);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

}
